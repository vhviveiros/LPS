package controller;

import dao.SupplyDAO;
import etc.exception.invalid_input_exception.InvalidInputException;
import model.Supply;
import validation.SupplyValidation;

import java.sql.SQLException;

public class SupplyController extends Controller<Supply> {
    private final SupplyDAO supplyDAO = new SupplyDAO();

    @Override
    public void insert(String[] args) throws InvalidInputException, SQLException {
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
    public void updateData(String[] args) throws SQLException {
        data = supplyDAO.getList(args);
    }
}
