package controller;

import dao.BookingDao;
import etc.exception.invalid_input_exception.InvalidInputException;
import model.Booking;
import validation.BookingValidation;

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
    public void alter(String[] args) {

    }

    @Override
    public void remove(String[] args) {

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
