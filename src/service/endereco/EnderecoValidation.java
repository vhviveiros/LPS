package service.endereco;

import etc.exception.invalid_input_exception.*;
import model.Endereco;
import service.Validation;

import java.util.Arrays;

public class EnderecoValidation extends Validation {
    private final String logradouro;
    private final String numero;
    private final String cidade;
    private final String estado;
    private final String bairro;

    public EnderecoValidation(String [] args) {
        this.logradouro = args[0];
        this.numero = args[1];
        this.cidade = args[2];
        this.estado = args[3];
        this.bairro = args[4];
    }

    public String logradouroValidation() throws InvalidPlaceException {
        try {
            return super.nameValidation(logradouro);
        } catch (InvalidNameInputException.InvalidCharactersException e) {
            throw new InvalidPlaceException.InvalidCharactersException();
        } catch (InvalidNameInputException.LongNameException e) {
            throw new InvalidPlaceException.LongNameException();
        } catch (InvalidNameInputException.ShortNameException e) {
            throw new InvalidPlaceException.ShortNameException();
        }
    }

    public int numeroValidation() throws InvalidHouseNumberException {
        try {
            int numeroConvertido = Integer.parseInt(numero);
            if (numeroConvertido < 1)
                throw new InvalidHouseNumberException();

            return numeroConvertido;
        } catch (NumberFormatException e) {
            throw new InvalidHouseNumberException();
        }
    }

    public String cidadeValidation() throws InvalidCityException {
        try {
            return super.nameValidation(cidade);
        } catch (InvalidNameInputException.InvalidCharactersException e) {
            throw new InvalidCityException.InvalidCharactersException();
        } catch (InvalidNameInputException.LongNameException e) {
            throw new InvalidCityException.LongNameException();
        } catch (InvalidNameInputException.ShortNameException e) {
            throw new InvalidCityException.ShortNameException();
        }
    }

    public String estadoValidation() throws InvalidStateException {
        if (!Arrays.asList(Endereco.ESTADOS).contains(estado))
            throw new InvalidStateException();

        return estado;
    }

    public String bairroValidation() throws InvalidDistrictException {
        try {
            return super.nameValidation(bairro);
        } catch (InvalidNameInputException.InvalidCharactersException e) {
            throw new InvalidDistrictException.InvalidCharactersException();
        } catch (InvalidNameInputException.LongNameException e) {
            throw new InvalidDistrictException.LongNameException();
        } catch (InvalidNameInputException.ShortNameException e) {
            throw new InvalidDistrictException.ShortNameException();
        }
    }
}
