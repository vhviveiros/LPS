package dao;

import controller.ControllerSingleton;
import model.Supply;

import java.sql.*;
import java.util.ArrayList;

public class SupplyDAO implements Dao<Supply> {
    @Override
    public void insert(Supply supply) throws SQLException {
        executeStmt(conn -> {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO tbl_supply (name,details,amount,expiration_date,price,cleaner_id) values (?,?,?,?,?,?)");

            ps.setString(1, supply.getName());
            ps.setString(2, supply.getDetails());
            ps.setFloat(3, (float) supply.getAmount());
            if (supply.getExpirationDate() == null)
                ps.setNull(4, Types.DATE);
            else
                ps.setDate(4, new java.sql.Date(supply.getExpirationDate().getTime()));
            ps.setFloat(5, (float) supply.getPrice());
            ps.setInt(6, ControllerSingleton.currentUser.getId());

            ps.executeUpdate();
            return null;
        });
    }

    @Override
    public void remove(Supply supply) throws SQLException {
        executeStmt(conn -> {
            PreparedStatement ps = conn.prepareStatement(
                    "DELETE FROM tbl_supply WHERE id = ?");
            ps.setInt(1, supply.getId());

            ps.executeUpdate();
            return null;
        });
    }

    @Override
    public void alter(Supply oldValue, Supply newValue) throws SQLException {
        executeStmt(conn -> {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE tbl_supply set " +
                            "name=?, " +
                            "details=?, " +
                            "amount=?, " +
                            "expiration_date=?, " +
                            "price=? " +
                            "WHERE id=?");

            ps.setString(1, newValue.getName());
            ps.setString(2, newValue.getDetails());
            ps.setFloat(3, (float) newValue.getAmount());
            if (newValue.getExpirationDate() == null)
                ps.setNull(4, Types.DATE);
            else
                ps.setDate(4, new java.sql.Date(newValue.getExpirationDate().getTime()));
            ps.setFloat(5, (float) newValue.getPrice());
            ps.setInt(6, newValue.getId());

            ps.executeUpdate();
            return null;
        });
    }

    @Override
    public Supply getItem(String[] args) {
        return null;
    }

    @Override
    public ArrayList<Supply> getList(String[] args) throws SQLException {
        return executeStmt(conn -> {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM tbl_supply WHERE cleaner_id=" + args[0]);
            ResultSet rs = ps.executeQuery();

            var returnValue = new ArrayList<Supply>();

            while (rs.next()) {
                var date = rs.getDate("expiration_date");

                returnValue.add(new Supply(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("details"),
                        rs.getFloat("amount"),
                        date == null ? null : new java.util.Date(date.getTime()),
                        rs.getFloat("price")
                ));
            }

            return returnValue;
        });
    }
}
