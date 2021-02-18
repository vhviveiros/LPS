package model;

import java.util.Date;

public class Usuario extends Model{
    private String nome;
    private boolean sexo;
    private Date nascimento;
    private int cpf;
    private int identidade;
    private Endereco endereco;

    public Usuario(String nome, boolean sexo, Date nascimento, int cpf, int identidade, Endereco endereco) {
        this.nome = nome;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.identidade = identidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getIdentidade() {
        return identidade;
    }

    public void setIdentidade(int identidade) {
        this.identidade = identidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return nome;
    }
}
