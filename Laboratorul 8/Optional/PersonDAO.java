import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonDAO {
    private PersonDAO() {

    }

    public static final void insertPerson(int id, String fullName, String birth, String death, int age, String nationality, int rank) throws SQLException {
        Connection conn = Database.getConnectionToDb();

        Statement stmt = conn.createStatement();

        ResultSet res = stmt.executeQuery("INSERT INTO Person VALUES(" + id + fullName + birth + death + age + nationality + rank + ")");

        conn.close();
    }

    public static final int getByName(String name) throws SQLException {
        Connection conn = Database.getConnectionToDb();
        int personId;

        Statement stmt = conn.createStatement();

        ResultSet res = stmt.executeQuery("SELECT id FROM Person WHERE fullName = " + name);
        personId = res.getInt(1);

        conn.close();

        return personId;
    }
}
