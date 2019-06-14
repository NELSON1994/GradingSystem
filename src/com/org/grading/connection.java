package com.org.grading;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import static java.lang.Class.forName;

public class connection {
    Connection connection;


    public void getConnection() {


        try {
            String db = "jdbc:mysql://localhost:3306/grading";
            String username = "root";
            String password = "";
            forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(db, username, password);
        } catch (Exception e) {

            e.printStackTrace();

        }
    }

}
