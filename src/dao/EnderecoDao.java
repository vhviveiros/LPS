package dao;

import model.Endereco;
import repository.Persistence;

import java.util.ArrayList;

public class EnderecoDao implements Dao<Endereco> {
    @Override
    public void insert(Endereco endereco) {
        Persistence.usuario.setEndereco(endereco);
    }

    @Override
    public void remove(Endereco model) {
        Persistence.usuario.setEndereco(null);
    }

    @Override
    public void alter(Endereco oldValue, Endereco newValue) {
        Persistence.usuario.setEndereco(newValue);
    }

    @Override
    public Endereco getItem(String[] args) {
        return Persistence.usuario.getEndereco();
    }

    @Override
    public ArrayList<Endereco> getList(String[] args) {
        return null;
    }
}
