package com.org.grading;

import java.sql.*;
import java.util.Scanner;

import static java.lang.Class.forName;

public class retrieveAll {


    public retrieveAll() {

    }

    public void retrieveAllDetails() throws ClassNotFoundException, SQLException {


        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("ENTER THE STUDENT REGISTRATION NUMBER  >>>>>>");
            String regNumber = scanner.next();
            Connection conn;
            connection cv = new connection();
            cv.getConnection();

            String db = "jdbc:mysql://localhost:3306/grading";
            String username = "root";
            String passwordD = "";
            forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(db, username, passwordD);

            String sql;
            sql = "select  register.firstname,register.lastname,register.nationalId,register.regNumber,studentresult.marks,studentresult.grade,studentresult.status, register.createdOn from register,studentresult" +
                    " where register.regNumber=studentresult.regNumber";
            PreparedStatement preparedstatement = null;
            preparedstatement = conn.prepareStatement(sql);

            ResultSet rs = null;
            preparedstatement.setString(1, regNumber);
            rs = preparedstatement.executeQuery();
            while (rs.next()) {
                String one = (rs.getString("firstname"));
                String JJ = (rs.getString("lastname"));
                String Mn = (rs.getString("marks"));
                String bb = (rs.getString("grade"));

                String nn = (rs.getString("status"));
                String oo = (rs.getString("createdOn"));


                System.out.println("first name  :" + one);
                System.out.println("last name  :" + JJ);
                System.out.println("marks  :" + Mn);
                System.out.println("grade  :" + bb);
                System.out.println("status  :" + nn);

                System.out.println("Created On  :" + oo);

            }
        } catch (Exception e) {

            e.printStackTrace();

        }
    }

}
