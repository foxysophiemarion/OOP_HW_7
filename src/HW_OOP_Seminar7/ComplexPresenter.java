package HW_OOP_Seminar7;


import HW_OOP_Seminar7.Model.ComplexNumMath;
import HW_OOP_Seminar7.Model.ComplexNumService;
import HW_OOP_Seminar7.Model.ComplexNumber;
import HW_OOP_Seminar7.View.InputData;
import HW_OOP_Seminar7.View.Log;
import HW_OOP_Seminar7.View.LogConsole;
import HW_OOP_Seminar7.View.LogFile;

public class ComplexPresenter {
    private Log currentLog;
    private String pathLog;

    /** Конструктор
     *
     * @param startLog задание первоначального интерфейса для вывода
     */
    public ComplexPresenter(Log startLog) {
        this.currentLog = startLog;
        pathLog = "log.txt";
    }

    /** Процедура завершения программы
     *
     * @param message Сообщение для записи в лог при завершении программы
     * @return возращает false для завершения
     */
    private boolean stop(String message){
        currentLog.writeMessage("Завершение работы");
        currentLog.setLog(new LogFile(pathLog));
        currentLog.writeLog(message);
        return false;
    }

    /** Выбор операции над комплексными числами
     *
     * @param complexNumber1 первое комплексное число
     * @param complexNumber2 второе комплексное число
     * @param operand операция с комплексными числами
     * @return результирующее комплексное число
     */
    private ComplexNumber calculations(ComplexNumber complexNumber1, ComplexNumber complexNumber2, String operand){
        switch (operand){
            case "+": return ComplexNumMath.add(complexNumber1,complexNumber2);
            case "-": return ComplexNumMath.subtract(complexNumber1,complexNumber2);
            case "*": return ComplexNumMath.multiply(complexNumber1,complexNumber2);
            case "/": return ComplexNumMath.divide(complexNumber1,complexNumber2);
            default:
                throw new IllegalStateException("Неизвестный операнд: " + operand);
        }
    }
    private boolean operation(){

        ComplexNumber complexNumber1;
        String data;
        while (true) {
            currentLog.writeMessage("Введите первое комплексное число в формате a+bi");
            data = InputData.getData();
            if (ComplexNumService.checkComplexNum(data)) {
                complexNumber1 = ComplexNumService.parseComplexNum(ComplexNumService.preparaStrToComplexNum(data));
                break;
            } else {
                currentLog.writeMessage("Неверное число");
            }
        }

        String operand;
        while (true){
            currentLog.writeMessage("Введите операнд. Доступные операции + - * /");
            operand = InputData.getData();
            if (operand.matches("[-+*/]")){
                break;
            }else {
                currentLog.writeMessage("Неверный операнд");
            }

        }

        ComplexNumber complexNumber2;
        while (true) {
            currentLog.writeMessage("Введите второе комплексное число в формате a+bi");
            data = InputData.getData();
            if (ComplexNumService.checkComplexNum(data)) {
                complexNumber2 = ComplexNumService.parseComplexNum(ComplexNumService.preparaStrToComplexNum(data));
                break;
            } else {
                currentLog.writeMessage("Неверное число");
            }
        }
        ComplexNumber result = calculations(complexNumber1, complexNumber2,operand);
        currentLog.writeMessage(complexNumber1 + " " + operand + " " + complexNumber2 + " = " + result);
        currentLog.setLog(new LogFile(pathLog));
        currentLog.writeLog(complexNumber1 + " " + operand + " " + complexNumber2 + " = " + result);
        currentLog.setLog(new LogConsole());
        return true;
    }

    /** Стартовая процедура
     *
     */
    public void start(){
        currentLog.writeMessage("Калькулятор комплексных чисел");
        boolean run = true;
        String data;
        while (run){
            currentLog.writeMessage("Выберите действие\n1. Операции с комплексными числами\n2. Выход");
            data = InputData.getData();
            switch (data){
                case "1":
                    run = operation();
                    break;
                case "2":
                    run = stop("Exit");
                    break;
                default:
                    currentLog.writeMessage("Неверный ввод");
            }
        }
    }
}
