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
 * @author alu2015018
 */
public class FileUtils {

    private BufferedReader bufferedReader = null;
    private FileReader fr = null;
    private String currentLine;
    private String[] arrayString = null;


    //string to test
    public FileUtils() {

    }

    //funcion para leer un archvio a partir de una variable del tipo File
    public void readFileByFile(File file){
        try{

            fr = new FileReader(file);
            bufferedReader = new BufferedReader(fr);

            while((currentLine = bufferedReader.readLine()) != null){
                System.out.println(currentLine);

            }

        }catch(Exception e){

        }
    }

    //funciton returns string List with all the config information
    public List<String> readFileByPath(String filePath) {

        List<String> stringList = new ArrayList<>();

        try {

            fr = new FileReader(filePath);
            bufferedReader = new BufferedReader(fr);

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
    public File readLanguageFile(String path, String language) {
        File languageFile = null,
                filesPath = new File(path);

        //array de archivos
        File[] fileList = filesPath.listFiles();

        //leemos todos los archvios
        for (File fileList1 : fileList) {
            //si es un archivo entramos
            if (fileList1.isFile()) {
                //si el nombre del archivo empieza por internacional...
                if (fileList1.getName().startsWith("internacional")) {
                    //System.out.println(fileList1.getName());
                    //hacemos un split por el punto de extension, para ello hemos de poner el punto con dos contra barras,
                    //si no estariamos diciendo con un punto, que haga split en cualquier caracter.
                    String[] fileName = fileList1.getName().split("\\.");
                    if (fileName[1].equals(language)) {
                        //System.out.println(fileName[1]);
                        languageFile = fileList1;
                    }
                }

            }
        }

        return languageFile;
    }





}
