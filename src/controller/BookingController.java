package controller;

import dao.BookingDao;
import etc.exception.invalid_input_exception.*;
import model.Booking;
import model.Client;
import validation.BookingValidation;

import java.sql.Date;
import java.sql.SQLException;

public class BookingController extends Controller<Booking> {
    private final BookingDao bookingDao = new BookingDao();

    @Override
    public void insert(String[] args) throws InvalidInputException, SQLException {
        BookingValidation validation = new BookingValidation(args);

        bookingDao.insert(new Booking(
                validation.titleValidation(),
                validation.detailsValidation(),
                validation.clientValidation(),
                validation.priceValidation(),
                validation.dateValidation()
        ));
    }

    @Override
    /**
     * args[0] = old value position at list
     * args[1] = new title
     * args[2] = new description
     * args[3] = new price
     * args[4] = new date
     */
    public void alter(String[] args) throws InvalidInputException, SQLException {
        final BookingValidation validation = new BookingValidation(new String[]{args[1], args[2], args[3], args[4]});
        final Booking oldBooking = data.get(Integer.parseInt(args[0]));
        final Booking newBooking = new Booking(oldBooking.getId(),
                validation.titleValidation(),
                validation.detailsValidation(),
                validation.clientValidation(),
                validation.priceValidation(),
                validation.dateValidation());
        bookingDao.alter(oldBooking, newBooking);
    }

    @Override
    /**
     * args[0] = item position at list
     */
    public void remove(String[] args) throws SQLException {
        bookingDao.remove(data.get(Integer.parseInt(args[0])));
    }

    @Override
    public Booking getItem(String[] args) {
        return bookingDao.getItem(args);
    }

    @Override
    public void updateData(String[] args) throws SQLException {
        data = bookingDao.getList(args);
    }
}
