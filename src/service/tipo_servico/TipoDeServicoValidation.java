package service.tipo_servico;

import repository.Persistence;
import etc.exception.invalid_input_exception.*;
import model.Cliente;
import model.Faxineiro;
import service.Validation;

import java.util.Date;

public class TipoDeServicoValidation extends Validation {
    private final String titulo;
    private final String informacoes;
    private final String valorOferecido;

    public TipoDeServicoValidation(String[] args) {
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
        if (!(Persistence.usuario instanceof Cliente))
            throw new InvalidUserExcepcion();

        return (Cliente) Persistence.usuario;
    }

    public Faxineiro faxineiroValidation() throws InvalidUserExcepcion {
        if (!(Persistence.usuario instanceof Faxineiro))
            throw new InvalidUserExcepcion();

        return (Faxineiro) Persistence.usuario;
    }

    public double valorOferecidoValidation() throws InvalidPriceException {
        return super.priceValidation(this.valorOferecido);
    }

    public Date dataReservaValidation() {
        return new Date();
    }
}
