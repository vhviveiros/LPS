package model;

import java.util.Date;

public class Faxineiro extends Usuario{
    public Faxineiro(String nome, boolean sexo, Date nascimento, long cpf, long identidade, Endereco endereco) {
        super(nome, sexo, nascimento, cpf, identidade, endereco);
    }
}
