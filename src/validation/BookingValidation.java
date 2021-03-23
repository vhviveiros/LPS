package validation;

import controller.AppVariables;
import etc.exception.invalid_input_exception.*;
import model.Client;

import java.util.Date;

public class BookingValidation extends Validation {
    private final String title;
    private final String details;
    private final String price;
    private final String date;

    public BookingValidation(String[] args) {
        this.title = args[0];
        this.details = args[1];
        this.price = args[2];
        this.date = args[3];
    }

    public String titleValidation() throws InvalidNameInputException {
        return super.nameValidation(title);
    }

    public String detailsValidation() throws InvalidDescriptionException.LongDescriptionException {
        if (details.length() > 500)
            throw new InvalidDescriptionException.LongDescriptionException();

        return details;
    }

    public Client clientValidation() throws InvalidUserExcepcion {
        if (!(AppVariables.currentUser instanceof Client))
            throw new InvalidUserExcepcion();

        return (Client) AppVariables.currentUser;
    }

    public double priceValidation() throws InvalidPriceException {
        return super.priceValidation(this.price);
    }

    public Date dateValidation() throws InvalidDateException {
        return super.nextDateValidation(date);
    }
}
