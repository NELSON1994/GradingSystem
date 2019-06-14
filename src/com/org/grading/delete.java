package com.org.grading;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.Class.forName;

public class delete {

    String regno;

    public delete() {


    }

    public void deleteStudent() throws SQLException, ClassNotFoundException {


        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("ENTER THE LIBRARIAN ID TO DELETE  :");
            String regNumber = scanner.next();
            //delete statement
            String sql;
            sql = "DELETE FROM register WHERE regNumber=?";
            Connection connection;
            String db = "jdbc:mysql://localhost:3306/grading";
            String username = "root";
            String passwordD = "";
            forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(db, username, passwordD);
            PreparedStatement preparedstatement;

            preparedstatement = connection.prepareStatement(sql);

            preparedstatement.setString(1, regNumber);


            preparedstatement.executeUpdate();

            System.out.println("DETAILS DELETED SUCCESSFUL");

            System.out.println("ENTER VALUE -1 TO BREAK THE OPERATION");
            String br = scanner.next();
            if (br == "-1") {

                javasecond nnn = new javasecond();
                nnn.getParameters();

            } else {

                deleteStudent();
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}
