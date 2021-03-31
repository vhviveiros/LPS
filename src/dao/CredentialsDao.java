package dao;

import model.Address;
import model.Credentials;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CredentialsDao implements Dao<Credentials> {
    @Override
    public void insert(Credentials credentials) throws SQLException {
        executeStmt(conn -> {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO tbl_credentials (username, password) values (?,?)");

            ps.setString(1, credentials.getUsername());
            ps.setString(2, credentials.getPassword());

            ps.executeUpdate();
            return null;
        });
    }

    @Override
    public void remove(Credentials model) throws SQLException {

    }

    @Override
    public void alter(Credentials oldValue, Credentials newValue) throws SQLException {

    }

    @Override
    public Credentials getItem(String[] args) throws SQLException {
        return executeStmt(conn -> {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM tbl_credentials WHERE " +
                            "username=?" +
                            " && password=?");

            ps.setString(1, args[0]);
            ps.setString(2, args[1]);

            ResultSet rs = ps.executeQuery();

            if (rs.next())
                return new Credentials(
                        rs.getInt("id"),
                        rs.getString("username"),
                        null
                );
            throw new SQLException();
        });
    }

    @Override
    public ArrayList<Credentials> getList(String[] args) throws SQLException {
        return null;
    }
}

