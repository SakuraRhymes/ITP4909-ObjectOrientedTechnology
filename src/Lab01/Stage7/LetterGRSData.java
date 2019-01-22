package Lab01.Stage7;

class LetterGRSData extends GRSData {

    private char[][] marks = {{'F', 'D', 'C', 'B', 'C', 'B', 'C', 'A'}, // mark for ITD2322
            {'D', 'B', 'A', 'A', 'F', 'B', 'C', 'C'}, // mark for ICT2422
            {'D', 'B', 'E', 'B', 'C', 'F', 'F', 'D'}, // mark for ITD2321
            {'C', 'B', 'E', 'D', 'C', 'B', 'C', 'A'}}; // mark for ICT2669

    public int[] getModuleMark(String mCode) {

        // return an array of marks for a module with given module code
        // (module code as input parameter "mCode").

        // note : numeric array of marks is to be returned (since 'A' -> 5, 'B' -> 4, 'C' -> 3 etc..)
        int[] numMarks;
        char[] charMarks;

        charMarks = marks[getModuleIndex(mCode)];

        numMarks = new int[charMarks.length];

        for (int i = 0; i < charMarks.length; i++) {
            numMarks[i] = letterToNumeric(charMarks[i]);
        }

        return numMarks;
    }

    public int letterToNumeric(char grade) {

        // convert and return a numeric mark from a grade (grade as input pararmeter "grade)

        // you may need to call this method from the method getModuleMark
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
}
