/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilsFile;

import entities.Request;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author alu2015018
 */
public class FileUtils {

    private BufferedReader bufferedReader = null;
    private BufferedWriter writer = null;
    private FileReader fr = null;
    private String currentLine;
    private String[] arrayString = null;
    private Map<String, String[]> traductions;          //traducciones
    private String languageAux, yearAux, monthAux;
    private String[] months;
    private Request request;
    private List<Request> requestList = new ArrayList<>();
    private List<Request> monthRequest = new ArrayList<>();

    String FILE_PATH_CONFIG = "C:\\Users\\alu2015018\\OneDrive - Stucom, S.A(1)\\DAM\\POO y LI\\Practicas\\PracticaGrupal\\config.txt";
    //String FILE_PATH_CONFIG = "C:\\Users\\sergi\\OneDrive - Stucom, S.A\\DAM\\POO y LI\\Practicas\\PracticaGrupal\\config.txt";
    //String FILE_PATH_PETICIONES = "C:\\Users\\sergi\\OneDrive - Stucom, S.A\\DAM\\POO y LI\\Practicas\\PracticaGrupal\\peticions.txt";
    String FILE_PATH_PETICIONES = "C:\\Users\\alu2015018\\OneDrive - Stucom, S.A(1)\\DAM\\POO y LI\\Practicas\\PracticaGrupal\\peticions.txt";

    private Request requestAux;
    private int colspan = 8;

    private Map<Integer, Integer> mapDayPos = new HashMap<Integer, Integer>();

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
                //System.out.println(arrayString);
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

        return stringList;

    }

    //funcion para obtener las peticiones que coinciden con el mes y año pedido en el archivo config
    public void matchConfigWithRequest(List<Request> list, int month, int year) {
        //a la funcion le pasamos una lista con los objetos que representan una peticion cada uno
        for (Request r : list) {
            //de la fecha de comienzo la partimos por el caracter / para comprobar si el mes y año coinciden con los pedidos
            String[] date = r.getStartReserve().split("/");
            /*System.out.println(r.getStartReserve());
            System.out.println(date[1]);
            System.out.println(date[2]);*/

            //si el mes y año coincide, añadimos la peticion a un array de peticiones que coinciden
            if (date[1].equals(String.valueOf(month)) && date[2].equals(String.valueOf(year))) {
                System.out.println(r.getName());
                monthRequest.add(r);
            }

        }

        System.out.println("Capacidad monthRequestList: " + monthRequest.size());
    }

    public List<Request> getRequestList() {
        return requestList;
    }

    public List<Request> getMonthRequest() {
        return monthRequest;
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


    //funcion para leer un archivo a partir de una variable del tipo File, y que retorna un map con las traducciones
    public Map<String, String[]> getTraductionsFromFile(File file) {
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


    public void mascaraDias(List<Request> listMonthRequest) {

        File incidencies = new File("incidencies.txt");

        Calendar calendar = Calendar.getInstance();

        try {

            String[] days;

            writer = new BufferedWriter(new FileWriter(incidencies, true));


            for (Request r : listMonthRequest) {

                if (r.hours.contains("_")) {
                    days = r.hours.split("_");


                } else {
                    //Completar String de error con nombre, dia, horainicio, horafin, y mensaje de error.
                    days = r.hours.split("-");
                    int horainicio = Integer.parseInt(days[0]);
                    int horafinal = Integer.parseInt(days[1]);
                    String horas = "(" + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ")" + horainicio + "-" + horafinal + " (¡¡No Válido, mínimo una hora de diferencia!!) ";


                    if (horafinal - horainicio == 0) {

                        if (incidencies.exists()) {
                            writer.write(horas);
                            writer.newLine();

                        }

                    }
                }

            }

        } catch (IOException e) {

        } finally {
            try {
                writer.close();
            } catch (IOException ignored) {

            }
        }


    }

    //String... quiere decir que podemos pasarle tantos String como queramos
    public void writeHtmlInFile(String html, String nameLoby) {

        //archivo que sera generado
        File file;

        try {

            file = new File(nameLoby);

            System.out.println(file.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(file + ".html"));

            writer.write(html);

        } catch (IOException ignored) {

        } finally {
            try {
                writer.close();
            } catch (Exception e) {

            }
        }
    }

    private int numDay = 0, hora1 = 0, hora2 = 1;

    private int getWeekNum(String date) {

        String currentFormat = "dd/MM/yyyy";

        SimpleDateFormat df = new SimpleDateFormat(currentFormat);

        Date fecha = new Date();


        try {
            fecha = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar cal = Calendar.getInstance();

        cal.setTime(fecha);


        return cal.get(Calendar.WEEK_OF_YEAR);
    }


    public String getHtml(List<Request> monthRequests, Map translatedDays, String monthSelected) {

        String[] traductions = (String[]) translatedDays.get("002");

        //comprobar numero de la semana del comienzo de la reserva
        String startDate = monthRequests.get(0).getStartReserve();

        //obtenemos el numero de semana a partir de una fecha pasada en String
        numDay = getWeekNum(startDate);

        int startDay = Integer.valueOf(startDate.split("/")[0]);


        StringBuilder sb = new StringBuilder();


        sb.append("<html> "
                + "     <head>" +
                "       </head>"
                + " <body>"
                + "     <table border=\"2px\" cellpadding=\"5\">");
        sb.append("         <tr>" +
                "               <th colspan='" + colspan + "'>" + monthSelected + "</th> " +
                "           </tr>" +

                //fila con los nombres de la semana
                "           <tr>" +
                "               <th>Semana: " + numDay + "</th><th>" + traductions[0] + "</th><th>" + traductions[1] + "</th><th>" + traductions[2] + "</th><th>" + traductions[3] + "</th><th>" + traductions[4] + "</th><th>" + traductions[5] + "</th><th>" + traductions[6] + "</th>" +
                "           </tr>");

        //fila de los numeros del dia
        sb.append("         <tr>" +
                "               <th>Day</th>");
        for (int d = 0; d < 7; d++) {
            sb.append("<td>" + startDay + "</td>");
            //mapa para guardar la posicion de cada dia
            mapDayPos.put(d, startDay);
            startDay++;
        }

        //System.out.println(startDay);
        sb.append("</tr>");

        //una vez sumados los dias de la semana, recogemos de nuevo el primer dia de reserva
        startDay = Integer.valueOf(startDate.split("/")[0]);

        //
        for (int i = 0; i < 24; i++) {

            sb.append("<tr>" +
                    "       <th> " + String.format("%02d", hora1) + " - " + String.format("%02d", hora2) + " h </th>");

            for (int n = 0; n < 7; n++){
                //si la hora
                System.out.println(Integer.valueOf(monthRequests.get(0).getHours().split("-")[1]));
                if (Integer.valueOf(monthRequests.get(0).getHours().split("-")[0]) <= hora1 && Integer.valueOf(monthRequests.get(0).getHours().split("-")[1]) >= hora2){
                    sb.append("<td>" + monthRequests.get(0).getName() + "</td>");
                }else{
                    sb.append("<td></td>");
                }
            }


            sb.append("</tr>");
            hora1++;
            hora2++;
        }


        sb.append("</table>");
        sb.append("</body>"
                + "</html>");

        return sb.toString();

    }


}
