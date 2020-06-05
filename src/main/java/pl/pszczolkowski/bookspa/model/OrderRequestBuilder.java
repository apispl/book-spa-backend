package pl.pszczolkowski.bookspa.model;

public class OrderRequestBuilder {
    private long id;
    private String serviceType;
    private String name;
    private String surname;
    private String adress;
    private String date;
    private String hour;
    private String additional;

    public OrderRequestBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public OrderRequestBuilder setServiceType(String serviceType) {
        this.serviceType = serviceType;
        return this;
    }

    public OrderRequestBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public OrderRequestBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public OrderRequestBuilder setAdress(String adress) {
        this.adress = adress;
        return this;
    }

    public OrderRequestBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    public OrderRequestBuilder setHour(String hour) {
        this.hour = hour;
        return this;
    }

    public OrderRequestBuilder setAdditional(String additional) {
        this.additional = additional;
        return this;
    }

    public OrderRequest build() {
        return new OrderRequest(id, serviceType, name, surname, adress, date, hour, additional);
    }
}
