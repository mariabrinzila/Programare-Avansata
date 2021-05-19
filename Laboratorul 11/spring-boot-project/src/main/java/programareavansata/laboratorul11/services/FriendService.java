package programareavansata.laboratorul11.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import programareavansata.laboratorul11.entities.Friend;
import programareavansata.laboratorul11.entities.Person;
import programareavansata.laboratorul11.repositories.FriendRepository;
import programareavansata.laboratorul11.repositories.PersonRepository;

import java.util.*;

@Service
public class FriendService {
    private FriendRepository repo;
    private PersonRepository pRepo;
    private Map<String, String> friendships = new HashMap<>();
    private boolean[][] graph = new boolean[1000][1000];
    private boolean[] viz = new boolean[1000];
    private int[] connected = new int[1000];
    private int nr = 0;
    private int lg = 0;
    private List<Person> res = new ArrayList<>();

    @Autowired
    public FriendService(FriendRepository repo, PersonRepository pRepo) {
        this.repo = repo;
        this.pRepo = pRepo;
    }

    public List<Friend> befriend(int pId, int fId) {
        List<Friend> friends = repo.findAll();
        Integer pk = 1 + friends.size();
        Friend f = new Friend(pId, fId);
        f.setId(pk);

        repo.save(f);
        friends = repo.findAll();

        return friends;
    }

    public Map<String, String> listToMap() {
        List<Friend> friends = repo.findAll();
        int i, lg = friends.size();

        for (i = 0; i < lg; i++) {
            Optional<Person> id1 = pRepo.findById(friends.get(i).getPerson_id());
            Optional<Person> id2 = pRepo.findById(friends.get(i).getFriend_id());

            friendships.put(id1.get().getName(), id2.get().getName());
        }

        return friendships;
    }

    public List<Friend> friendship() {
        List<Friend> fr = repo.findAll();
        return fr;
    }

    public List<Friend> unfriend(Integer pk) {
        Optional<Friend> f = repo.findById(pk);
        repo.delete(f.get());
        List<Friend> fr = repo.findAll();
        return fr;
    }

    public List<Person> getPopularPeople() {
        return res;
    }

    public String getMostPopular(int k) {
        List<Person> total = pRepo.findAll();
        List<Friend> fr = repo.findAll();
        int i, id1, id2;
        lg = total.size();
        int L = fr.size();

        for (i = 0; i < L; i++) {
            Friend current = fr.get(i);
            id1 = current.getPerson_id();
            id2 = current.getFriend_id();
            graph[id1][id2] = true;
            graph[id2][id1] = true;
        }

        for (i = 1; i <= lg; i++) {
            if (!viz[i]) {
                dfs(i);
            }
        }

        if (k > nr)
            return "The k parameter is too big (there are less people in the network than k).";

        for (i = 0; i < k; i++) {
            Optional<Person> p = pRepo.findById(connected[i]);
            res.add(p.get());
        }

        return "Generated the first k most connected people in the network.";
    }

    public void dfs(int vf) {
        int i, j;
        viz[vf] = true; connected[nr++] = vf;

        for (i = 1; i <= lg; i++)
            if (graph[vf][i] && !viz[i])
                dfs(i);
    }
}