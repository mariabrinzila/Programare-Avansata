package com.example.DAO;

import com.example.entity.ChartEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChartDAO extends AbstractFactory<ChartEntity> {
    public ChartDAO() {

    }

    public void insertChart(int id, String name, String creation) throws SQLException {
        Connection conn = getConnectionToDb();

        Statement stmt = conn.createStatement();

        ResultSet res = stmt.executeQuery("INSERT INTO Chart VALUES(" + id + name + creation +")");

        conn.close();
    }
}
