package controller;

import dao.CleanerDao;
import etc.exception.invalid_input_exception.ExistingUserException;
import etc.exception.invalid_input_exception.InvalidInputException;
import model.Cleaner;
import validation.UserValidation;

import java.sql.SQLException;

public class CleanerController extends Controller<Cleaner> {
    private final CleanerDao cleanerDao = new CleanerDao();

    @Override
    public void insert(String[] args) throws InvalidInputException, SQLException {
        UserValidation validation = new UserValidation(args);

        boolean gender = args[4].equals("Masculino");

        try {
            cleanerDao.insert(new Cleaner(
                    validation.nameValidation(),
                    gender,
                    validation.birthDateValidation(),
                    validation.cpfValidation(),
                    validation.identityValidation(),
                    ControllerSingleton.currentUser.getAddress(),
                    ControllerSingleton.currentUser.getCredentials()));
        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate"))
                throw new ExistingUserException();
            throw e;
        }
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
    public void updateData(String[] args) throws SQLException {

    }
}
