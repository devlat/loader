package core;

import core.Parser;
import core.Loader;

import java.io.FileNotFoundException;

/**
 * Created by Gadel on 08.04.2017.
 *
 * Загрузчик файлов по HTTP.
 * @todo Необходимо реализовать класс с загрузкой файлов по списку ссылок.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("App started...");

        try {
            Parser parser = new Parser("C:/data.txt");
            parser.parseFile();

            Loader downloader = new Loader();

            /**
             * Скачиваем файлы.
             */
            parser.getLinks().forEach((String key, String value) -> {
                //System.out.println(key + " := " + value);

                try {
                    downloader.loadData(key, "C:/output/" + value);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            });
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
