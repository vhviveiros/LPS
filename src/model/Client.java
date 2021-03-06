package model;

import java.util.Date;

public class Client extends User {
    public Client(int id, String name, boolean gender, Date birthDate, long cpf, long identity, Address address, Credentials credentials) {
        super(id, name, gender, birthDate, cpf, identity, address, credentials);
    }

    public Client(String name, boolean gender, Date birthDate, long cpf, long identity, Address address, Credentials credentials) {
        super(name, gender, birthDate, cpf, identity, address, credentials);
    }
}
