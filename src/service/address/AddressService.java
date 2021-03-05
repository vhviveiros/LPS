package service.address;

import dao.AddressDao;
import etc.exception.invalid_input_exception.InvalidInputException;
import model.Address;
import service.Service;

import java.util.ArrayList;

public class AddressService implements Service<Address> {
    private final AddressDao addressDao = new AddressDao();

    @Override
    public void insert(String[] args) throws InvalidInputException {
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
    public ArrayList<Address> getList(String[] args) {
        return null;
    }
}
