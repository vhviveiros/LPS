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
        PreparedStatement ps = CONNECTION.getConnection().prepareStatement("INSERT INTO tbl_address " +
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
        ControllerSingleton.currentUser.setAddress(null);
    }

    @Override
    public void alter(Address oldValue, Address newValue) throws SQLException {
    }

    @Override
    public Address getItem(String[] args) throws SQLException {
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
    }

    @Override
    public ArrayList<Address> getList(String[] args) {
        return null;
    }
}
