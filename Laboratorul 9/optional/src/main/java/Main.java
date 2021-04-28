import com.example.entity.ChartEntity;
import com.example.entity.MovieEntity;
import com.example.entity.PersonEntity;
import com.example.repository.MovieRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
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

        /**
         * create chart entity
         * set the approach to jdbc
         */
        ChartEntity c = new ChartEntity();
        String fileName = "file.txt";
        String approach = "jdbc";

        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(approach);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * set jdbc/jpa approach in the entity
         */
        File in = new File(fileName);
        c.setJpa(in);
    }
}
