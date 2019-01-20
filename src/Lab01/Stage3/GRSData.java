package Lab01.Stage3;

class GRSData {

    private String[] moduleCode = {"ITD2322", "ICT2422", "ITD2321", "ICT2669"};
    private String[] studentID = {"1", "2", "3", "4", "5", "6", "7", "8"};
    private int[][] marks = { {30, 40, 50, 60, 45, 55, 65, 75}, // mark for ITD2322
            {80, 70, 60, 40, 34, 56, 78, 90}, // mark for ICT2422
            {76, 45, 67, 89, 12, 45, 67, 54}, // mark for ITD2321
            {56, 76, 54, 55, 50, 43, 66, 44}}; // mark for ICT2669

    public int[] getModuleMark(String mCode) {

        // return an array of marks for a module with given module code
        // (module code as input parameter "mCode").
        switch (mCode) {
            case "ITD2322":
                return marks[0];
            case "ICT2422":
                return marks[1];
            case "ITD2321":
                return marks[2];
            case "ICT2669":
                return marks[3];
            default:
                return marks[0];
        }
    }

    public String getStudentID(int i) {

        // return student ID of the student with index i in array stduentID
        return studentID[i];
    }
}