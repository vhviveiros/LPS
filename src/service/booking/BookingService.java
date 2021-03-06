package service.booking;

import dao.BookingDao;
import etc.exception.invalid_input_exception.InvalidInputException;
import model.Booking;
import service.Service;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookingService extends Service<Booking> {
    private final BookingDao bookingDao = new BookingDao();
    private ArrayList<Booking> clientBookings;

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
        clientBookings = bookingDao.getList(args);
    }
}
