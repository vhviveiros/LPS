package dao;

import model.Model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Dao<T extends Model> {
    static final Connection CONNECTION = new Connection();

    public void insert(T model) throws SQLException;

    public void remove(T model);

    public void alter(T oldValue, T newValue) throws SQLException;

    public T getItem(String[] args) throws SQLException;

    public ArrayList<T> getList(String[] args) throws SQLException;
}
