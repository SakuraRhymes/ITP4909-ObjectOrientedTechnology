package Lab01.Stage3;

import java.util.Arrays;

public class Main3 {

    // create a private static data member of GRSData object
    // (You need to call the methods of GRSData when you find the average mark, median or
    //  best student(s) of a module
    private static GRSData GRSData = new GRSData();


    public static void main(String[] argv) {

        if (argv.length != 2) {
            System.out.println("Usage: java Main3 {average | median | beststudent} <module code>");
            System.exit(1);
        }

        // if the user wants to find the average mark of a module,
        // call the calculateModuleAverageMark method and show the result in DOS prompt
        if (argv[0].equals("average")) {
            System.out.println("The average mark of module " + argv[1] + " = " + calculateModuleAverageMark(argv[1]));
        }

        // else if the user wants to find the median mark of a module,
        // call the calculateModuleMedian method and show the result in DOS prompt
        if (argv[0].equals("median")) {
            System.out.println("The median of module " + argv[1] + " = " + calculateModuleMedian(argv[1]));
        }

        // else if the user wants to find the best students (may have more than 1 best student) of a module,
        // call the displayBestStudent method
        if (argv[0].equals("beststudent")) {
            displayBestStudent(argv[1]);
        }

        // else show the message on how to run the program in DOS prompt and exit the program

    }

    public static double calculateModuleAverageMark(String mCode) {

        // return the average mark of a module (module code as input parameter "mCode")
        int[] marks = GRSData.getModuleMark(mCode);
        double result = 0;

        for (int i = 0; i < marks.length; i++) {
            result += marks[i];
        }

        result /= marks.length;

        return result;
    }

    public static double calculateModuleMedian(String mCode) {

        // return the median mark of a module (module code as input parameter "mCode")
        int[] marks = GRSData.getModuleMark(mCode);
        double median = 0;
        Arrays.sort(marks);

        if (marks.length % 2 == 0) {
            median = (marks[marks.length / 2] + marks[(marks.length / 2) - 1]) / 2.0;
        } else
            median = marks[marks.length / 2];

        return median;
    }

    public static void displayBestStudent(String mCode) {

        // find the highest mark of a module (module code as input parameter "mCode")
        // then find the studentID(s) of student(s) with the highest mark
        // show the above information in DOS prompt
        int[] marks = GRSData.getModuleMark(mCode);
        int highestMark = marks[0];

        for (int i = 1; i < marks.length; i++) {
            if (highestMark < marks[i])
                highestMark = marks[i];
        }

        System.out.println("In module " + mCode + ", the following students perform the best:");

        for (int i = 0; i < marks.length; i++) {
            if (marks[i] == highestMark)
                System.out.println("Student " + GRSData.getStudentID(i));
        }
    }

}

