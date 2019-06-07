package lab3;

import java.util.ArrayList;

public class TicketBox {
    private String stationName;
    private String arrTime;
    private String depTime;
    private String freePlace;
    private String overPlace;
    private String name;
    ArrayList <Route> routes = new ArrayList<Route>();


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


    public void setFreePlace(String freePlace) {
        this.freePlace = freePlace;
    }

    public void setOverPlace(String overPlace) {
        this.overPlace = overPlace;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public void addRoute(Route route) {
        routes.add(route);
    }

    public ArrayList<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(ArrayList<Route> routes) {
        this.routes = routes;
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