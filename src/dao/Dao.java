package dao;

import model.Insumo;
import model.Model;

import java.util.ArrayList;

public interface Dao<T extends Model> {
    public void insert(T model);

    public void remove(T model);

    public void alter(T oldValue, T newValue);

    public T getItem(String[] args);

    public ArrayList<T> getList(String[] args);
}
