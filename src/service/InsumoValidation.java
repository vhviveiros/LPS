package service;

import etc.Persistence;
import etc.exception.invalid_input_exception.InvalidDateException;
import etc.exception.invalid_input_exception.InvalidNameInputException;
import etc.exception.invalid_input_exception.InvalidPriceException;
import etc.exception.invalid_input_exception.InvalidQuantityException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InsumoValidation {
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

    public Date validadeValidation() throws InvalidDateException {
        String [] validadeSplit = validade.split("/");
        int dd = Integer.parseInt(validadeSplit[0]);
        int mm = Integer.parseInt(validadeSplit[1]);
        int yy = Integer.parseInt(validadeSplit[2]);

        if (dd > 31 || dd < 1 || mm > 12 || mm < 1 || yy < 2021) //a data 02/18/2021 estava sendo aceita
            throw new InvalidDateException();

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = format.parse(validade);
            Date today = new Date();

            if (today.after(date))
                throw new InvalidDateException();

            return date;
        } catch (ParseException e) {
            throw new InvalidDateException();
        }
    }

    public double precoValidation() throws InvalidPriceException {
        try {
            double preco = Double.parseDouble(this.preco);

            if (preco < 0)
                throw new InvalidPriceException();

            return preco;
        } catch (NumberFormatException e) {
            throw new InvalidPriceException();
        }
    }
}