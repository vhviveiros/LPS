package dao;

import model.Address;
import service.Persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddressDao implements Dao<Address> {
    @Override
    public void insert(Address address) throws SQLException {
        PreparedStatement ps = Persistence.CONNECTION.getConnection().prepareStatement("INSERT INTO tbl_address " +
                "(district,address,city,state,number) " +
                "values (?,?,?,?,?)");

        ps.setString(1, address.getDistrict());
        ps.setString(2, address.getAddress());
        ps.setString(3, address.getCity());
        ps.setString(4, address.getState());
        ps.setInt(5, address.getNumber());

        ps.executeUpdate();
    }

    @Override
    public void remove(Address model) {
        Persistence.user.setAddress(null);
    }

    @Override
    public void alter(Address oldValue, Address newValue) throws SQLException {
    }

    @Override
    public Address getItem(String[] args) throws SQLException {
        PreparedStatement ps = Persistence.CONNECTION.getConnection().prepareStatement(
                "SELECT FIRST FROM tbl_address WHERE id=" + args[0]);
        ResultSet rs = ps.executeQuery();

        return new Address(
                rs.getInt("id"),
                rs.getString("address"),
                rs.getInt("number"),
                rs.getString("city"),
                rs.getString("state"),
                rs.getString("district")
        );
    }

    @Override
    public ArrayList<Address> getList(String[] args) {
        return null;
    }
}
