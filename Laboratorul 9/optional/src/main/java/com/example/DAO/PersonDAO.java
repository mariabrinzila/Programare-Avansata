package com.example.DAO;

import com.example.entity.PersonEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonDAO extends AbstractFactory<PersonEntity> {
    public PersonDAO() {

    }

    public void insertPerson(int id, String fullName, String birth, String death, int age, String nationality, int rank) throws SQLException {
        Connection conn = getConnectionToDb();

        Statement stmt = conn.createStatement();

        ResultSet res = stmt.executeQuery("INSERT INTO Person VALUES(" + id + fullName + birth + death + age + nationality + rank + ")");

        conn.close();
    }
}
