package pl.pszczolkowski.bookspa.model;

import java.util.Date;

public class OrderRequest {
    long id;
    String serviceType;
    String name;
    String surname;
    String adress;
    String date;
    String hour;
    String additional;

    public OrderRequest(long id, String serviceType, String name, String surname, String adress, String date, String hour, String additional) {
        this.id = id;
        this.serviceType = serviceType;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.date = date;
        this.hour = hour;
        this.additional = additional;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }
}
