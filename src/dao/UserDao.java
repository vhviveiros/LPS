package dao;

import model.User;
import service.Persistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class UserDao <T extends User> implements Dao<T>{
    @Override
    public void insert(T user) throws SQLException {
        PreparedStatement ps = Persistence.CONNECTION.getConnection().prepareStatement(
                "INSERT INTO tbl_user (name,birthdate,gender,cpf,identity,user_type,tbl_credentials_id,tbl_address_id) values " +
                        "(?,?,?,?,?,?,?,?)");

        ps.setString(1, user.getName());
        ps.setDate(2, new java.sql.Date(user.getBirthDate().getTime()));
        ps.setBoolean(3, user.getGender());
        ps.setLong(4, user.getCpf());
        ps.setLong(5, user.getIdentity());
        ps.setBoolean(6, isClient());
        ps.setInt(7, user.getCredentials().getId());
        ps.setInt(8, user.getAddress().getId());

        ps.executeUpdate();
    }

    @Override
    public void remove(T model) {

    }

    @Override
    public void alter(T oldValue, T newValue) throws SQLException {

    }

    @Override
    public ArrayList<T> getList(String[] args) throws SQLException {
        return null;
    }

    protected abstract boolean isClient();
}
