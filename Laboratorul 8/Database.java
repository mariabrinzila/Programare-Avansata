import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection conn = null;
    private static String url;
    private static String username;
    private static String passwd;

    private Database() {
    }

    public static Connection getConnectionToDb() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            url = "jdbc:oracle:thin:@localhost:1521:xe";
            username = "STUDENT";
            passwd = "STUDENT";
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
