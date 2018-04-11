/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilsFile;

import entities.Request;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author alu2015018
 */
public class FileUtils {

    //string to test
    public FileUtils() {

    }

    //funciton returns string List with all the config information
    public List<String> readFile(String filePath) {
        BufferedReader bufferedReader = null;
        FileReader fr = null;
        List<String> stringList = new ArrayList<>();

        try {

            fr = new FileReader(filePath);
            bufferedReader = new BufferedReader(fr);

            String currentLine;
            String[] arrayString = null;

            while ((currentLine = bufferedReader.readLine()) != null) {
                System.out.println(currentLine);
                arrayString = currentLine.split(" ");

                stringList.addAll(Arrays.asList(arrayString)); //System.out.println(arrayString.length);
            }

            //comprobacion para ver si se han añadido correctamente los valores
            for (int i = 0; i < stringList.size(); i++) {

                System.out.println(stringList.get(i));
            }

        } catch (Exception e) {

        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ignored) {

            }
        }

        return stringList;

    }

    //funcion para obtener el fichero del idioma especificado
    private File readLanguageFile(String path, String language) {
        File languageFile = null,
                filesPath = new File(path);

        //array de archivos
        File[] fileList = filesPath.listFiles();

        //leemos todos los archvios
        for (File fileList1 : fileList) {
            if (fileList1.isFile()) {
                System.out.println(fileList1.getName());
                String[] fileName = fileList1.getName().split(".");
                if (fileName[1].equals(language)) {
                    languageFile = fileList1;
                }
            }
        }

        return languageFile;
    }

}
