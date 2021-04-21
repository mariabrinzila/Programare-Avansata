import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MovieDAO {
    private MovieDAO() {

    }

    public static final int getByTitle(String name) throws SQLException {
        Connection conn = Database.getConnectionToDb();
        int movieId;

        Statement stmt = conn.createStatement();

        ResultSet res = stmt.executeQuery("SELECT id FROM Movie WHERE title = " + name);
        movieId = res.getInt(1);

        conn.close();

        return movieId;
    }

    public static final String getById(int id) throws SQLException {
        Connection conn = Database.getConnectionToDb();
        String title;

        Statement stmt = conn.createStatement();

        ResultSet res = stmt.executeQuery("SELECT title FROM Movie WHERE id = " + id);
        title = res.getString(1);

        conn.close();

        return title;
    }

    public static final void insertMovie(int id, String title, String date, int duration, int score) throws SQLException {
        Connection conn = Database.getConnectionToDb();

        Statement stmt = conn.createStatement();

        ResultSet res = stmt.executeQuery("INSERT INTO Movie VALUES(" + id + title + date + duration + score + ")");

        conn.close();
    }
}
