package HW_OOP_Seminar7.View;

import java.util.Scanner;

public class InputData {
    String date;
    private static Scanner formulaStr;

    public static String getData(){
        formulaStr = new Scanner(System.in);
        return formulaStr.nextLine();
    }

}
