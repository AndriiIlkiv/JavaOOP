package lab7;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class TicketBox implements Serializable {
    private static final long serialVersionUID = 1L;
    private String stationName;
    private String arrTime;
    private String depTime;
    private String freePlace;
    private String overPlace;
    private int number;
    ArrayList <Route> routes = new ArrayList<Route>();


    public TicketBox() {
        stationName = null;
        arrTime = null;
        depTime = null;
        freePlace = null;
        overPlace = null;
        number = 0;


    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
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

    public static Comparator<TicketBox> CompareNumber = new Comparator<TicketBox>()
    {
        @Override
        public int compare(TicketBox o1 ,TicketBox o2)
        {
            return o1.number > o2.number ? +1 : o1.number < o2.number ? -1 : 0;
        }
    };

}