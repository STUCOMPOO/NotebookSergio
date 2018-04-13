package entities;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
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
    private List<Request> requestList = new ArrayList<>();
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

    public void saveRequestFromFile(List<String> requestList) {

        //estado de la sala
        String name = requestList.get(0);
        //numero de sala
        String lobby = requestList.get(1);
        //fecha entrada
        Date startReserve = StringToDate(requestList.get(2));
        //fecha salida
        Date endReserve = StringToDate(requestList.get(3));
        //dias
        String days = requestList.get(4);
        //horas
        String horas = requestList.get(5);

        request = new Request(name, lobby, startReserve, endReserve, days, horas);

        this.requestList.add(request);
    }

    public List<Request> getRequestList() {

        if (!requestList.isEmpty()) {
            return requestList;
        } else {
            return null;
        }

    }

    private Date StringToDate(String dateText) {
        Date newDate = new Date();

        //formato en el que queremos la fecha
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");

        try {
            Date date = formatter.parse(dateText);

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
