package controller;

import model.Booking;
import service.Persistence;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;

public class BookingRegisterTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Nome", "Usuário", "Preço", "Data Reserva"};

    @Override
    public int getRowCount() {
        return Persistence.BOOKING_SERVICE.getData().size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Booking booking = Persistence.BOOKING_SERVICE.getData().get(rowIndex);
        String price = "R$ " + String.format("%.2f", booking.getPrice());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = simpleDateFormat.format(booking.getDate());

        var result = new Object[]{booking.getTitle(), booking.getClient(),
                price, date};
        return result[columnIndex];
    }
}
