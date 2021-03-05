package service.booking;

import dao.BookingDao;
import etc.exception.invalid_input_exception.InvalidInputException;
import model.Booking;
import service.Service;

import java.util.ArrayList;

public class BookingService implements Service<Booking> {
    private final BookingDao bookingDao = new BookingDao();

    @Override
    public void insert(String[] args) throws InvalidInputException {
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
    public ArrayList<Booking> getList(String[] args) {
        return bookingDao.getList(args);
    }
}
