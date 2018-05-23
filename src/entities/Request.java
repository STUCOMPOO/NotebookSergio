package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author alu2015018
 */
public class Request {

    public String name;
    public String lobby;
    public String startReserve;
    public String endReserve;
    public String days;
    public List<String> hours;

    //array list para guardar peticiones
    private List<Request> requestList = new ArrayList<>();
    private Request request;

    public Request() {
    }

    public Request(String name, String lobby, String startReserve, String endReserve, String days, List<String> hours) {
        this.name = name;
        this.lobby = lobby;
        this.startReserve = startReserve;
        this.endReserve = endReserve;
        this.days = days;
        this.hours = hours;
    }


    public Request(String[] list) {
        //estado de la sala
        this.name = list[0];
        //numero de sala
        this.lobby = list[1];
        //fecha entrada
        this.startReserve = list[2];
        //fecha salida
        this.endReserve = list[3];
        //dias
        this.days = list[4];
        //horas
        this.hours = checkHours(list[5]);
    }

    //variable para comprobar si la hora tiene dos ohrarios o no
    private List<String> checkHours(String hour) {

        String[] horas;
        List<String> listHoras = new ArrayList<>();

        if (hour.contains("_")) {
            horas = hour.split("_");

            listHoras.add(horas[0]);
            listHoras.add(horas[1]);

        } else {
            listHoras.add(hour);
        }

        for (String s : listHoras) System.out.println("somos las horas " + s);

        return listHoras;
    }

    public Request saveRequestFromFileAndReturnListRequest(List<String> listRequest) {

        request = new Request();
        //estado de la sala
        name = listRequest.get(0);
        //numero de sala
        lobby = listRequest.get(1);
        //fecha entrada
        startReserve = listRequest.get(2);
        //fecha salida
        endReserve = listRequest.get(3);
        //dias
        days = listRequest.get(4);
        //horas
        //hours = listRequest.get(5);

        request = new Request(name, lobby, startReserve, endReserve, days, hours);

        requestList.add(request);

        return request;
    }


    public List<Request> getRequestList() {
        return requestList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLobby() {
        return lobby;
    }

    public void setLobby(String lobby) {
        this.lobby = lobby;
    }

    public String getStartReserve() {
        return startReserve;
    }

    public void setStartReserve(String startReserve) {
        this.startReserve = startReserve;
    }

    public String getEndReserve() {
        return endReserve;
    }

    public void setEndReserve(String endReserve) {
        this.endReserve = endReserve;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public List<String> getHours() {
        return hours;
    }

    public void setHours(List<String> hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "request [name=" + name + ", lobby=" + lobby + ", startReserve=" + startReserve + ", endReserve="
                + endReserve + ", days=" + days + ", hours=" + hours + "]";
    }

}
