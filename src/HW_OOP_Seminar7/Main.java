package HW_OOP_Seminar7;

import HW_OOP_Seminar7.View.Log;
import HW_OOP_Seminar7.View.LogConsole;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ComplexPresenter control = new ComplexPresenter(new Log(new LogConsole()));
        control.start();

    }
}
