package view;

import controller.BookingRegisterTableModel;
import etc.MaskFormatters;
import etc.exception.invalid_input_exception.InvalidDateException;
import controller.AppVariables;
import etc.exception.invalid_input_exception.InvalidInputException;
import model.Client;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.Date;

import static view.Tools.showErrorDialog;

public class FormBookingManagement {
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
    private JFormattedTextField ftfDate;

    public FormBookingManagement() {
        btnCancel.addActionListener(e -> {
            clearFields();
        });

        btnAdd.addActionListener(e -> {
            insert();
        });
    }

    private void insert() {
        try {
            AppVariables.BOOKING_SERVICE.insert(new String[]{
                    edtTitle.getText(),
                    edtDetails.getText(),
                    ftfPrice.getValue().toString(),
                    ftfDate.getText()});
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
            AppVariables.BOOKING_SERVICE.updateData(new String[]{String.valueOf(AppVariables.currentUser.getId())});
            if (jtList != null)
                ((AbstractTableModel) jtList.getModel()).fireTableDataChanged();
        } catch (SQLException throwables) {
            showErrorDialog("Sql error!");
        }
    }

    private void clearFields() {
        edtTitle.setText("");
        edtDetails.setText("");
        ftfPrice.setValue(0.00);
        ftfDate.setValue("");
    }

    private void createUIComponents() {
        updateTable();
        jtList = new JTable(new BookingRegisterTableModel());
        ftfPrice = new JFormattedTextField(MaskFormatters.moneyFormat());
        ftfPrice.setColumns(10);
        ftfPrice.setValue(0.00);

        try {
            ftfDate = new JFormattedTextField(MaskFormatters.dateFormat());
        } catch (InvalidDateException e) {
            e.printStackTrace();
            showErrorDialog(e.getMessage());
        }
    }

    public static void main(String[] args) {
        AppVariables.currentUser = new Client(19, "teste", true, new Date(), 00000000000, 00000000, null, null);

        JFrame frame = new JFrame();
        frame.setContentPane(new FormBookingManagement().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
