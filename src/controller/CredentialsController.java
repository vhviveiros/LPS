package controller;

import etc.exception.invalid_input_exception.InvalidInputException;
import model.Credentials;

import java.sql.SQLException;

public class CredentialsController extends Controller<Credentials> {
    @Override
    public void insert(String[] args) throws InvalidInputException {

    }

    @Override
    public void alter(String[] args) {

    }

    @Override
    public void remove(String[] args) {

    }

    @Override
    public Credentials getItem(String[] args) {
        return new Credentials("user", "passwd");
    }

    @Override
    public void updateData(String[] args) throws SQLException {

    }
}
