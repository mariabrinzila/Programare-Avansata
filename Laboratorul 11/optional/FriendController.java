package programareavansata.laboratorul11.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import programareavansata.laboratorul11.entities.Friend;
import programareavansata.laboratorul11.entities.Person;
import programareavansata.laboratorul11.services.FriendService;
import programareavansata.laboratorul11.utils.ExceptionHandler;

import java.util.*;

@RestController
@RequestMapping("/friends")
public class FriendController {
    private List<Friend> friends = new ArrayList<>();
    private FriendService service;

    @Autowired
    public FriendController(FriendService service) {
        this.service = service;
    }

    public FriendController() {

    }

    @GetMapping("/friendships")
    public Map<String, String> getAllFriendships() {
        return service.listToMap();
    }

    @GetMapping("/all")
    public List<Friend> getAll() {
        return service.friendship();
    }

    @PostMapping("/add")
    public String addFriend(@RequestParam int pId, @RequestParam int fId) {
        friends = service.befriend(pId, fId);
        return "Friendship has been successfully established.";
    }

    @DeleteMapping("/delete")
    public String deleteFriend(@RequestParam int pk) {
        try {
            friends = service.unfriend(pk);
            return "Person unfriended successfully.";
        } catch (Exception e) {
            new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            return ExceptionHandler.internalError(e, "http://localhost:8090/friends/delete");
        }
    }

    @PutMapping("/popular")
    public String getMostPopular(@RequestParam int k) {
        return service.getMostPopular(k);
    }

    @GetMapping("/allPopular")
    public List<Person> getPopularPeople() {
        return service.getPopularPeople();
    }
}
