package com.org.grading;

import java.sql.*;
import java.util.Scanner;

import static java.lang.Class.forName;

public class retrieve {
    String regNumber;

    public retrieve() {


    }

    public void retrieveDetails() throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER THE STUDENT REGISTRATION NUMBER  >>>>>>");
        String regNumber = scanner.next();


        try {

            Connection conn;
            connection cv = new connection();
            cv.getConnection();

            String db = "jdbc:mysql://localhost:3306/grading";
            String username = "root";
            String passwordD = "";
            forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(db, username, passwordD);

            String sql;
            sql = "select * from register where regNumber=?";
            PreparedStatement preparedstatement = null;
            preparedstatement = conn.prepareStatement(sql);

            ResultSet rs = null;
            preparedstatement.setString(1, regNumber);
            rs = preparedstatement.executeQuery();
            while (rs.next()) {
                String one = (rs.getString("firstname"));
                String JJ = (rs.getString("lastname"));
                String Mn = (rs.getString("nationalId"));
                String bb = (rs.getString("regNumber"));
                String nn = (rs.getString("createdOn"));


                System.out.println(one + "" + JJ + "" + Mn + "" + bb + "" + nn);
                System.out.println("first name  :" + one);
                System.out.println("last name  :" + JJ);
                System.out.println("national id number  :" + Mn);
                System.out.println("Reg number  :" + bb);
                System.out.println("Created On  :" + nn);


                System.out.println("ENTER VALUE -1 TO BREAK THE OPERATION");
                String br = scanner.next();
                if (br == "-1") {

                    javasecond nnn = new javasecond();
                    nnn.getParameters();

                } else {
                    retrieveDetails();
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }


    }
}
