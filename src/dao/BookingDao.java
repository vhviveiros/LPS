package dao;

import model.Booking;
import service.Persistence;

import java.util.ArrayList;

public class BookingDao implements Dao<Booking> {
    @Override
    public void insert(Booking booking) {
        Persistence.BOOKINGS.addItem(booking);
    }

    @Override
    public void remove(Booking booking) {

    }

    @Override
    public void alter(Booking oldValue, Booking newValue) {

    }

    @Override
    public Booking getItem(String[] args) {
        return null;
    }

    @Override
    public ArrayList<Booking> getList(String[] args) {
        return Persistence.BOOKINGS.retrieveData();
    }
}
