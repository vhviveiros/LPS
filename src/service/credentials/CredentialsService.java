package service.credentials;

import etc.exception.invalid_input_exception.InvalidInputException;
import model.Credentials;
import service.Service;

import java.sql.SQLException;

public class CredentialsService extends Service<Credentials> {
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
