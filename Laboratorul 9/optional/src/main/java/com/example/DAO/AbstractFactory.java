package com.example.DAO;

import java.io.Serializable;
import java.sql.*;

public abstract class AbstractFactory<T> implements Serializable {
    private static Connection conn = null;
    private static String url;
    private static String username;
    private static String passwd;
    protected Class<T> entity;

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

    public int getByName(String name) throws SQLException {
        int id;
        Statement stmt = conn.createStatement();

        String query = "SELECT id FROM " + entity.getSimpleName() + "WHERE name = " + name;
        ResultSet res = stmt.executeQuery(query);
        id = res.getInt(1);

        conn.close();
        return id;
    }

    public String getById(int id) throws SQLException {
        String name;
        Statement stmt = conn.createStatement();

        String query = "SELECT name FROM " + entity.getSimpleName() + "WHERE id = " + id;
        ResultSet res = stmt.executeQuery(query);
        name = res.getString(1);

        conn.close();
        return name;
    }

    public int delete(String condition) throws SQLException {
        Statement stmt = conn.createStatement();

        String query = "DELETE FROM " + entity.getSimpleName() + " WHERE " + condition;
        int nrRows = stmt.executeUpdate(query);

        conn.close();
        return nrRows;
    }
}
