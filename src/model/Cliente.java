package model;

import java.util.Date;

public class Cliente extends Usuario{
    public Cliente(String nome, boolean sexo, Date nascimento, long cpf, long identidade, Endereco endereco) {
        super(nome, sexo, nascimento, cpf, identidade, endereco);
    }
}
