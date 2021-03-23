package dao;

import model.Booking;
import controller.AppVariables;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingDao implements Dao<Booking> {
    @Override
    public void insert(Booking booking) throws SQLException {
        PreparedStatement ps = AppVariables.CONNECTION.getConnection().prepareStatement(
                "INSERT INTO tbl_booking (title,details,price,date,client_id) values (?,?,?,?,?)");

        ps.setString(1, booking.getTitle());
        ps.setString(2, booking.getDetails());
        ps.setFloat(3, (float) booking.getPrice());
        ps.setDate(4, new Date(booking.getDate().getTime()));
        ps.setInt(5, AppVariables.currentUser.getId());

        ps.executeUpdate();
    }

    @Override
    public void remove(Booking booking) {

    }

    @Override
    public void alter(Booking oldValue, Booking newValue) {

    }

    @Override
    public Booking getItem(String[] args) {
        return null;
    }

    @Override
    public ArrayList<Booking> getList(String[] args) throws SQLException {
        PreparedStatement ps = AppVariables.CONNECTION.getConnection().prepareStatement(
                "SELECT * FROM tbl_booking WHERE client_id=" + args[0]);
        ResultSet rs = ps.executeQuery();

        var returnValue = new ArrayList<Booking>();

        while (rs.next()) {
            returnValue.add(new Booking(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("details"),
                    AppVariables.CLIENT_SERVICE.getItem(args),
                    rs.getFloat("price"),
                    new java.util.Date(rs.getDate("date").getTime())
            ));
        }

        return returnValue;
    }
}
