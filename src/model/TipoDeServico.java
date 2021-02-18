package model;

import java.util.Date;

public abstract class TipoDeServico<T extends Usuario> extends Model{
    private String titulo;
    private String informacoes;
    private T usuario;
    private double preco;
    private Date dataCriacao;

    public TipoDeServico(String titulo, String informacoes, T usuario, double preco, Date dataCriacao) {
        this.titulo = titulo;
        this.informacoes = informacoes;
        this.usuario = usuario;
        this.preco = preco;
        this.dataCriacao = dataCriacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    public T getUsuario() {
        return usuario;
    }

    public void setUsuario(T usuario) {
        this.usuario = usuario;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
