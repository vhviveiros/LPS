package controller;

import dao.AddressDao;
import etc.exception.invalid_input_exception.ExistingAddressException;
import etc.exception.invalid_input_exception.InvalidInputException;
import model.Address;
import model.Client;
import validation.AddressValidation;

import java.sql.SQLException;

public class AddressController extends Controller<Address> {
    private final AddressDao addressDao = new AddressDao();

    @Override
    public void insert(String[] args) throws InvalidInputException, SQLException {
        ControllerSingleton.currentUser = new Client(null, false, null, 00000000000, 00000000, null,
                ControllerSingleton.currentUser.getCredentials());

        AddressValidation validation = new AddressValidation(args);

        try {
            addressDao.insert(new Address(
                    validation.addressValidation(),
                    validation.numberValidation(),
                    validation.cidadeValidation(),
                    validation.estadoValidation(),
                    validation.bairroValidation()));
        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate"))
                throw new ExistingAddressException();
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
    public Address getItem(String[] args) {
        return null;
    }

    @Override
    public void updateData(String[] args) throws SQLException {
        ControllerSingleton.currentUser.setAddress(addressDao.getItem(args));
    }
}
