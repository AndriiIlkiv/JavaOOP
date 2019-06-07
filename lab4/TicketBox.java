package lab4;

import lab3.Route;

import java.util.ArrayList;

public class TicketBox {
    private String stationName;
    private String arrTime;
    private String depTime;
    private String freePlace;
    private String overPlace;
    private String name;
    private ArrayList<Route> route;


    public TicketBox() {
        stationName = null;
        arrTime = null;
        depTime = null;
        freePlace = null;
        overPlace = null;

    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public void setFreePlace(String freePlace) {
        this.freePlace = freePlace;
    }

    public void setOverPlace(String overPlace) {
        this.overPlace = overPlace;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getArrTime() {
        return arrTime;
    }

    public String getDepTime() {
        return depTime;
    }

    public String getStationName() {
        return stationName;
    }

    public String getFreePlace() {
        return freePlace;
    }


    public String getOverPlace() {
        return overPlace;
    }
}
