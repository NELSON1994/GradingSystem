package com.org.grading;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.Class.forName;

public class register {

    String firstname;
    //String firstname;
    String lastname;
    String nationalId;
    String regNumber;
    String createdOn;

    public register() {

    }


    public void registerStudent() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER FIRST NAME    :");
        String firstname = scanner.next();
        System.out.println("ENTER LAST NAME    :");
        String lastname = scanner.next();
        System.out.println("ENTER NATIONAL ID  :");
        String nationalId = scanner.next();
        System.out.println("ENTER STUDENT REG NUMBER    :");
        String reg = scanner.next();
        System.out.println("DATE OF CREATION   :");
        String date = scanner.next();


        //System.out.println(firstname);

        if (firstname.isEmpty() || lastname.isEmpty() || nationalId.isEmpty() || reg.isEmpty() || date.isEmpty()) {

            System.out.println("ENTER ALL THE DETAILS ");
        } else {
            //used to insert data to the database1

            //import connection class
            connection con = new connection();
            con.getConnection();


            //creating the sql statement
            try {
                Connection connection;
                String db = "jdbc:mysql://localhost:3306/grading";
                String username = "root";
                String passwordD = "";
                forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(db, username, passwordD);
                PreparedStatement preparedstatement;

                String sql;
                sql = "insert  into register (firstname,lastname,nationalId,regNumber,createdOn) VALUES ('" + firstname + "','" + lastname + "','" + nationalId + "','" + reg + "','" + date + "')";
                preparedstatement = connection.prepareStatement(sql);

                preparedstatement.executeUpdate();

                System.out.println("YOU HAVE SUCCESFULLY REGISTERED THE STUDENT");


                System.out.println("ENTER VALUE -1 TO BREAK THE OPERATION");
                String br = scanner.next();
                if (br == "-1") {

                    javasecond nnn = new javasecond();
                    nnn.getParameters();

                } else {

                    registerStudent();
                }


            } catch (SQLException e) {

                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }


    }
}
