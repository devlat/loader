package core;

import java.io.FileNotFoundException;
import java.net.URL;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by Ilyas on 10.04.2017.
 *
 * Класс реализует загрузку файлов по HTTP и их запись в указанные файлы.
 */
public class Loader {
    /**
     * Установка настроек локального прокси.
     */
    public Loader() {
        /**
         * Set CNTLM local proxy to access network
         */
		System.setProperty("http.proxyHost", "127.0.0.1");
		System.setProperty("http.proxyPort", "3130");
    }

    /**
     * Загрузка файла по HTTP и дальнейшая его запись в указанный файл.
     * @param String urlString ссылка на файл
     * @param String outputFilePath наименование выходного файла
     */
    public void loadData(String urlString, String outputFilePath) throws FileNotFoundException {
        byte[] data = new byte[16];
        int count = 0;
        File outputFile = new File(outputFilePath);

        try {
            URL url = new URL(urlString);

            BufferedInputStream inputStream = new BufferedInputStream(url.openStream());

            FileOutputStream outputStream = new FileOutputStream(outputFile);

            while ((count = inputStream.read(data, 0, 16)) != -1) {
                outputStream.write(data, 0, 16);
            }

            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
