package app;

import UtilsFile.FileUtils;
import entities.Config;
import entities.Request;

import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {





    private static int hora1 = 00;
    private static int hora2 = 01;

    public static void main(String[] args) {

        NumberFormat nf = new DecimalFormat("00") ;

        //VARIABLES

        //String FILE_PATH_CONFIG = "C:\\Users\\alu2015018\\OneDrive - Stucom, S.A(1)\\DAM\\POO y LI\\Practicas\\PracticaGrupal\\config.txt";
        String FILE_PATH_CONFIG = "C:\\Users\\alu2014011\\Desktop\\config-files\\config.txt";
        String FILE_PATH_PETICIONES = "C:\\Users\\alu2014011\\Desktop\\config-files\\peticions.txt";
        String directoryPath = "C:\\Users\\alu2014011\\Desktop\\config-files";
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


//        monthSelected = fileUtils.getMonthByNum(config.getMonth(), config.getYear());

        //System.out.println(monthSelected);

        requests = fileUtils.readFileByPath(FILE_PATH_PETICIONES);


        for (String r : requests){

        }



        StringBuilder sb = new StringBuilder();
        sb.append("<html> "
                + "<head></head>"
                + "<body>"
                + " <table border=\"2px\" cellpadding=\"5\">");
        sb.append("  <tr><th>Semana</th><th>Lunes</th><th>Martes</th><th>Miercoles</th><th>Jueves</th><th>Viernes</th><th>Sabado</th><th>Domingo</th></tr>");
        sb.append(" <tr><th>Day</th><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
        for (int i = 0; i < 24; i++) {

            sb.append("<tr><td> "+ nf.format(hora1) + " - "+nf.format(hora2) +" h "+ "</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
            hora1++;
            hora2++;
        }
        sb.append("</table>");
        sb.append("</body>"
                + "</html>");


fileUtils.writeHtmlInFile(sb.toString(),"index");



    }





}
