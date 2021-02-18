package repository;

import model.Cliente;
import model.Insumo;

import java.util.NoSuchElementException;

public class ListaClientes extends Repository<Cliente> {
    @Override
    public Cliente findItem(String[] args) {
        try {
            return data.stream().filter(cliente -> cliente.getNome().equals(args[0])).findFirst().get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
