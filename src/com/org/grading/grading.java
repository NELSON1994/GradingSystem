package com.org.grading;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.Class.forName;

public class grading {

    public grading() {

    }


    public void gradeStudent() throws SQLException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER STUDENT REG NUMBER  >>>    :");
        String regno = scanner.next();
        System.out.println("ENTER THE MARKS ATTAINED    :");
        int marks = scanner.nextInt();
        String status = null;
        if (marks < 40) {
            status = "FAILED";
        } else {
            status = "PASSED";
        }
        int markscase = marks / 10;
        String grade = null;
        switch (marks) {

            case 8:
                grade = "A";//
                break;
            case 7:
                grade = "B";
                break;
            case 6:
                grade = "B";
                break;

            case 5:
                grade = "C";
                break;


            case 4:
                grade = "C";
                break;

            case 3:
                grade = "D";
                break;
        }
        try {
            Connection connection;
            String db = "jdbc:mysql://localhost:3306/grading";
            String username = "root";
            String passwordD = "";
            forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(db, username, passwordD);
            PreparedStatement preparedstatement;

            String sql;
            sql = "insert  into studentresult (regNumber,marks,grade,status) VALUES ('" + regno + "','" + marks + "','" + grade + "','" + status + "')";
            preparedstatement = connection.prepareStatement(sql);

            preparedstatement.executeUpdate();

            System.out.println("YOU HAVE SUCCESFULLY ENTERED THE STUDENT MARKS");


        } catch (SQLException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
