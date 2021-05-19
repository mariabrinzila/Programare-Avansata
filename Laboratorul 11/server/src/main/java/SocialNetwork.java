import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
    ArrayList<Person> users = new ArrayList<Person>();

    public SocialNetwork() {

    }

    public void addUser(String name, int id) {
        Person a = new Person();
        a.setId(id);
        a.setName(name);
        users.add(a);
    }

    public void createFriendship(Person a, Person b) {
        //person a becomes friends with person b
        a.addFriend(b);
    }

    public ArrayList<Person> getFriends() {
        return this.getFriends();
    }

    public ArrayList<Person> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Person> users) {
        this.users = users;
    }
}