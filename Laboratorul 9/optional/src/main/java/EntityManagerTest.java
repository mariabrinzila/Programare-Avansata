import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerTest {
    private static EntityManagerFactory entFact;
    private static EntityManager entMng;

    private EntityManagerTest() {

    }

    public static EntityManagerFactory getEntityFactory() {
        entFact = Persistence.createEntityManagerFactory("Demo");
        return entFact;
    }

    public static EntityManager getEntityManager() {
        entMng = entFact.createEntityManager();
        return entMng;
    }

    public static void closeEntityFactory() {
        entFact.close();
    }

    public static void closeEntityManager() {
        entMng.close();
    }
}
