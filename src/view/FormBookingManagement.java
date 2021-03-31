package view;

import controller.tableModels.BookingRegisterTableModel;
import etc.Formatters;
import etc.exception.invalid_input_exception.InvalidDateException;
import controller.ControllerSingleton;
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
    private int currentSelection = -1;

    public FormBookingManagement() {
        btnCancel.addActionListener(e -> clearFields());

        btnAdd.addActionListener(e -> insert());

        btnAlter.addActionListener(e -> alter());

        btnRemove.addActionListener(e -> remove());
    }

    private void alter() {
        var result = JOptionPane.showConfirmDialog(null, "Deseja alterar os dados do item selecionado?");

        if (result == JOptionPane.YES_OPTION) {
            try {
                ControllerSingleton.BOOKING_SERVICE.alter(new String[]{
                        String.valueOf(currentSelection),
                        edtTitle.getText(),
                        edtDetails.getText(),
                        String.valueOf(ftfPrice.getValue()),
                        ftfDate.getText()
                });

                clearFields();
                updateTable();
            } catch (Exception e) {
                showErrorDialog(e.getMessage());
            }
        }
    }

    private void remove() {
        var result = JOptionPane.showConfirmDialog(null, "Deseja remover permanentemente o item selecionado?");

        if (result == JOptionPane.YES_OPTION) {
            try {
                ControllerSingleton.BOOKING_SERVICE.remove(new String[]{String.valueOf(currentSelection)});
                clearFields();
                updateTable();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private void insert() {
        try {
            ControllerSingleton.BOOKING_SERVICE.insert(new String[]{
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
            ControllerSingleton.BOOKING_SERVICE.updateData(new String[]{String.valueOf(ControllerSingleton.currentUser.getId())});
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
        jtList.getSelectionModel().addListSelectionListener(evt -> {
            currentSelection = jtList.getSelectedRow();

            if (currentSelection == -1)
                return;

            var selectedItem = ControllerSingleton.BOOKING_SERVICE.getData().get(currentSelection);

            edtTitle.setText(selectedItem.getTitle());
            edtDetails.setText(selectedItem.getDetails());
            ftfPrice.setValue(selectedItem.getPrice());
            ftfDate.setText(Formatters.dateToLocalString(selectedItem.getDate()));
        });

        ftfPrice = new JFormattedTextField(Formatters.moneyFormat());
        ftfPrice.setColumns(10);
        ftfPrice.setValue(0.00);

        try {
            ftfDate = new JFormattedTextField(Formatters.dateFormat());
        } catch (InvalidDateException e) {
            e.printStackTrace();
            showErrorDialog(e.getMessage());
        }
    }

    public static void main(String[] args) {
        ControllerSingleton.currentUser = new Client(19, "teste", true, new Date(), 00000000000, 00000000, null, null);

        JFrame frame = new JFrame();
        frame.setContentPane(new FormBookingManagement().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
