package view;

import controller.SupplyTableModel;
import etc.MaskFormatters;
import service.Persistence;
import etc.exception.invalid_input_exception.InvalidDateException;
import etc.exception.invalid_input_exception.InvalidInputException;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;

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
            Persistence.SUPPLY_SERVICE.insert(new String[]{
                    edtName.getText(),
                    edtDetails.getText(),
                    edtAmount.getText(),
                    ftfExpirationDate.getText(),
                    ftfPrice.getValue().toString()});

            clearFields();
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
        jtList = new JTable(new SupplyTableModel());
        ftfPrice = new JFormattedTextField(MaskFormatters.moneyFormat());
        ftfPrice.setColumns(10);
        ftfPrice.setValue(0.00);

        try {
            ftfExpirationDate = new JFormattedTextField(MaskFormatters.dateFormat());
        } catch (InvalidDateException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new FormSupplyManagement().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
