package model;

import java.util.Date;

public class User extends Model{
    private String name;
    private boolean gender;
    private Date birthDate;
    private long cpf;
    private long identity;
    private Address address;

    public User(String name, boolean gender, Date birthDate, long cpf, long identity, Address address) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.cpf = cpf;
        this.identity = identity;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getIdentity() {
        return identity;
    }

    public void setIdentity(long identity) {
        this.identity = identity;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name;
    }
}
