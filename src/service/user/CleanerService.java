package service.user;

import dao.UserDao;
import etc.exception.invalid_input_exception.InvalidInputException;
import model.Cleaner;
import service.Service;

import java.util.ArrayList;

public class CleanerService implements Service<Cleaner> {
    private final UserDao userDao = new UserDao();

    @Override
    public void insert(String[] args) throws InvalidInputException {
        UserValidation validation = new UserValidation(args);

        boolean gender = args[4].equals("Masculino");

        userDao.insert(new Cleaner(
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
    public Cleaner getItem(String[] args) {
        return null;
    }

    @Override
    public ArrayList<Cleaner> getList(String[] args) {
        return null;
    }
}
