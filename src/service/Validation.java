package service;

import etc.exception.invalid_input_exception.InvalidDateException;
import etc.exception.invalid_input_exception.InvalidNameInputException;
import etc.exception.invalid_input_exception.InvalidPriceException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Validation {
    protected double priceValidation(String price) throws InvalidPriceException {
        try {
            double priceDouble = Double.parseDouble(price);

            if (priceDouble < 0)
                throw new InvalidPriceException();

            return priceDouble;
        } catch (NumberFormatException e) {
            throw new InvalidPriceException();
        }
    }

    protected Date nextDateValidation(String date) throws InvalidDateException {
        try {
            String[] dateSplit = date.split("/");
            int dd = Integer.parseInt(dateSplit[0]);
            int mm = Integer.parseInt(dateSplit[1]);
            int yy = Integer.parseInt(dateSplit[2]);

            if (dd > 31 || dd < 1 || mm > 12 || mm < 1 || yy < 2021) //a data 02/18/2021 estava sendo aceita
                throw new InvalidDateException();

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            Date parseDate = format.parse(date);
            Date today = new Date();

            if (today.after(parseDate))
                throw new InvalidDateException();

            return parseDate;
        } catch (ParseException | NumberFormatException e) {
            throw new InvalidDateException();
        }
    }

    protected String nameValidation(String name) throws InvalidNameInputException.InvalidCharactersException, InvalidNameInputException.LongNameException, InvalidNameInputException.ShortNameException {
        Pattern pattern = Pattern.compile("[~#@*+%{}<>\\[\\]|\"\\_^]");
        Matcher matcher = pattern.matcher(name);

        if (matcher.find())
            throw new InvalidNameInputException.InvalidCharactersException();

        if (name.length() > 150)
            throw new InvalidNameInputException.LongNameException();

        if (name.length() < 3)
            throw new InvalidNameInputException.ShortNameException();

        return name;
    }
}
