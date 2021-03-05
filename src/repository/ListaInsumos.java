package repository;

import model.Supply;

import java.util.NoSuchElementException;

public class ListaInsumos extends Repository<Supply> {
    @Override
    public Supply findItem(String[] args) {
        try {
            return data.stream().filter(insumo -> insumo.getName().equals(args[0])).findFirst().get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
