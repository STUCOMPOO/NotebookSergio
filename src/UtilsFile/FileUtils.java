/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilsFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyStore;
import java.util.*;

/**
 * @author alu2015018
 */
public class FileUtils {

    private BufferedReader bufferedReader = null;
    private FileReader fr = null;
    private String currentLine;
    private String[] arrayString = null;
    private Map<String, String[]> traductions;          //traducciones
    private String[] nombreAgenda,                      //1
            nombreDias,                                 //2
            mascaraDias,                                //3
            nombreMeses,                                //4
            nombresCalendario,                          //5
            generatedBy,                                //6
            state,                                      //7
            error;                                      //8


    //string to test
    public FileUtils() {

    }


    private String languageAux;

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
                //guardamos el idioma de salida en una variable auxiliar para obtener el fichero internacional correcto
                if (i == 3) languageAux = stringList.get(i);
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
    public File readLanguageFile(String path) {

        //System.out.println(languageAux);

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
                    //languageAux es el lenguaje de salida que hemos obtenido previamente, esto nos selcciona el archivo internacional que hemos pedido
                    if (fileName[1].equals(languageAux)) {
                        //System.out.println(fileName[1]);
                        languageFile = fileList1;
                    }
                }

            }
        }

        return languageFile;
    }

    //funcion para leer un archivo a partir de una variable del tipo File, y que retorna un map con las traducciones
    public Map readFileByFile(File file){
        //inicializamos el array que contiene las palabras
        traductions = new HashMap<>();

        try{

            fr = new FileReader(file);
            bufferedReader = new BufferedReader(fr);

            while((currentLine = bufferedReader.readLine()) != null){
                System.out.println(currentLine);

                String[] line = currentLine.split(";");

                //System.out.println(line[1]);
                traductions.put(line[0], line[1].split(","));

            }

             System.out.println("hola");

//            for (Map.Entry<String, String[]> set : traductions.entrySet()){
//                System.out.println(set.getKey());
//            }

        }catch(Exception e){

        }

        return traductions;
    }




}
