package core;

import core.Parser;
import core.Loader;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

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

        /************************************************
         * Черновой вариант парсинга аргументов запуска *
         ************************************************/
        for (int n = 0; n < args.length; n++) {
            switch (args[n]) {
                case "-n":
                    cmdArgs.put("-n", args[++n]);
                    break;
                case "-l":
                    cmdArgs.put("-l", args[++n]);
                    break;
                case "-f":
                    cmdArgs.put("-f", args[++n]);
                    break;
                case "-o":
                    cmdArgs.put("-o", args[++n]);
                    break;
                default:
                    throw new Exception("Unknown key " + args[n]);
            }

        }

        // ************************************************************
        // * Черновой вариант под реализацию многопоточной загрузки *
        // ************************************************************
        ArrayList<Thread> threads = new ArrayList<Thread>();

        int threadCount = 3;

        for (int i = 0; i < threadCount; i++) {
            threads.add(i, new Thread(new Runnable() {
                public void run() {
                    Random rand = new Random();

                    System.out.println("Hello from thread : " + rand.nextInt(10));
                }
            }));
        }

        threads.forEach((Thread t) -> {
            t.start();
        });

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
