package dao;

import model.Booking;
import controller.ControllerSingleton;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingDao implements Dao<Booking> {
    @Override
    public void insert(Booking booking) throws SQLException {
        executeStmt(conn -> {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO tbl_booking (title,details,price,date,client_id) values (?,?,?,?,?)");

            ps.setString(1, booking.getTitle());
            ps.setString(2, booking.getDetails());
            ps.setFloat(3, (float) booking.getPrice());
            ps.setDate(4, new Date(booking.getDate().getTime()));
            ps.setInt(5, ControllerSingleton.currentUser.getId());

            ps.executeUpdate();
            return null;
        });
    }

    @Override
    public void remove(Booking booking) throws SQLException {
        executeStmt(conn -> {
            PreparedStatement ps = conn.prepareStatement(
                    "DELETE FROM tbl_booking WHERE id = ?");
            ps.setInt(1, booking.getId());

            ps.executeUpdate();
            return null;
        });
    }

    @Override
    public void alter(Booking oldValue, Booking newValue) throws SQLException {
        executeStmt(conn -> {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE tbl_booking set " +
                            "title = ?, " +
                            "details = ?, " +
                            "price = ?, " +
                            "date = ?, " +
                            "client_id = ? " +
                            "WHERE id = ?");

            ps.setString(1, newValue.getTitle());
            ps.setString(2, newValue.getDetails());
            ps.setFloat(3, (float) newValue.getPrice());
            ps.setDate(4, new Date(newValue.getDate().getTime()));
            ps.setInt(5, newValue.getClient().getId());
            ps.setInt(6, newValue.getId());

            ps.executeUpdate();
            return null;
        });
    }

    @Override
    public Booking getItem(String[] args) {
        return null;
    }

    @Override
    public ArrayList<Booking> getList(String[] args) throws SQLException {
        return executeStmt(conn -> {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM tbl_booking WHERE client_id=" + args[0]);
            ResultSet rs = ps.executeQuery();

            var returnValue = new ArrayList<Booking>();

            while (rs.next()) {
                returnValue.add(new Booking(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("details"),
                        ControllerSingleton.CLIENT_CONTROLLER.getItem(args),
                        rs.getFloat("price"),
                        new java.util.Date(rs.getDate("date").getTime())
                ));
            }

            return returnValue;
        });
    }
}
