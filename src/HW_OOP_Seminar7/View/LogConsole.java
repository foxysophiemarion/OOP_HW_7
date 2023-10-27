package HW_OOP_Seminar7.View;

/** Класс для логирования в консоль
 *
 */
public class LogConsole implements Logging {

    /**
     * Вывод сообщения
     *
     * @param message сообщение для вывода
     */
    @Override
    public void writeMessage(String message) {
        System.out.println(message);
    }
}
