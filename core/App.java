package core;

import core.Parser;
import core.Loader;

import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * Created by Gadel on 08.04.2017.
 *
 * Загрузчик файлов по HTTP.
 * @todo Необходимо реализовать класс с загрузкой файлов по списку ссылок.
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("App started...");

        /**
         * Словарь вида "ключ"-"значение" для хранения аргументов.
         */
        HashMap<String, String> cmdArgs = new HashMap<String, String>();

        /**
         * Количество потоков (-n)
         */
        String argThreadCount = null;

        /**
         * Ограничение на скорость скачивания (-l)
         */
        String argLoadSpeed = null;

        /**
         * Путь к файлу со ссылками (-f)
         */
        String argLinksFile = null;

        /**
         * Имя(или путь?) к папке, куда сохранять скачанные файлы
         */
        String argOutputFolder = null;

        /************************************************
         * Черновой вариант парсинга аргументов запуска *
         ************************************************/
        for (int n = 0; n < args.length; n++) {
            switch (args[n]) {
                case "-n":
                    //argThreadCount = args[++n];
                    cmdArgs.put("-n", args[++n]);
                    break;
                case "-l":
                    //argLoadSpeed = args[++n];
                    cmdArgs.put("-l", args[++n]);
                    break;
                case "-f":
                    //argLinksFile = args[++n];
                    cmdArgs.put("-f", args[++n]);
                    break;
                case "-o":
                    //argOutputFolder = args[++n];
                    cmdArgs.put("-o", args[++n]);
                    break;
                default:
                    throw new Exception("Unknown key " + args[n]);
            }

        }

        System.out.println(cmdArgs);

        /*try {
            Parser parser = new Parser("C:/data.txt");
            parser.parseFile();

            Loader downloader = new Loader();

            /**
             * Скачиваем файлы.
             *//*
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
        }*/
    }
}
