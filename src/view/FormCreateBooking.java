package view;

import controller.BookingRegisterTableModel;
import etc.MaskFormatters;
import service.Persistence;
import etc.exception.invalid_input_exception.InvalidInputException;
import model.Client;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.Date;

import static view.Tools.showErrorDialog;

public class FormCreateBooking {
    private JPanel rootPanel;
    private JButton btnAdd;
    private JButton btnAlter;
    private JButton btnRemove;
    private JButton btnCancel;
    private JTextField edtSearch;
    private JButton btnSearch;
    private JTextField edtTitle;
    private JTextArea edtDetails;
    private JFormattedTextField ftfPrice;
    private JTable jtList;

    public FormCreateBooking() {
        btnCancel.addActionListener(e -> {
            clearFields();
        });

        btnAdd.addActionListener(e -> {
            insert();
        });
    }

    private void insert() {
        try {
            Persistence.BOOKING_SERVICE.insert(new String[]{
                    edtTitle.getText(),
                    edtDetails.getText(),
                    ftfPrice.getValue().toString()});
            clearFields();
            updateTable();
        } catch (InvalidInputException e) {
            showErrorDialog(e.getMessage());
        } catch (SQLException e) {
            showErrorDialog("Sql error!");
        }
    }



    private void updateTable() {
        try {
            Persistence.BOOKING_SERVICE.updateData(new String[]{String.valueOf(Persistence.user.getId())});
            ((AbstractTableModel) jtList.getModel()).fireTableDataChanged();
        } catch (SQLException throwables) {
            showErrorDialog("Sql error!");
        }
    }

    private void clearFields() {
        edtTitle.setText("");
        edtDetails.setText("");
        ftfPrice.setValue(0.00);
    }

    private void createUIComponents() {
        jtList = new JTable(new BookingRegisterTableModel());
        ftfPrice = new JFormattedTextField(MaskFormatters.moneyFormat());
        ftfPrice.setColumns(10);
        ftfPrice.setValue(0.00);
        updateTable();
    }

    public static void main(String[] args) {
        Persistence.user = new Client("Cliente", true, new Date(), 00000000000, 00000000, null, null);

        JFrame frame = new JFrame();
        frame.setContentPane(new FormCreateBooking().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
