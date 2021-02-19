package service.usuario;

import etc.exception.invalid_input_exception.InvalidCpfInputException;
import etc.exception.invalid_input_exception.InvalidDateException;
import etc.exception.invalid_input_exception.InvalidNameInputException;
import etc.exception.invalid_input_exception.InvalididentityException;
import service.Validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsuarioValidation extends Validation {
    private String nome;
    private String nascimento;
    private String cpf;
    private String identidade;

    public UsuarioValidation(String[] args) {
        this.nome = args[0];
        this.nascimento = args[1];
        this.cpf = args[2];
        this.identidade = args[3];
    }

    public String nomeValidation() throws InvalidNameInputException {
        return super.nameValidation(nome);
    }

    public Date nascimentoValidation() throws InvalidDateException {
        try {
            Date today = new Date();

            String[] validadeSplit = nascimento.split("/");
            int dd = Integer.parseInt(validadeSplit[0]);
            int mm = Integer.parseInt(validadeSplit[1]);

            if (dd > 31 || dd < 1 || mm > 12 || mm < 1)
                throw new InvalidDateException();

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            Date parseDate = format.parse(nascimento);

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

    public long identidadeValidation() throws InvalididentityException {
        if (identidade == null || identidade.length() != 8)
            throw new InvalididentityException();
        try {
            return Long.parseLong(identidade);
        } catch (NumberFormatException e) {
            throw new InvalididentityException();
        }
    }
}
