package service;

import etc.exception.invalid_input_exception.InvalidNameInputException;
import etc.exception.invalid_input_exception.InvalidQuantityException;
import model.Model;

import java.util.ArrayList;

public interface Service<T extends Model> {
    public void insert(String [] args) throws InvalidNameInputException, InvalidQuantityException;

    public void alter(String [] args);

    public void remove(String [] args);

    public T getItem(String [] args);

    public ArrayList<T> getList(String [] args);
}
