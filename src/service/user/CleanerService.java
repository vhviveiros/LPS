package service.user;

import dao.CleanerDao;
import etc.exception.invalid_input_exception.InvalidInputException;
import model.Cleaner;
import service.Persistence;
import service.Service;

import java.sql.SQLException;

public class CleanerService extends Service<Cleaner> {
    private final CleanerDao cleanerDao = new CleanerDao();

    @Override
    public void insert(String[] args) throws InvalidInputException, SQLException {
        UserValidation validation = new UserValidation(args);

        boolean gender = args[4].equals("Masculino");

        cleanerDao.insert(new Cleaner(
                validation.nameValidation(),
                gender,
                validation.birthDateValidation(),
                validation.cpfValidation(),
                validation.identityValidation(),
                Persistence.user.getAddress(),
                Persistence.user.getCredentials()));
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
