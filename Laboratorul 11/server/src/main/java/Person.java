import java.util.ArrayList;
import java.util.List;

public class Person {
    private int id;
    private String name;
    private ArrayList<Person> friends = new ArrayList<Person>();
    private String receivedMessage;

    public Person() {
    }

    public void addFriend(Person other) {
        this.friends.add(other);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Person> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<Person> friends) {
        this.friends = friends;
    }

    public String getReceivedMessage() {
        return receivedMessage;
    }

    public void setReceivedMessage(String receivedMessage) {
        this.receivedMessage = receivedMessage;
    }
}
