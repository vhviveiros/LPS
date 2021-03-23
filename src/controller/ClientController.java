package controller;

import dao.ClientDao;
import etc.exception.invalid_input_exception.InvalidInputException;
import model.Client;
import validation.UserValidation;

import java.sql.SQLException;

public class ClientController extends Controller<Client> {
    private final ClientDao clientDao = new ClientDao();

    @Override
    public void insert(String[] args) throws InvalidInputException, SQLException {
        UserValidation validation = new UserValidation(args);

        boolean gender = args[4].equals("Masculino");

        clientDao.insert(new Client(
                validation.nameValidation(),
                gender,
                validation.birthDateValidation(),
                validation.cpfValidation(),
                validation.identityValidation(),
                AppVariables.currentUser.getAddress(),
                AppVariables.currentUser.getCredentials()));
    }

    @Override
    public void alter(String[] args) {

    }

    @Override
    public void remove(String[] args) {

    }

    @Override
    public Client getItem(String[] args) {
        return null;
    }

    @Override
    public void updateData(String[] args) throws SQLException {
        AppVariables.currentUser = clientDao.getItem(args);
    }
}
