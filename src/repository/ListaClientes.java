package repository;

import model.Client;

import java.util.NoSuchElementException;

public class ListaClientes extends Repository<Client> {
    @Override
    public Client findItem(String[] args) {
        try {
            return data.stream().filter(cliente -> cliente.getName().equals(args[0])).findFirst().get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
