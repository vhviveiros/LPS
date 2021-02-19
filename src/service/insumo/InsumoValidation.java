package service.insumo;

import repository.Persistence;
import etc.exception.invalid_input_exception.InvalidDateException;
import etc.exception.invalid_input_exception.InvalidNameInputException;
import etc.exception.invalid_input_exception.InvalidPriceException;
import etc.exception.invalid_input_exception.InvalidQuantityException;
import service.Validation;

import java.util.Date;

public class InsumoValidation extends Validation {
    private final String nome;
    private final String detalhes;
    private final String quantidade;
    private final String validade;
    private final String preco;

    public InsumoValidation(String[] args) {
        nome = args[0];
        detalhes = args[1];
        quantidade = args[2];
        validade = args[3];
        preco = args[4];
    }

    public String nomeInsumoValidation() throws InvalidNameInputException {
        if (Persistence.INSUMO_SERVICE.getItem(new String[]{nome}) != null)
            throw new InvalidNameInputException.ExistingNameException();

        return super.nameValidation(nome);
    }

    public String detalhesValidation() {
        return detalhes;
    }

    public int quantidadeValidation() throws InvalidQuantityException {
        try {
            int qtd = Integer.parseInt(quantidade);

            if (qtd < 1)
                throw new InvalidQuantityException();

            return qtd;
        } catch (NumberFormatException e) {
            throw new InvalidQuantityException();
        }
    }

    public Date validadeValidation() throws InvalidDateException {
        return super.nextDateValidation(validade);
    }

    public double precoValidation() throws InvalidPriceException {
        return super.priceValidation(this.preco);
    }
}
