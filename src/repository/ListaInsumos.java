package repository;

import model.Insumo;

import java.util.NoSuchElementException;

public class ListaInsumos extends Repository<Insumo> {
    @Override
    public Insumo findItem(String[] args) {
        try {
            return data.stream().filter(insumo -> insumo.getNome().equals(args[0])).findFirst().get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
