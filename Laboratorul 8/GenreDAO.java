import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GenreDAO {
    private GenreDAO() {

    }

    public static final int getByName(String name) throws SQLException {
        Connection conn = Database.getConnectionToDb();
        int genreId;

        Statement stmt = conn.createStatement();

        ResultSet res = stmt.executeQuery("SELECT id FROM Genre WHERE name = " + name);
        genreId = res.getInt(1);

        conn.close();

        return genreId;
    }

    public static final String getById(int id) throws SQLException {
        Connection conn = Database.getConnectionToDb();
        String title;

        Statement stmt = conn.createStatement();

        ResultSet res = stmt.executeQuery("SELECT name FROM Genre WHERE id = " + id);
        title = res.getString(1);

        conn.close();

        return title;
    }

    public static final void insertGenre(int id, String name) throws SQLException {
        Connection conn = Database.getConnectionToDb();

        Statement stmt = conn.createStatement();

        ResultSet res = stmt.executeQuery("INSERT INTO Genre VALUES(" + id + name + ")");

        conn.close();
    }
}