import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ImportData {
    public ImportData() {

    }

    public void IMDB_Movies() {
        String line = "";
        String splitBy = ",";
        int id = 6;
        int gId = 16;

        try {
            BufferedReader br = new BufferedReader(new FileReader("E:\\IMDb movies.csv"));

            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                //separam intreaga linie si folosim virgula ca separator
                String[] movie = line.split(splitBy);

                //retinem elementele de care avem nevoie din linia respectiva
                int ID = id + 1;
                int gID = gId + 1;
                String title = movie[1];
                String date = movie[4];
                String genre = movie[5];
                int duration = Integer.valueOf(movie[6]);
                int score = 70;

                InsertMovie(ID, title, date, duration, score);
                InsertGenre(gId, genre);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void IMDB_Names() {
        String line = "";
        String splitBy = ",";
        int id = 30;

        try {
            BufferedReader br = new BufferedReader(new FileReader("E:\\IMDb names.csv"));

            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                //separam intreaga linie si folosim virgula ca separator
                String[] name = line.split(splitBy);

                //retinem elementele de care avem nevoie din linia respectiva
                int ID = id + 1;
                String pName = name[1];
                String birth = name[6];
                String death = name[9];
                String nationality = name[7];
                int rank = 6;
                int age;

                /**
                 * calculam varsta
                 * luam anul din data nasterii (separam data dupa separatorul "-" si luam prima valoare
                 * anul mortii este null => 2021 - anul nasterii
                 * altfel anul mortii - anul nasterii
                 */
                String split = "-";
                String date = birth;
                String[] separated = date.split(split);
                int nastere = Integer.valueOf(separated[0]);

                if (death == null) {
                    age = 2021 - nastere;
                } else {
                    date = death;
                    separated = date.split(split);
                    int moarte = Integer.valueOf(separated[0]);

                    age = moarte - nastere;
                }

                InsertPerson(ID, pName, birth, death, age, nationality, rank);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void InsertMovie(int mId, String title, String date, int duration, int score) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDENT", "STUDENT");

            PreparedStatement stmt = con.prepareStatement("INSERT INTO Movie VALUES(?, ?, ?, ?, ?)");
            stmt.setInt(1, mId);
            stmt.setString(2, title);
            stmt.setString(3, date);
            stmt.setInt(4, duration);
            stmt.setInt(5, score);

            stmt.executeUpdate();

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void InsertGenre(int gId, String name) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDENT", "STUDENT");

            PreparedStatement stmt = con.prepareStatement("INSERT INTO Genre VALUES(?, ?)");
            stmt.setInt(1, gId);
            stmt.setString(2, name);

            stmt.executeUpdate();

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void InsertPerson(int id, String name, String birth, String death, int age, String nat, int rank) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDENT", "STUDENT");

            PreparedStatement stmt = con.prepareStatement("INSERT INTO Person VALUES(?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, birth);
            stmt.setString(4, death);
            stmt.setInt(5, age);
            stmt.setString(6, nat);
            stmt.setInt(7, rank);

            stmt.executeUpdate();

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}