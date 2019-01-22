package Lab01.Stage7;

class NumericGRSData extends GRSData {

    private int[][] marks = {{30, 40, 50, 60, 45, 55, 65, 75}, // mark for ITD2322
            {80, 70, 60, 40, 34, 56, 78, 90}, // mark for ICT2422
            {76, 45, 67, 89, 12, 45, 67, 54}, // mark for ITD2321
            {56, 76, 54, 55, 50, 43, 66, 44}}; // mark for ICT2669

    public int[] getModuleMark(String mCode) {

        // return an array of marks for a module with given module code
        // (module code as input parameter "mCode").
        return marks[getModuleIndex(mCode)];
    }
}
