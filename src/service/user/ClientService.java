package service.user;

import dao.UserDao;
import etc.exception.invalid_input_exception.InvalidInputException;
import model.Client;
import service.Service;

import java.util.ArrayList;

public class ClientService implements Service<Client> {
    private final UserDao userDao = new UserDao();

    @Override
    public void insert(String[] args) throws InvalidInputException {
        UserValidation validation = new UserValidation(args);

        boolean gender = args[4].equals("Masculino");

        userDao.insert(new Client(
                validation.nameValidation(),
                gender,
                validation.birthDateValidation(),
                validation.cpfValidation(),
                validation.identityValidation(),null));
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
    public ArrayList<Client> getList(String[] args) {
        return null;
    }
}
