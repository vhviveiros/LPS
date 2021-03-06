package service;

import etc.exception.invalid_input_exception.InvalidInputException;
import model.Model;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Service<T extends Model> {
    protected ArrayList<T> data;

    public abstract void insert(String[] args) throws InvalidInputException, SQLException;

    public abstract void alter(String[] args);

    public abstract void remove(String[] args);

    public abstract T getItem(String[] args);

    public ArrayList<T> getData() {
        return data;
    }

    public abstract void updateData(String[] args) throws SQLException;
}
