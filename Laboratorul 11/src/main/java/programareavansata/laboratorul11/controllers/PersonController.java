package programareavansata.laboratorul11.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import programareavansata.laboratorul11.entities.Person;
import programareavansata.laboratorul11.repositories.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class PersonController {
    private List<Person> users = new ArrayList<>();
    private PersonRepository repo;

    @Autowired
    public PersonController(PersonRepository repo) {
        this.repo = repo;
    }

    public PersonController() {
        users.add(new Person(2, "Alexandru Ionescu"));
    }

    public PersonController(Person a) {
        users.add(a);
    }

    @GetMapping("/all")
    public List<Person> getAllUsers() {
        users = repo.findAll();
        return repo.findAll();
    }

    @PostMapping("/{name}")
    public String addUser(@PathVariable String name) {
        Integer id = 1 + users.size();
        Person a = new Person(id, name);
        repo.save(a);
        users = repo.findAll();
        return "User has been successfully added";
    }

    @PutMapping("/{id}")
    public String changeName(@PathVariable int id, @RequestParam String name) {
        Optional<Person> exists = repo.findById(id);

        if (exists.isEmpty()) {
            return "There is no user with that name.";
        }
        else {
            Person found = new Person();
            found.setId(id);
            found.setName(name);
            repo.save(found);
            users = repo.findAll();
            return "User's name was changed successfully.";
        }
    }

    @DeleteMapping("/{name}")
    public String deleteUser(@PathVariable String name) {
        Person found = new Person();
        int lg = users.size();
        int i;
        boolean foundIt = false;
        for (i = 1; i <= lg; i++) {
            Person current = users.get(i);
            if (current.getName().equals(name)) {
                found = current;
                foundIt = true;
                break;
            }
        }

        if (foundIt == false) {
            return "There is no user with that name.";
        }
        else {
            users.remove(found);
            repo.delete(found);
            return "User deleted successfully.";
        }
    }
}
