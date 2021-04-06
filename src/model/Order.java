package model;

import java.util.ArrayList;

public class Order extends Model{
    //Avaliacao avaliacao;
    private String details;
    //Pagamento pagamento;
    private ArrayList<Supply> usedSupplies;
    private Cleaner cleaner;
    private Booking booking;

    public Order(int id, String details, ArrayList<Supply> usedSupplies, Cleaner cleaner, Booking booking) {
        super(id);
        this.details = details;
        this.usedSupplies = usedSupplies;
        this.cleaner = cleaner;
        this.booking = booking;
    }

    public Order(String details, ArrayList<Supply> usedSupplies, Cleaner cleaner, Booking booking) {
        this.details = details;
        this.usedSupplies = usedSupplies;
        this.cleaner = cleaner;
        this.booking = booking;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public ArrayList<Supply> getUsedSupplies() {
        return usedSupplies;
    }

    public void setUsedSupplies(ArrayList<Supply> usedSupplies) {
        this.usedSupplies = usedSupplies;
    }

    public Cleaner getCleanere() {
        return cleaner;
    }

    public void setCleanere(Cleaner cleaner) {
        this.cleaner = cleaner;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
