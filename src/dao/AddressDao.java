package dao;

import model.Address;
import controller.ControllerSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddressDao implements Dao<Address> {
    @Override
    public void insert(Address address) throws SQLException {
        executeStmt(conn -> {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO tbl_address " +
                    "(district,address,city,state,number) " +
                    "values (?,?,?,?,?)");

            ps.setString(1, address.getDistrict());
            ps.setString(2, address.getAddress());
            ps.setString(3, address.getCity());
            ps.setString(4, address.getState());
            ps.setInt(5, address.getNumber());

            ps.executeUpdate();
            return null;
        });
    }

    @Override
    public void remove(Address address) throws SQLException {
        executeStmt(conn -> {
            PreparedStatement ps = conn.prepareStatement(
                    "DELETE FROM tbl_address WHERE id = ?");
            ps.setInt(1, address.getId());

            ps.executeUpdate();
            return null;
        });
        ControllerSingleton.currentUser.setAddress(null);
    }

    @Override
    public void alter(Address oldValue, Address newValue) throws SQLException {
        executeStmt(conn -> {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE tbl_address set " +
                            "district = ?, " +
                            "address = ?," +
                            "city = ?," +
                            "state = ?," +
                            "number = ?" +
                            "WHERE id = ?");

            ps.setString(1, newValue.getDistrict());
            ps.setString(2, newValue.getAddress());
            ps.setString(3, newValue.getCity());
            ps.setString(4, newValue.getState());
            ps.setInt(5, newValue.getNumber());
            ps.setInt(6, oldValue.getId());

            ps.executeUpdate();
            return null;
        });
    }

    @Override
    public Address getItem(String[] args) throws SQLException {
        return executeStmt(conn -> {
            PreparedStatement ps = CONNECTION.getConnection().prepareStatement(
                    "SELECT * FROM tbl_address WHERE " +
                            "address=" + "\"" + args[0] + "\"" +
                            " && number=" + "\"" + args[1] + "\"" +
                            " && city=" + "\"" + args[2] + "\"" +
                            " && state=" + "\"" + args[3] + "\"" +
                            " && district=" + "\"" + args[4] + "\"");
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                return new Address(
                        rs.getInt("id"),
                        rs.getString("address"),
                        rs.getInt("number"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("district")
                );
            throw new SQLException();
        });
    }

    @Override
    public ArrayList<Address> getList(String[] args) {
        return null;
    }
}
