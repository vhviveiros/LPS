package controller;

import dao.AddressDao;
import etc.exception.invalid_input_exception.InvalidInputException;
import model.Address;
import model.Client;
import validation.AddressValidation;

import java.sql.SQLException;

public class AddressController extends Controller<Address> {
    private final AddressDao addressDao = new AddressDao();

    @Override
    public void insert(String[] args) throws InvalidInputException, SQLException {
        AppVariables.currentUser = new Client(null, false, null, 00000000000, 00000000, null,
                AppVariables.currentUser.getCredentials());

        AddressValidation validation = new AddressValidation(args);

        addressDao.insert(new Address(
                validation.addressValidation(),
                validation.numberValidation(),
                validation.cidadeValidation(),
                validation.estadoValidation(),
                validation.bairroValidation()));
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
        AppVariables.currentUser.setAddress(addressDao.getItem(args));
    }
}