import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conn = Database.getConnectionToDb();

        Statement s = conn.createStatement();

        ResultSet r = s.executeQuery("SELECT * FROM Movie");

        while (r.next()) {
            System.out.println(r.getInt(1));
        }

        MovieDAO.insertMovie(6, "Gilmore Girls", "12/03/2000", 240, 35);
        GenreDAO.insertGenre(16, "Documentary");

        String movieTitle = MovieDAO.getById(2);
        System.out.println(movieTitle);

        int movieId = MovieDAO.getByTitle("Gilmore Girls");
        System.out.println(movieId);

        String genreName = GenreDAO.getById(16);
        System.out.println(genreName);

        int genreId = GenreDAO.getByName("Mystery");
        System.out.println(genreId);

        conn.close();
    }
}
