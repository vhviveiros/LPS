package model;

import java.util.Date;

public class ReservaServico extends TipoDeServico<Cliente> {
    public ReservaServico(String titulo, String informacoes, Cliente cliente, double ValorOfertado, Date dataCriacao) {
        super(titulo, informacoes, cliente, ValorOfertado, dataCriacao);
    }
}
