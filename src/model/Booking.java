package model;

import java.util.Date;

public class Booking extends Model{
    private String title;
    private String details;
    private Client client;
    private double price;
    private Date date;

    public Booking(int id, String title, String details, Client client, double price, Date date) {
        super(id);
        this.title = title;
        this.details = details;
        this.client = client;
        this.price = price;
        this.date = date;
    }

    public Booking(String title, String details, Client client, double price, Date date) {
        this.title = title;
        this.details = details;
        this.client = client;
        this.price = price;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
