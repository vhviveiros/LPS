package dao;

import controller.AppVariables;
import model.Supply;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplyDAO implements Dao<Supply> {
    @Override
    public void insert(Supply supply) throws SQLException {
        PreparedStatement ps = CONNECTION.getConnection().prepareStatement(
                "INSERT INTO tbl_supply (name,details,amount,expiration_date,price,cleaner_id) values (?,?,?,?,?,?)");

        ps.setString(1, supply.getName());
        ps.setString(2, supply.getDetails());
        ps.setFloat(3, (float) supply.getAmount());
        ps.setDate(4, new java.sql.Date(supply.getExpirationDate().getTime()));
        ps.setFloat(5, (float) supply.getPrice());
        ps.setInt(6, AppVariables.currentUser.getId());

        ps.executeUpdate();
    }

    @Override
    public void remove(Supply supply) {

    }

    @Override
    public void alter(Supply oldValue, Supply newValue) {

    }

    @Override
    public Supply getItem(String[] args) {
        return null;
    }

    @Override
    public ArrayList<Supply> getList(String[] args) throws SQLException {
        PreparedStatement ps = CONNECTION.getConnection().prepareStatement(
                "SELECT * FROM tbl_supply WHERE cleaner_id=" + args[0]);
        ResultSet rs = ps.executeQuery();

        var returnValue = new ArrayList<Supply>();

        while (rs.next()) {
            returnValue.add(new Supply(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("details"),
                    rs.getFloat("amount"),
                    new java.util.Date(rs.getDate("expiration_date").getTime()),
                    rs.getFloat("price")
            ));
        }

        return returnValue;
    }

}
