package entities;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author alu2015018
 */
public class Request {

    public String name;
    public String lobby;
    public Date startReserve;
    public Date endReserve;
    public String days;
    public String hours;

    //array list para guardar peticiones
    private List<Request> requestList;
    private Request request;

    public Request() {
    }

    public Request(String name, String lobby, Date startReserve, Date endReserve, String days, String hours) {
        this.name = name;
        this.lobby = lobby;
        this.startReserve = startReserve;
        this.endReserve = endReserve;
        this.days = days;
        this.hours = hours;
    }

    public Request(String[] list){
        //estado de la sala
        this.name = list[0];
        //numero de sala
        this.lobby = list[1];
        //fecha entrada
        this.startReserve = StringToDate(list[2]);
        //fecha salida
        this.endReserve = StringToDate(list[3]);
        //dias
        this.days = list[4];
        //horas
        this.hours = list[5];
    }

    public Request saveRequestFromFile(String[] list) {

        request = new Request();
        requestList = new ArrayList<>();

        //estado de la sala
        name = list[0];
        //numero de sala
        lobby = list[1];
        //fecha entrada
        startReserve = StringToDate(list[2]);
        //fecha salida
        endReserve = StringToDate(list[3]);
        //dias
        days = list[4];
        //horas
        hours = list[5];

        request = new Request(name, lobby, startReserve, endReserve, days, hours);


//        requestList.add(request);

        return request;
    }


    public List<Request> getRequestList() {
        return requestList;
    }

    private Date StringToDate(String dateText) {
        Date newDate = new Date();

        //formato en el que queremos la fecha
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");

        try {
            newDate = formatter.parse(dateText);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return newDate;
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

    public Date getStartReserve() {
        return startReserve;
    }

    public void setStartReserve(Date startReserve) {
        this.startReserve = startReserve;
    }

    public Date getEndReserve() {
        return endReserve;
    }

    public void setEndReserve(Date endReserve) {
        this.endReserve = endReserve;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "request [name=" + name + ", lobby=" + lobby + ", startReserve=" + startReserve + ", endReserve="
                + endReserve + ", days=" + days + ", hours=" + hours + "]";
    }

}
