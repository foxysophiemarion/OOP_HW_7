package HW_OOP_Seminar7.Model;

import java.util.ArrayList;
import java.util.Arrays;

public class ComplexNumService {


//    public static ArrayList<String> splitFormulaToNum(String formula){
//        int i = formula.indexOf("+");
//        ArrayList<String> result = new ArrayList<>();
//        if (formula.contains("*")){
//            result.add(formula.substring(0,formula.indexOf("*")));
//            result.add("*");
//            result.add(formula.substring(formula.indexOf("*")+1));
//            System.out.println(result);
//            return result;
//        } else if (formula.contains("/")) {
//            //result.add(Arrays.toString(formula.split("/")));
//            result.add(formula.substring(0,formula.indexOf("/")));
//            result.add("/");
//            result.add(formula.substring(formula.indexOf("/")+1));
//            System.out.println(result);
//            return result;
//        }
//
//        return result;
//    }

    /** Проверка комплексного числа на корректность
     *
     * @param number комплексное число в формате String
     * @return результат проверки (да/нет)
     */
    public static boolean checkComplexNum(String number){
        return number.matches("^[-+0-9i.,]+$");
        //return number.matches("\\d(\\+-*)(\\di)");
    }

    /** Преобразование комплексного числа из строки
     *  в объект класса ComplexNumber
     * @param number комплексное число в формате String
     * @return комплексное число в формате ComplexNumber
     */
    public static ComplexNumber parseComplexNum(String number){
        int i = 1;
        if (number.indexOf("-") == 0){
            i = -1;
            number = number.substring(1);
        }
        String[] num = number.replaceAll("i","").replaceAll("I","").split("[+-]");
        if (num.length==2){
            return new ComplexNumber(Double.parseDouble(num[0])*i,number.contains("-") ? Double.parseDouble(num[1])*-1 : Double.parseDouble(num[1]));
        } else return new ComplexNumber(Double.parseDouble(num[0])*i,0);
    }

    /** Подготовка строки для корректных преобразований комплексного числа
     *
      * @param number исходная строка, содержащая комплексное число
     * @return обработанная строка, содержащая комплексное число
     */
    public static String preparaStrToComplexNum(String number){
        return number.trim().replaceAll(",",".").replaceAll(" ","");
    }
}
