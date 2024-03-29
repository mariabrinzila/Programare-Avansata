package programareavansata.laboratorul11.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import programareavansata.laboratorul11.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
