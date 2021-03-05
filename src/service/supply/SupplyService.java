package service.supply;

import dao.SupplyDAO;
import service.Persistence;
import etc.exception.invalid_input_exception.InvalidInputException;
import model.Supply;
import service.Service;

import java.util.ArrayList;

public class SupplyService implements Service<Supply> {
    private final SupplyDAO supplyDAO = new SupplyDAO();

    @Override
    public void insert(String[] args) throws InvalidInputException {
        SupplyValidation validation = new SupplyValidation(args);

        supplyDAO.insert(new Supply(
                validation.nameValidation(),
                validation.detailsValidation(),
                validation.amountValidation(),
                validation.expirationDateValidation(),
                validation.priceValidation()));
    }

    @Override
    public void alter(String[] args) {

    }

    @Override
    public void remove(String[] args) {

    }

    @Override
    public Supply getItem(String[] args) {
        return supplyDAO.getItem(args);
    }

    @Override
    public ArrayList<Supply> getList(String[] args) {
        return Persistence.SUPPLIES.retrieveData();
    }
}
