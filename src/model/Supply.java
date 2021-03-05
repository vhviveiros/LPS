package model;

import java.util.Date;

public class Supply extends Model {
    private String name;
    private String details;
    private int amount;
    private Date expirationDate;
    private double price;

    public Supply(String name, String details, int amount, Date expirationDate, double price) {
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
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
