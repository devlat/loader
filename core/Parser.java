package core;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Created by Gadel on 09.04.2017.
 *
 * Класс считывает данные (ссылка и наименование выходного файла) с указанного файла.
 */
public class Parser {
    private File inputFile;
    private HashMap<String, String> links = new HashMap<String, String>();

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
     * Метод парсит файл и записывает ссылки в коллекцию.
     */
    public void parseFile() {
        String data;
        FileReader fr;
        BufferedReader buffer;

        try {
            fr = new FileReader(this.inputFile);
            buffer = new BufferedReader(fr);

            while ((data = buffer.readLine()) != null) {
                String[] extractedData = data.split(" ");

                this.links.put(extractedData[0], extractedData[1]);
            }

            buffer.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод возвращает коллекцию со ссылками.
     * @return HashMap<Stringm, String>
     */
    public HashMap<String, String> getLinks() {
        if (this.links.isEmpty()) {
            System.out.println("Данных нет.");
            return null;
        }

        return this.links;
    }
}
