package Lab01.Stage6;

import java.util.*;

public class Main5 {
    // Test Data for the program
    private static String[] moduleCode = {"ITD2322", "ICT2422", "ITD2321", "ICT2669"};
    private static String[] studentID = {"1", "2", "3", "4", "5", "6", "7", "8"};
    private static int[][] marks = {{30, 40, 50, 60, 45, 55, 65, 75}, // mark for ITD2322
            {80, 70, 60, 40, 34, 56, 78, 90}, // mark for ICT2422
            {76, 45, 67, 89, 12, 45, 67, 54}, // mark for ITD2321
            {56, 76, 54, 55, 50, 43, 66, 44}}; // mark for ICT2669
    private static char[][] marks2 = {{'F', 'D', 'C', 'B', 'C', 'B', 'C', 'A'}, // mark for ITD2322
            {'D', 'B', 'A', 'A', 'F', 'B', 'C', 'C'}, // mark for ICT2422
            {'D', 'B', 'E', 'B', 'C', 'F', 'F', 'D'}, // mark for ITD2321
            {'C', 'B', 'E', 'D', 'C', 'B', 'C', 'A'}}; // mark for ICT2669

    public static void main(String[] argv) {
        if (argv.length != 3) {
            System.out.println("Usage: java Main5 {letter | numeric } {average | median | beststudent} <module code>");
            System.exit(1);
        }
        if (argv[0].equals("numeric")) {
            if (argv[1].equals("average")) {
                System.out.println("The average mark of module " + argv[2] + " = " + calculateModuleAverageMarkNum(argv[1]));
            }

            if (argv[1].equals("median")) {
                System.out.println("The median of module " + argv[2] + " = " + calculateModuleMedianNum(argv[1]));
            }

            if (argv[1].equals("beststudent")) {
                displayBestStudentNum(argv[2]);
            }
        } else if (argv[0].equals("letter")) {
            if (argv[1].equals("average")) {
                System.out.println("The average mark of module " + argv[2] + " = " + calculateModuleAverageMarkLetter(argv[1]));
            }

            if (argv[1].equals("median")) {
                System.out.println("The median of module " + argv[2] + " = " + calculateModuleMedianLetter(argv[1]));
            }

            if (argv[1].equals("beststudent")) {
                displayBestStudentLetter(argv[2]);
            }
        }

    }

    public static double calculateModuleAverageMarkNum(String mCode) {

        // return the average mark of a module (module code as input parameter "mCode")
        int index = getModuleIndex(mCode);
        double result = 0;

        for (int i = 0; i < marks[index].length; i++) {
            result += marks[index][i];
        }

        result /= marks[index].length;

        return result;
    }

    public static double calculateModuleMedianNum(String mCode) {

        // return the median mark of a module (module code as input parameter "mCode")
        int index = getModuleIndex(mCode);
        double median = 0;
        Arrays.sort(marks[index]);

        if (marks[index].length % 2 == 0) {
            median = (marks[index][marks[index].length / 2] + marks[index][(marks[index].length / 2) - 1]) / 2.0;
        } else
            median = marks[index][marks[index].length / 2];

        return median;
    }

    public static void displayBestStudentNum(String mCode) {

        // find the highest mark of a module (module code as input parameter "mCode")
        // then find the studentID(s) of student(s) with the highest mark
        // show the above information in DOS prompt
        int index = getModuleIndex(mCode);
        int highestMark = marks[index][0];

        for (int i = 1; i < marks[index].length; i++) {
            if (highestMark < marks[index][i])
                highestMark = marks[index][i];
        }

        System.out.println("In module " + mCode + ", the following students perform the best:");

        for (int i = 0; i < marks[index].length; i++) {
            if (marks[index][i] == highestMark)
                System.out.println("Student " + (i + 1));
        }
    }


    public static double calculateModuleAverageMarkLetter(String mCode) {

        // return the average mark of a module (module code as input parameter "mCode")
        // numeric average mark is to be returned (since 'A' -> 5, 'B' -> 4, 'C' -> 3 etc..)
        int index = getModuleIndex(mCode);
        double result = 0;

        for (int i = 0; i < marks2[index].length; i++) {
            result += letterToNumeric(marks2[index][i]);
        }

        result /= marks2[index].length;

        return result;
    }

    public static double calculateModuleMedianLetter(String mCode) {

        // return the median mark of a module (module code as input parameter "mCode")
        // numeric median mark is to be returned (since 'A' -> 5, 'B' -> 4, 'C' -> 3 etc..)
        int index = getModuleIndex(mCode);
        double median = 0;
        Arrays.sort(marks2[index]);

        if (marks2[index].length % 2 == 0) {
            median = (letterToNumeric(marks2[index][marks2[index].length / 2]) + letterToNumeric(marks2[index][(marks2[index].length / 2) - 1])) / 2.0;
        } else
            median = letterToNumeric(marks2[index][marks2[index].length / 2]);

        return median;
    }

    public static void displayBestStudentLetter(String mCode) {

        // find the highest mark of a module (module code as input parameter "mCode")
        // then find the studentID(s) of student(s) with the highest mark
        // show the above information in DOS prompt

        // numeric highest mark is to be returned (since 'A' -> 5, 'B' -> 4, 'C' -> 3 etc..)
        int index = getModuleIndex(mCode);
        int highestMark = letterToNumeric(marks2[index][0]);

        for (int i = 1; i < marks2[index].length; i++) {
            if (highestMark < letterToNumeric(marks2[index][i]))
                highestMark = letterToNumeric(marks2[index][i]);
        }

        System.out.println("In module " + mCode + ", the following students perform the best:");

        for (int i = 0; i < marks2[index].length; i++) {
            if (letterToNumeric(marks2[index][i]) == highestMark)
                System.out.println("Student " + (i + 1));
        }
    }

    public static int letterToNumeric(char grade) {

        // convert and return a numeric mark from a grade (grade as input pararmeter "grade")

        // you need to call this method before doing any calculations on marks
        switch (grade) {
            case 'A':
                return 5;
            case 'B':
                return 4;
            case 'C':
                return 3;
            case 'D':
                return 2;
            case 'E':
                return 1;
            case 'F':
                return 0;
            default:
                return 0;
        }
    }

    public static int getModuleIndex(String mCode) {

        // return the index of a module (module code as input parameter "mCode") in the array of moduleCode

        // You may need to call this method when you want to find the average mark, the median
        // or the best student of a module.
        switch (mCode) {
            case "ITD2322":
                return 0;
            case "ICT2422":
                return 1;
            case "ITD2321":
                return 2;
            case "ICT2669":
                return 3;
            default:
                return 0;
        }
    }
}
