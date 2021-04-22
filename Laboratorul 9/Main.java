import com.example.entity.GenreEntity;
import com.example.entity.MovieEntity;
import com.example.entity.PersonEntity;
import com.example.repository.MovieRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main( String[] args) {
        PersonEntity p = new PersonEntity();
        p.setId(10);
        p.setFullname("Angelina Jolie");
        Time date = Time.valueOf("20/03/1890");
        p.setBirthdate(date);
        date = null;
        p.setDeathdate(date);
        p.setNationality("american");
        p.setRank(Long.valueOf(67));

        EntityManagerFactory emf = EntityManagerTest.getEntityFactory();
        EntityManager em = EntityManagerTest.getEntityManager();

        MovieRepository m = new MovieRepository(emf, em);
        date = Time.valueOf("13/06/2008");
        m.create(Long.valueOf(8), "Avatar", date, Long.valueOf(135), Long.valueOf(23));

        MovieEntity found = new MovieEntity();
        found = m.findById(Long.valueOf(4));
        System.out.println(found.getTitle());

        List<MovieEntity> lista = m.findByName("Avatar");
        System.out.println(lista.size());

        EntityManagerTest.closeEntityManager();
        EntityManagerTest.closeEntityFactory();
    }
}
