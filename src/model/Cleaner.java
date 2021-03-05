package model;

import java.util.Date;

public class Cleaner extends User {
    public Cleaner(String nome, boolean sexo, Date nascimento, long cpf, long identidade, Address address) {
        super(nome, sexo, nascimento, cpf, identidade, address);
    }
}
