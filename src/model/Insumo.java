package model;

import java.util.Date;

public class Insumo extends Model {
    private String nome;
    private String detalhes;
    private int quantidade;
    private Date validade;
    private double preco;

    public Insumo(String nome, String detalhes, int quantidade, Date validade, double preco) {
        this.nome = nome;
        this.detalhes = detalhes;
        this.quantidade = quantidade;
        this.validade = validade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
