package model;

import java.util.Date;

public class OfertaServico extends TipoDeServico<Faxineiro> {
    public OfertaServico(String titulo, String informacoes, Faxineiro faxineiro, double valorCobrado, Date dataCriacao) {
        super(titulo, informacoes, faxineiro, valorCobrado, dataCriacao);
    }
}
