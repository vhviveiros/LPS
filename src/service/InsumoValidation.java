package service;

import etc.Persistence;
import etc.exception.invalid_input_exception.InvalidNameInputException;
import etc.exception.invalid_input_exception.InvalidQuantityException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InsumoValidation {
    private String nome;
    private String detalhes;
    private String quantidade;
    private String validade;
    private String preco;

    public InsumoValidation(String [] args) {
        nome = args[0];
        detalhes = args[1];
        quantidade = args[2];
        validade = args[3];
        preco = args[4];
    }

    public String nomeInsumoValidation() throws InvalidNameInputException {
        if (Persistence.INSUMO_SERVICE.getItem(new String[]{nome}) != null)
            throw new InvalidNameInputException.ExistingNameException();

        Pattern pattern = Pattern.compile("[~#@*+%{}<>\\[\\]|\"\\_^]");
        Matcher matcher = pattern.matcher(nome);

        if (matcher.find())
            throw new InvalidNameInputException.InvalidCharactersException();

        if (nome.length() > 80)
            throw new InvalidNameInputException.LongNameException();

        if (nome.length() < 3)
            throw new InvalidNameInputException.ShortNameException();

        return nome;
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
}
