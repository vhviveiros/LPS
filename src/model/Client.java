package model;

import java.util.Date;

public class Client extends User {
    public Client(String nome, boolean sexo, Date nascimento, long cpf, long identidade, Address address) {
        super(nome, sexo, nascimento, cpf, identidade, address);
    }
}
