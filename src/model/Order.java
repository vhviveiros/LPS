package model;

import java.util.ArrayList;

public class Order extends Model{
    //Avaliacao avaliacao;
    private String details;
    //Pagamento pagamento;
    private ArrayList<Supply> usedSupplies;
    private Client client;
    private Booking booking;

    public Order(String details, ArrayList<Supply> usedSupplies, Client client, Booking booking) {
        this.details = details;
        this.usedSupplies = usedSupplies;
        this.client = client;
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

    public Client getCliente() {
        return client;
    }

    public void setCliente(Client client) {
        this.client = client;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
