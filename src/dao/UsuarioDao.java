package dao;

import model.Usuario;
import repository.Persistence;

import java.util.ArrayList;

public class UsuarioDao implements Dao<Usuario> {
    @Override
    public void insert(Usuario usuario) {
        Persistence.usuario = usuario;
    }

    @Override
    public void remove(Usuario usuario) {

    }

    @Override
    public void alter(Usuario oldValue, Usuario newValue) {

    }

    @Override
    public Usuario getItem(String[] args) {
        return null;
    }

    @Override
    public ArrayList<Usuario> getList(String[] args) {
        return null;
    }
}
