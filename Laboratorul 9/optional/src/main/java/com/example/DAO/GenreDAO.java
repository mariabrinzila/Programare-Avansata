package com.example.DAO;

import com.example.entity.GenreEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GenreDAO extends AbstractFactory<GenreEntity> {
    public GenreDAO() {

    }

    public void insertGenre(int id, String name) throws SQLException {
        Connection conn = getConnectionToDb();

        Statement stmt = conn.createStatement();

        ResultSet res = stmt.executeQuery("INSERT INTO Genre VALUES(" + id + name + ")");

        conn.close();
    }
}
