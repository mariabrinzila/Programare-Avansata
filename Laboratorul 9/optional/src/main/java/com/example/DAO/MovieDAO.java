package com.example.DAO;

import com.example.entity.MovieEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MovieDAO extends AbstractFactory<MovieEntity> {
    public MovieDAO() {

    }

    public void insertMovie(int id, String title, String date, int duration, int score) throws SQLException {
        Connection conn = getConnectionToDb();

        Statement stmt = conn.createStatement();

        ResultSet res = stmt.executeQuery("INSERT INTO Movie VALUES(" + id + title + date + duration + score + ")");

        conn.close();
    }
}
