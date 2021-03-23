package validation;

import controller.AppVariables;
import etc.exception.invalid_input_exception.InvalidDateException;
import etc.exception.invalid_input_exception.InvalidNameInputException;
import etc.exception.invalid_input_exception.InvalidPriceException;
import etc.exception.invalid_input_exception.InvalidQuantityException;

import java.util.Date;

public class SupplyValidation extends Validation {
    private final String name;
    private final String details;
    private final String amount;
    private final String expirationDate;
    private final String price;

    public SupplyValidation(String[] args) {
        name = args[0];
        details = args[1];
        amount = args[2];
        expirationDate = args[3];
        price = args[4];
    }

    public String nameValidation() throws InvalidNameInputException {
        if (AppVariables.SUPPLY_SERVICE.getItem(new String[]{name}) != null)
            throw new InvalidNameInputException.ExistingNameException();

        return super.nameValidation(name);
    }

    public String detailsValidation() {
        return details;
    }

    public int amountValidation() throws InvalidQuantityException {
        try {
            int qtd = Integer.parseInt(amount);

            if (qtd < 1)
                throw new InvalidQuantityException();

            return qtd;
        } catch (NumberFormatException e) {
            throw new InvalidQuantityException();
        }
    }

    public Date expirationDateValidation() throws InvalidDateException {
        return super.nextDateValidation(expirationDate);
    }

    public double priceValidation() throws InvalidPriceException {
        return super.priceValidation(this.price);
    }
}
