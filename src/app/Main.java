package app;

import UtilsFile.FileUtils;
import entities.Config;
import entities.Request;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


    public static void main(String[] args) throws IOException {
        //VARIABLES

        String FILE_PATH_CONFIG = "C:\\Users\\alu2015018\\OneDrive - Stucom, S.A(1)\\DAM\\POO y LI\\Practicas\\PracticaGrupal\\config.txt";
        //String FILE_PATH_CONFIG = "C:\\Users\\sergi\\OneDrive - Stucom, S.A\\DAM\\POO y LI\\Practicas\\PracticaGrupal\\config.txt";
        //String FILE_PATH_PETICIONES = "C:\\Users\\sergi\\OneDrive - Stucom, S.A\\DAM\\POO y LI\\Practicas\\PracticaGrupal\\peticions.txt";
        String FILE_PATH_PETICIONES = "C:\\Users\\alu2015018\\OneDrive - Stucom, S.A(1)\\DAM\\POO y LI\\Practicas\\PracticaGrupal\\peticions.txt";
        //String directoryPath = "C:\\Users\\sergi\\OneDrive - Stucom, S.A\\DAM\\POO y LI\\Practicas\\PracticaGrupal";
        String directoryPath = "C:\\\\Users\\\\alu2015018\\\\OneDrive - Stucom, S.A(1)\\\\DAM\\\\POO y LI\\\\Practicas\\\\PracticaGrupal";

        Config config;
        List configuration;
        List requestList;
        FileUtils fileUtils = new FileUtils();
        File file;
        Map<String, String[]> traducciones;
        String monthSelected;


        //en primer lugar obtenemos los valores del archivo config.txt
        configuration = fileUtils.readFileByPath(FILE_PATH_CONFIG);

        //obtenemos un objeto del tipo config pasandole la lista de parametros obtenida
        config = new Config(configuration);

        //obtenemos el fichero de idioma correcto especificando el idioma de salida
        file = fileUtils.getLanguageFile(config.getOutputlanguage(), directoryPath);

        //obtenemos las traducciones
        traducciones = fileUtils.getTraductionsFromFile(file);

        //obtenemos el nombre del mes correspondientes
        monthSelected = fileUtils.getMonthByNum(config.getMonth(), config.getYear());

        //System.out.println(monthSelected);

        //obtenemos un array list con todas las peticiones del archivo peticions.txt
        requestList = fileUtils.readFileByPath(FILE_PATH_PETICIONES);


        //mostramos todos los nombres de las salas para comprobar que se han añadido correctamente
//        for (Request r : (List<Request>) requestList) {
//            System.out.println(r.getLobby());
//        }

        fileUtils.matchConfigWithRequest(requestList, config.getMonth(), config.getYear());


        fileUtils.writeHtmlInFile(fileUtils.getHtml(fileUtils.getMonthRequest(), traducciones, monthSelected), "sala 1");

    }


}
