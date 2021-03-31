package dao;

import model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class UserDao<T extends User> implements Dao<T> {
    @Override
    public void insert(T user) throws SQLException {
        executeStmt(conn -> {
            PreparedStatement ps = conn.prepareStatement(
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
            return null;
        });
    }

    @Override
    public void remove(T user) throws SQLException {
        executeStmt(conn -> {
            PreparedStatement ps = conn.prepareStatement(
                    "DELETE FROM tbl_user WHERE id = ?");
            ps.setInt(1, user.getId());

            ps.executeUpdate();
            return null;
        });
        //logout
    }

    @Override
    public void alter(T oldValue, T newValue) throws SQLException {
        executeStmt(conn -> {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE tbl_user set " +
                            "name = ?, " +
                            "birthdate = ?," +
                            "gender = ?," +
                            "cpf = ?," +
                            "identity = ?," +
                            "user_type = ?," +
                            "tbl_credentials_id = ?, " +
                            "tbl_address_id = ? " +
                            "WHERE id = ?");

            ps.setString(1, newValue.getName());
            ps.setDate(2, new java.sql.Date(newValue.getBirthDate().getTime()));
            ps.setBoolean(3, newValue.getGender());
            ps.setLong(4, newValue.getCpf());
            ps.setLong(5, newValue.getIdentity());
            ps.setBoolean(6, isClient());
            ps.setInt(7, newValue.getCredentials().getId());
            ps.setInt(8, newValue.getAddress().getId());
            ps.setInt(9, oldValue.getId());

            ps.executeUpdate();
            return null;
        });
    }

    @Override
    public ArrayList<T> getList(String[] args) throws SQLException {
        return null;
    }

    protected abstract boolean isClient();
}
