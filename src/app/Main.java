package app;

import UtilsFile.FileUtils;
import entities.Config;
import entities.Request;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

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


        //en primer lugar obtenemos los valores del archivo config.txt
        configuration = fileUtils.readFileByPath(FILE_PATH_CONFIG);

        //obtenemos un objeto del tipo config pasandole la lista de parametros obtenida
        config = new Config(configuration);

        //obtenemos el fichero de idioma correcto especificando el idioma de salida
        file = fileUtils.getLanguageFile(config.getOutputlanguage(), directoryPath);

        //obtenemos las traducciones
        traducciones = fileUtils.getTraductionsFromFile(file);

        //obtenemos un array list con todas las peticiones del archivo peticions.txt
        requestList = fileUtils.readFileByPath(FILE_PATH_PETICIONES);


        //funcion para relacionar el mes pedido en el archivo config con las peticiones que esten en ese mes del archivo de peticions
        fileUtils.matchConfigWithRequest(requestList, config.getMonth(), config.getYear());


        fileUtils.generateHtml(traducciones, config.getMonth());


    }


}
