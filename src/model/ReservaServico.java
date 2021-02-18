package model;

import java.util.Date;

public class ReservaServico extends Model {
    private String titulo;
    private String informacoes;
    private Cliente cliente;
    private double valorOferecido;
    private Date dataReserva;

    public ReservaServico(String titulo, String informacoes, Cliente cliente, double valorOferecido, Date dataReserva) {
        this.titulo = titulo;
        this.informacoes = informacoes;
        this.cliente = cliente;
        this.valorOferecido = valorOferecido;
        this.dataReserva = dataReserva;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValorOferecido() {
        return valorOferecido;
    }

    public void setValorOferecido(double valorOferecido) {
        this.valorOferecido = valorOferecido;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
