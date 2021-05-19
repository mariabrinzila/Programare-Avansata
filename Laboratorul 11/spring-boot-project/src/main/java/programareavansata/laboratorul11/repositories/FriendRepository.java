package programareavansata.laboratorul11.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import programareavansata.laboratorul11.entities.Friend;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer> {
}