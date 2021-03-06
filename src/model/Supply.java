package model;

import java.util.Date;

public class Supply extends Model {
    private String name;
    private String details;
    private double amount;
    private Date expirationDate;
    private double price;

    public Supply(int id, String name, String details, double amount, Date expirationDate, double price) {
        super(id);
        this.name = name;
        this.details = details;
        this.amount = amount;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    public Supply(String name, String details, double amount, Date expirationDate, double price) {
        this.name = name;
        this.details = details;
        this.amount = amount;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
