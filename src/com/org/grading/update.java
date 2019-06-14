package com.org.grading;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import static java.lang.Class.forName;

public class update {

    public update() {

    }

    public void updateDetails() {


        Scanner scanner = new Scanner(System.in);
        System.out.println("YOU ARE UPDATING THE STUDENTS DETAILS  :");


        System.out.println("ENTER STUDENT REG NUMBER TO UPDATE THE DETAILS    :");
        String reg = scanner.next();
        System.out.println("ENTER FIRST NAME    :");
        String firstname = scanner.next();
        System.out.println("ENTER LAST NAME    :");
        String lastname = scanner.next();
        System.out.println("ENTER NATIONAL ID  :");
        String nationalId = scanner.next();
        System.out.println("ENTER NATIONAL ID  :");
        String createdOn = scanner.next();
        System.out.println("DATE OF CREATION   :");
        String date = scanner.next();
        try {
            connection cb = new connection();
            cb.getConnection();
            Connection connection;

            String sql;
            sql = " update register set firstname=?,lastname=?,nationalId=?,createdOn=? WHERE regNumber=?";

            String db = "jdbc:mysql://localhost:3306/grading";
            String username = "root";
            String passwordD = "";
            forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(db, username, passwordD);
            PreparedStatement preparedstatement;

            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1, firstname);
            preparedstatement.setString(2, lastname);
            preparedstatement.setString(3, nationalId);
            preparedstatement.setString(4, createdOn);


            preparedstatement.executeUpdate();

            System.out.println("DETAILS UPDATE SUCCESSFUL");

            System.out.println("ENTER VALUE -1 TO BREAK THE OPERATION");
            String br = scanner.next();
            if (br == "-1") {

                javasecond nnn = new javasecond();
                nnn.getParameters();

            } else {

                updateDetails();
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}
