package HW_OOP_Seminar7.View;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/** Класс для логирования в файл
 *
 */
public class LogFile implements Logging{
    private final String pathFile;

    /** Конструктор класса для логирования в файл
     *
     * @param pathFile путь к файлу для логирования
     */
    public LogFile(String pathFile) {
        this.pathFile = pathFile;
    }

    /**
     * Вывод сообщения
     *
     * @param message сообщение для вывода
     */
    @Override
    public void writeMessage(String message) {
        //String path = "log.txt";
        File logFile = new File(pathFile);
        if (!logFile.exists()){
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            FileWriter logFileWrite = new FileWriter(pathFile,true);
            logFileWrite.write(message+'\n');
            logFileWrite.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
