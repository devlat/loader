package core;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

/**
 * Created by Gadel on 09.04.2017.
 *
 * Класс считывает данные (ссылка и наименование выходного файла) с указанного файла.
 */
public class Parser {
    private File inputFile;

    /**
     * В конструкторе инициализируем файл.
     * @param String pathToFile
     * @throws FileNotFoundException
     */
    public Parser(String pathToFile) throws FileNotFoundException {
        this.inputFile = new File(pathToFile);

        if (!this.inputFile.isFile()) {
            throw new FileNotFoundException("Файл не найден.");
        }
    }

    /**
     * Парсим файл.
     */
    public void parseFile() {
        String dataLine;

        try {
            FileReader fr = new FileReader(this.inputFile);

            BufferedReader buffer = new BufferedReader(fr);

            while ((dataLine = buffer.readLine()) != null) {
                /**
                 * Временно, в качестве проверки.
                 * @todo необходимо записывать в HashMap для последующего использования.
                 */
                System.out.println(dataLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
