package app;

import UtilsFile.FileUtils;
import entities.Config;
import entities.Request;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {



    public static void main(String[] args) {
        //VARIABLES

        //String FILE_PATH_CONFIG = "C:\\Users\\alu2015018\\OneDrive - Stucom, S.A(1)\\DAM\\POO y LI\\Practicas\\PracticaGrupal\\config.txt";
        String FILE_PATH_CONFIG = "C:\\Users\\sergi\\OneDrive - Stucom, S.A\\DAM\\POO y LI\\Practicas\\PracticaGrupal\\config.txt";
        String FILE_PATH_PETICIONES = "C:\\Users\\sergi\\OneDrive - Stucom, S.A\\DAM\\POO y LI\\Practicas\\PracticaGrupal\\peticions.txt";
        String directoryPath = "C:\\Users\\sergi\\OneDrive - Stucom, S.A\\DAM\\POO y LI\\Practicas\\PracticaGrupal";
        //String directoryPath = "C:\\\\Users\\\\alu2015018\\\\OneDrive - Stucom, S.A(1)\\\\DAM\\\\POO y LI\\\\Practicas\\\\PracticaGrupal";

        Config config = null;
        List<String> configuration, requests;
        FileUtils fileUtils = new FileUtils();
        File file = null;
        Map<String, String[]> traducciones = new HashMap<>();
        String monthSelected;
        Request request = null;


        //en primer lugar obtenemos los valores del archivo config.txt
        configuration = fileUtils.readFileByPath(FILE_PATH_CONFIG);

        //obtenemos un objeto del tipo config pasandole la lista de parametros obtenida
        config = new Config(configuration);

        //obtenemos el fichero de idioma correcto especificando el idioma de salida
        file = fileUtils.getLanguageFile(config.getOutputlanguage(), directoryPath);

        //obtenemos las traducciones
        traducciones = fileUtils.getTraductionsFromFile(file);


        monthSelected = fileUtils.getMonthByNum(config.getMonth(), config.getYear());

        //System.out.println(monthSelected);

        requests = fileUtils.readFileByPath(FILE_PATH_PETICIONES);


        for (String r : requests){

        }


    }





}
