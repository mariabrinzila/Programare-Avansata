package programareavansata.laboratorul11.entities;

import javax.persistence.*;

@Entity
public class Friend {
    @Id
    Integer id;

    Integer person_id;
    Integer friend_id;

    public Friend() {

    }

    public Friend(Integer id1, Integer id2) {
        this.person_id = id1;
        this.friend_id = id2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public Integer getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(Integer friend_id) {
        this.friend_id = friend_id;
    }
}