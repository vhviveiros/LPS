package validation;

import etc.exception.invalid_input_exception.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserValidation extends Validation {
    private final String name;
    private final String birthDate;
    private final String cpf;
    private final String identity;

    public UserValidation(String[] args) {
        this.name = args[0];
        this.birthDate = args[1];
        this.cpf = args[2];
        this.identity = args[3];
    }

    public String nameValidation() throws InvalidNameInputException {
        return super.nameValidation(name);
    }

    public Date birthDateValidation() throws InvalidDateException {
        try {
            Date today = new Date();

            String[] birthDateSplit = birthDate.split("/");
            int dd = Integer.parseInt(birthDateSplit[0]);
            int mm = Integer.parseInt(birthDateSplit[1]);

            if (dd > 31 || dd < 1 || mm > 12 || mm < 1)
                throw new InvalidDateException();

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            Date parseDate = format.parse(birthDate);

            if (parseDate.after(today))
                throw new InvalidDateException();

            return parseDate;
        } catch (ParseException | NumberFormatException | InvalidDateException e) {
            throw new InvalidDateException();
        }
    }

    public long cpfValidation() throws InvalidCpfInputException {
        if (cpf == null || cpf.length() != 11)
            throw new InvalidCpfInputException();
        try {
            return Long.parseLong(cpf);
        } catch (NumberFormatException e) {
            throw new InvalidCpfInputException();
        }
    }

    public long identityValidation() throws InvalidIdentityException {
        if (identity == null || identity.length() != 8)
            throw new InvalidIdentityException();
        try {
            return Long.parseLong(identity);
        } catch (NumberFormatException e) {
            throw new InvalidIdentityException();
        }
    }

    public void validate() throws InvalidInputException {
        nameValidation();
        birthDateValidation();
        cpfValidation();
        identityValidation();
    }
}
