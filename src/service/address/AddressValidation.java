package service.address;

import etc.exception.invalid_input_exception.*;
import model.Address;
import service.Validation;

import java.util.Arrays;

public class AddressValidation extends Validation {
    private final String address;
    private final String number;
    private final String city;
    private final String state;
    private final String district;

    public AddressValidation(String [] args) {
        this.address = args[0];
        this.number = args[1];
        this.city = args[2];
        this.state = args[3];
        this.district = args[4];
    }

    public String addressValidation() throws InvalidPlaceException {
        try {
            return super.nameValidation(address);
        } catch (InvalidNameInputException.InvalidCharactersException e) {
            throw new InvalidPlaceException.InvalidCharactersException();
        } catch (InvalidNameInputException.LongNameException e) {
            throw new InvalidPlaceException.LongNameException();
        } catch (InvalidNameInputException.ShortNameException e) {
            throw new InvalidPlaceException.ShortNameException();
        }
    }

    public int numberValidation() throws InvalidHouseNumberException {
        try {
            int convertedNumber = Integer.parseInt(number);
            if (convertedNumber < 1)
                throw new InvalidHouseNumberException();

            return convertedNumber;
        } catch (NumberFormatException e) {
            throw new InvalidHouseNumberException();
        }
    }

    public String cidadeValidation() throws InvalidCityException {
        try {
            return super.nameValidation(city);
        } catch (InvalidNameInputException.InvalidCharactersException e) {
            throw new InvalidCityException.InvalidCharactersException();
        } catch (InvalidNameInputException.LongNameException e) {
            throw new InvalidCityException.LongNameException();
        } catch (InvalidNameInputException.ShortNameException e) {
            throw new InvalidCityException.ShortNameException();
        }
    }

    public String estadoValidation() throws InvalidStateException {
        if (!Arrays.asList(Address.STATES).contains(state))
            throw new InvalidStateException();

        return state;
    }

    public String bairroValidation() throws InvalidDistrictException {
        try {
            return super.nameValidation(district);
        } catch (InvalidNameInputException.InvalidCharactersException e) {
            throw new InvalidDistrictException.InvalidCharactersException();
        } catch (InvalidNameInputException.LongNameException e) {
            throw new InvalidDistrictException.LongNameException();
        } catch (InvalidNameInputException.ShortNameException e) {
            throw new InvalidDistrictException.ShortNameException();
        }
    }
}
