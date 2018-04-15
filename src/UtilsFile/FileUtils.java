/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilsFile;

import entities.Config;
import entities.Request;

import java.io.*;
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
    private String languageAux, yearAux, monthAux;
    private String[] months;
    private Request request;
    private List<Request> requestList = new ArrayList<>();

    String FILE_PATH_CONFIG = "C:\\Users\\sergi\\OneDrive - Stucom, S.A\\DAM\\POO y LI\\Practicas\\PracticaGrupal\\config.txt";
    String FILE_PATH_PETICIONES = "C:\\Users\\sergi\\OneDrive - Stucom, S.A\\DAM\\POO y LI\\Practicas\\PracticaGrupal\\peticions.txt";
    private Request requestAux;

    //string to test
    public FileUtils() {

    }


    //funciton returns string List with all the config information
    public List readFileByPath(String filePath) throws IOException {

        System.out.println(filePath);
        List<String> stringList = new ArrayList<>();

        //try {

        fr = new FileReader(filePath);
        bufferedReader = new BufferedReader(fr);

        while ((currentLine = bufferedReader.readLine()) != null) {
            System.out.println(currentLine);
            arrayString = currentLine.split(" ");

            if (filePath.equals(FILE_PATH_PETICIONES)) {
                //System.out.println("PATH1: " + FILE_PATH_PETICIONES);
                //System.out.println(arrayString.length);
                //añadimos al
                requestAux = new Request(arrayString);
                requestList.add(requestAux);

            }

            stringList.addAll(Arrays.asList(arrayString)); //System.out.println(arrayString.length);
        }



        //si el archivo pasado es config
        if (filePath.endsWith(FILE_PATH_CONFIG)) {
//comprobacion para ver si se han añadido correctamente los valores
            for (int i = 0; i < stringList.size(); i++) {

                System.out.println(stringList.get(i));
                //guardamos el mes y año que se indican en el archivo de peticions
                if (i == 0) yearAux = stringList.get(i);
                if (i == 1) monthAux = stringList.get(i);
                //guardamos el idioma de salida en una variable auxiliar para obtener el fichero internacional correcto
                if (i == 3) languageAux = stringList.get(i);
            }

            System.out.println("config");
            //si el archivo pasado es el de peticiones
        } else if (filePath.equals(FILE_PATH_PETICIONES)) {

            for (int i = 0; i < stringList.size(); i++) {
                System.out.println(stringList.get(i));
            }

            System.out.println("peticiones");
            System.out.println("Count: " + requestList.size());

            return requestList;
        }





        /*} catch (Exception e) {


        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ignored) {

            }
        }*/

        return stringList;

    }

    public List<Request> getRequestList(){
        return requestList;
    }

    //funcion para obtener el fichero del idioma especificado
    public File getLanguageFile(String language, String path) {

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
                    if (fileName[1].equals(language)) {
                        //System.out.println(fileName[1]);
                        languageFile = fileList1;
                    }
                }

            }
        }

        return languageFile;
    }

    public void readPeticionsFileByFile(File file) {

    }

    //funcion para leer un archivo a partir de una variable del tipo File, y que retorna un map con las traducciones
    public Map getTraductionsFromFile(File file) {
        //inicializamos el array que contiene las palabras
        traductions = new HashMap<>();


        try {
            fr = new FileReader(file);
            bufferedReader = new BufferedReader(fr);

            while ((currentLine = bufferedReader.readLine()) != null) {
                //if (currentLine.isEmpty()) continue;

                System.out.println(currentLine);

                String[] line = currentLine.split(";");

                //System.out.println(line[1]);
                traductions.put(line[0], line[1].split(","));


            }

            System.out.println("\n");

            //recorremos el map para ver si se han añadido correctmante las traducciones
            /*for (Map.Entry<String, String[]> e : traductions.entrySet()) {
                //al tener un array de string, tenemos que recorrer el array de nuevo
                System.out.println(e.getKey());
                for (String b : e.getValue()) {
                    System.out.println(b);
                }
            }*/

        } catch (Exception e) {

        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ignored) {

            }

        }


        //System.out.println(monthAux);

        return traductions;

    }

    //funcion con la cual obtenemos el nombre del mes a partir del numero especificado en config.txt
    public String getMonthByNum(int monthNum, int yearNum) {
        String month = "";

        String[] months = {""};

        //recorremos el map en busca del array de string que contiene los meses, situado en la posicion 004
        for (Map.Entry<String, String[]> e : traductions.entrySet()) {
            //obtenemos todos los meses
            if (e.getKey().equals("004")) {
                months = e.getValue();
            }
        }

        //obtenemos el nombre gracias al numero del mes localizado en config.txt
        month = months[Integer.valueOf(monthNum) - 1];

        System.out.println(month + " de " + yearNum);


        return month;
    }

    public void generateHTML() {

    }


}
