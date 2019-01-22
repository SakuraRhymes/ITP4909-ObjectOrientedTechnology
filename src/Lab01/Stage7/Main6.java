package Lab01.Stage7;

import java.util.*;

public class Main6 {

    // declare a private static data member of GRSData object
    // (You need to call the methods of GRSData when you finding the average mark, median
    //  best student(s) of a module
    private static GRSData GRSData;

    public static void main(String[] argv) {

        if (argv.length != 3) {
            System.out.println("Usage: java Main6 {letter | numeric } {average | median | beststudent} <module code>");
            System.exit(1);
        }

        // the main logic of this program, to be implemented by you!
        if (argv[0].equals("numeric"))
            GRSData = new NumericGRSData();

        if (argv[0].equals("letter"))
            GRSData = new LetterGRSData();

        if (argv[1].equals("average"))
            System.out.println("The average mark of module " + argv[2] + " = " + calculateModuleAverageMark(argv[2]));

        if (argv[1].equals("median"))
            System.out.println("The median of module " + argv[2] + " = " + calculateModuleMedian(argv[2]));

        if (argv[1].equals("beststudent"))
            displayBestStudent(argv[2]);
    }

    // other methods for calculating the average mark, median and display the best student(s)
    // have already been implemented in Stage 3 and Stage 4
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
