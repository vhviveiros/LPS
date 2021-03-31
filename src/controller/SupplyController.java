package controller;

import dao.SupplyDAO;
import etc.exception.invalid_input_exception.InvalidInputException;
import model.Booking;
import model.Supply;
import validation.BookingValidation;
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
    public void alter(String[] args) throws InvalidInputException, SQLException {
        final SupplyValidation validation = new SupplyValidation(new String[]{args[1], args[2], args[3], args[4], args[5]});
        final Supply oldSupply = data.get(Integer.parseInt(args[0]));
        final Supply newSupply = new Supply(
                oldSupply.getId(),
                validation.nameValidation(),
                validation.detailsValidation(),
                validation.amountValidation(),
                validation.expirationDateValidation(),
                validation.priceValidation());
        supplyDAO.alter(oldSupply, newSupply);
    }

    @Override
    public void remove(String[] args) throws SQLException {
        supplyDAO.remove(data.get(Integer.parseInt(args[0])));
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
