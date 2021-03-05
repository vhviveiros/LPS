package dao;

import model.Address;
import service.Persistence;

import java.util.ArrayList;

public class AddressDao implements Dao<Address> {
    @Override
    public void insert(Address address) {
        Persistence.user.setAddress(address);
    }

    @Override
    public void remove(Address model) {
        Persistence.user.setAddress(null);
    }

    @Override
    public void alter(Address oldValue, Address newValue) {
        Persistence.user.setAddress(newValue);
    }

    @Override
    public Address getItem(String[] args) {
        return Persistence.user.getAddress();
    }

    @Override
    public ArrayList<Address> getList(String[] args) {
        return null;
    }
}
