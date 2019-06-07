package lab5;

public class TicketBox {
    private String stationName;
    private String arrTime;
    private String depTime;
    private String freePlace;
    private String overPlace;
    private String name;


    public TicketBox() {
        stationName = null;
        arrTime = null;
        depTime = null;
        freePlace = null;
        overPlace = null;

    }

    public void setArrTime(String arrTime) {
        if(RegEx.arrTimeCheck(arrTime))
            this.arrTime = arrTime;
        else
            System.out.println("Wrong arguments!");
    }

    public void setDepTime(String depTime) {
        if (RegEx.depTimeCheck(arrTime))
        this.depTime = depTime;
        else
        System.out.println("Wrong arguments!");
    }

    public void setFreePlace(String freePlace) {
        if (RegEx.numberCheck(freePlace))
            this.freePlace = freePlace;
        else
            System.out.println("Wrong arguments!");

    }

    public void setOverPlace(String overPlace) {
        if (RegEx.numberCheck(overPlace))
        this.overPlace = overPlace;
        else
            System.out.println("Wrong arguments!");

    }

    public void setStationName(String stationName) {
        if (RegEx.stationNameCheck(stationName))
        this.stationName = stationName;
        else
            System.out.println("Wrong arguments!");
    }

    public void setName(String name) {
        if (RegEx.stationNameCheck(name))
            this.name = name;
        else
            System.out.println("Wrong arguments!");
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
