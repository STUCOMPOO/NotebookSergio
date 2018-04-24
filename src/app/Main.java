package app;

import UtilsFile.FileUtils;
import entities.Config;
import entities.Request;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


    private static int hora1;
    private static int hora2 = 1;
    private static NumberFormat nf = new DecimalFormat("00");

    public static void main(String[] args) throws IOException {
        //VARIABLES

        String FILE_PATH_CONFIG = "C:\\Users\\alu2014011\\Desktop\\config-files\\config.txt";
        //String FILE_PATH_CONFIG = "C:\\Users\\sergi\\OneDrive - Stucom, S.A\\DAM\\POO y LI\\Practicas\\PracticaGrupal\\config.txt";
        //String FILE_PATH_PETICIONES = "C:\\Users\\sergi\\OneDrive - Stucom, S.A\\DAM\\POO y LI\\Practicas\\PracticaGrupal\\peticions.txt";
        String FILE_PATH_PETICIONES = "C:\\Users\\alu2014011\\Desktop\\config-files\\peticions.txt";
        //String directoryPath = "C:\\Users\\sergi\\OneDrive - Stucom, S.A\\DAM\\POO y LI\\Practicas\\PracticaGrupal";
        String directoryPath = "C:\\Users\\alu2014011\\Desktop\\config-files";

        Config config;
        List<String> configuration;
        List<Request> requestList;
        FileUtils fileUtils = new FileUtils();
        File file;
        Map<String, String[]> traducciones = new HashMap<>();
        String monthSelected;
        Request request = new Request();
        String[] dias = new String[7];


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
        /*for (Request r : requestList){
            //System.out.println(r.getLobby());
        }*/


        fileUtils.matchConfigWithRequest(requestList, config.getMonth(), config.getYear());

        fileUtils.writeHtmlInFile("hola", "sala 1");


        for (Map.Entry<String, String[]> entry: traducciones.entrySet()){
            //accedemos a los dias que es la clave numero 002
            if(entry.getKey().equals("002")){
                dias = entry.getValue();
            }
        }

        fileUtils.writeHtmlInFile(getHtml(dias), "index");


    }

    private static String getHtml(String[] dias) {

        StringBuilder sb = new StringBuilder();
        sb.append("<html> "
                + "<head></head>"
                + "<body>"
                + " <table border=\"2px\" cellpadding=\"5\">");
        sb.append("  <tr><th>Semana</th><th>" + dias[0] + "</th><th>" + dias[1] + "</th><th>" + dias[2] + "</th><th>"+ dias[3] +"</th><th>"+ dias[4] +"</th><th>"+ dias[5] +"</th><th>"+ dias[6] +"</th></tr>");
        sb.append(" <tr><th>Day</th><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
        for (int i = 0; i < 24; i++) {

            sb.append("<tr><td> " + nf.format(hora1) + " - " + nf.format(hora2) + " h " + "</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
            hora1++;
            hora2++;
        }
        sb.append("</table>");
        sb.append("</body>"
                + "</html>");

        return sb.toString();

    }





}