package service.reserva_servico;

import etc.Persistence;
import etc.exception.invalid_input_exception.*;
import model.Cliente;
import service.Validation;

import java.util.Date;

public class ReservaServicoValidation extends Validation {
    private String titulo;
    private String informacoes;
    private String valorOferecido;

    public ReservaServicoValidation(String[] args) {
        this.titulo = args[0];
        this.informacoes = args[1];
        this.valorOferecido = args[2];
    }

    public String tituloValidation() throws InvalidNameInputException {
        return super.nameValidation(titulo);
    }

    public String informacoesValidation() throws InvalidDescriptionException.LongDescriptionException {
        if (informacoes.length() > 500)
            throw new InvalidDescriptionException.LongDescriptionException();

        return informacoes;
    }

    public Cliente clienteValidation() throws InvalidUserExcepcion {
        if (!(Persistence.USUARIO instanceof Cliente))
            throw new InvalidUserExcepcion();

        return (Cliente) Persistence.USUARIO;
    }

    public double valorOferecidoValidation() throws InvalidPriceException {
        return super.priceValidation(this.valorOferecido);
    }

    public Date dataReservaValidation() {
        return new Date();
    }
}
