package view;

import controller.tableModels.SupplyTableModel;
import etc.Formatters;
import model.Cleaner;
import controller.ControllerSingleton;
import etc.exception.invalid_input_exception.InvalidDateException;
import etc.exception.invalid_input_exception.InvalidInputException;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.Date;

import static view.Tools.showErrorDialog;

public class FormSupplyManagement {
    private JButton btnAdd;
    private JButton btnAlter;
    private JButton btnRemove;
    private JButton btnCancel;
    private JTextField edtSearch;
    private JButton btnSearch;
    private JTable jtList;
    private JTextField edtName;
    private JTextField edtAmount;
    private JTextArea edtDetails;
    private JPanel rootPanel;
    private JFormattedTextField ftfPrice;
    private JFormattedTextField ftfExpirationDate;

    public FormSupplyManagement() {
        btnCancel.addActionListener(e -> {
            clearFields();
        });

        btnAdd.addActionListener(e -> {
            insert();
        });
    }

    private void insert() {
        try {
            ControllerSingleton.SUPPLY_SERVICE.insert(new String[]{
                    edtName.getText(),
                    edtDetails.getText(),
                    edtAmount.getText(),
                    ftfExpirationDate.getText(),
                    ftfPrice.getValue().toString()});

            clearFields();

            ControllerSingleton.SUPPLY_SERVICE.updateData(new String[]{String.valueOf(ControllerSingleton.currentUser.getId())});

            ((AbstractTableModel) jtList.getModel()).fireTableDataChanged();
        } catch (InvalidInputException | SQLException e) {
            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        edtName.setText("");
        edtAmount.setText("");
        ftfExpirationDate.setValue("");
        edtDetails.setText("");
        ftfPrice.setValue(0.00);
    }

    private void createUIComponents() {
        try {
            ControllerSingleton.SUPPLY_SERVICE.updateData(new String[]{String.valueOf(ControllerSingleton.currentUser.getId())});

            jtList = new JTable(new SupplyTableModel());
            ftfPrice = new JFormattedTextField(Formatters.moneyFormat());
            ftfPrice.setColumns(10);
            ftfPrice.setValue(0.00);

            ftfExpirationDate = new JFormattedTextField(Formatters.dateFormat());
        } catch (InvalidDateException | SQLException e) {
            e.printStackTrace();
            showErrorDialog(e.getMessage());
        }
    }

    public static void main(String[] args) {
        ControllerSingleton.currentUser = new Cleaner(19, "teste", true, new Date(), 00000000000, 00000000, null, null);

        JFrame frame = new JFrame();
        frame.setContentPane(new FormSupplyManagement().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
