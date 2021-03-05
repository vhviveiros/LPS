package service.booking;

import service.Persistence;
import etc.exception.invalid_input_exception.*;
import model.Client;
import model.Cleaner;
import service.Validation;

import java.util.Date;

public class BookingValidation extends Validation {
    private final String title;
    private final String details;
    private final String price;

    public BookingValidation(String[] args) {
        this.title = args[0];
        this.details = args[1];
        this.price = args[2];
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
        if (!(Persistence.user instanceof Client))
            throw new InvalidUserExcepcion();

        return (Client) Persistence.user;
    }

    public double priceValidation() throws InvalidPriceException {
        return super.priceValidation(this.price);
    }

    //TODO:date must be input
    public Date dateValidation() {
        return new Date();
    }
}
