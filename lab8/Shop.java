package lab8;

import java.io.Serializable;
import java.util.ArrayList;

public class Shop implements Serializable {


    private static int counter = 0;
    private int index;
    private String station;
    private String amount;
    private String priceOfstation;
    private String weight;
    public ArrayList <Description> description;

    public Shop() {
        description = new ArrayList<>();
        index = counter++;
    }

    public Shop(String firm){
        description = new ArrayList<>();
        index = counter++;
        this.station = station;
    }
    

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getData_p() {
        return amount;
    }

    public void setData_p(String data_p) {
        this.amount = data_p;
    }

    public String getData_v() {
        return priceOfstation;
    }

    public void setData_v(String data_v) {
        this.priceOfstation = data_v;
    }

    public String getReason() {
        return weight;
    }

    public void setReason(String reason) {
        this.weight = reason;
    }

    public int getIndex() {
        return index;
    }


}