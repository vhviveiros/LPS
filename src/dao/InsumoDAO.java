package dao;

import etc.Persistence;
import model.Insumo;

import java.util.ArrayList;

public class InsumoDAO implements Dao<Insumo> {
    @Override
    public void insert(Insumo insumo) {
        Persistence.INSUMOS.addItem(insumo);
    }

    @Override
    public void remove(Insumo insumo) {

    }

    @Override
    public void alter(Insumo oldValue, Insumo newValue) {

    }

    @Override
    public Insumo getItem(String[] args) {
        return Persistence.INSUMOS.findItem(args);
    }

    @Override
    public ArrayList<Insumo> getList(String[] args) {
        return Persistence.INSUMOS.retrieveData();
    }

}
