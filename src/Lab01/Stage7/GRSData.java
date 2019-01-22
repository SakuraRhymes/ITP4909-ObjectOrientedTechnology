package Lab01.Stage7;

abstract class GRSData {

    protected String[] moduleCode = {"ITD2322", "ICT2422", "ITD2321", "ICT2669"};
    protected String[] studentID = {"1", "2", "3", "4", "5", "6", "7", "8"};

    abstract int[] getModuleMark(String mCode);

    public String getStudentID(int i) {

        // return student ID of the student with index i in array stduentID
        return (studentID[i]);
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
