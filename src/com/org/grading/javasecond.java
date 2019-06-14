package com.org.grading;

import java.sql.SQLException;
import java.util.Scanner;

public class javasecond {

    public javasecond() {


    }

    public void getParameters() throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER THE ACTION YOU WISH TO PERFORM :");
        System.out.println("\n ENTER VALUE 1 TO REGISTER STUDENT:" +
                "\n ENTER VALUE 2 TO DELETE A STUDENT : " +
                "\n ENTER VALUE 3 TO DISPLAY STUDENT DETAILS BY REG NUMBER : " +
                "\n ENTER VALUE 4 TO ENTER THE RESULT : " +
                "\n ENTER VALUE 5 TO UPDATE STUDENT DETAILS :  " +
                "\n ENTER VALUE 6 TO CREATE TABLE:  " +
                "\n ENTER VALUE 7 TO DISPLAY ALL STUDENT RESULTS : " +
                "\n ENTER VALUE 8 TO DROP TABLE :");

        int role = scanner.nextInt();
//switch statement for the selection


        switch (role) {

            case 1:
                register regg = new register();
                regg.registerStudent();
                break;

            case 2:
                delete dl = new delete();
                dl.deleteStudent();

                break;

            case 3:
                retrieve rt = new retrieve();
                rt.retrieveDetails();
                break;

            case 4:
                grading gd = new grading();
                gd.gradeStudent();
                break;

            case 5:
                update upd = new update();
                upd.updateDetails();

                break;

            case 6:

                break;

            case 7:
                retrieveAll rtA = new retrieveAll();
                rtA.retrieveAllDetails();

                break;

            default:

                System.exit(0);

        }


    }
}
