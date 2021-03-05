package dao;

import service.Persistence;
import model.Supply;

import java.util.ArrayList;

public class SupplyDAO implements Dao<Supply> {
    @Override
    public void insert(Supply supply) {
        Persistence.SUPPLIES.addItem(supply);
    }

    @Override
    public void remove(Supply supply) {

    }

    @Override
    public void alter(Supply oldValue, Supply newValue) {

    }

    @Override
    public Supply getItem(String[] args) {
        return Persistence.SUPPLIES.findItem(args);
    }

    @Override
    public ArrayList<Supply> getList(String[] args) {
        return Persistence.SUPPLIES.retrieveData();
    }

}
