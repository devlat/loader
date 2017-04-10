package core;

import core.Parser;

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
            parser.printLinks();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
