package view;

import controller.tableModels.SupplyTableModel;
import etc.DataMock;
import etc.Formatters;
import controller.ControllerSingleton;
import etc.exception.invalid_input_exception.InvalidInputException;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;

import static view.Tools.showConfirmDialog;
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
    private int currentSelection;

    public FormSupplyManagement() {
        btnCancel.addActionListener(e -> clearFields());

        btnAdd.addActionListener(e -> insert());

        btnAlter.addActionListener(e -> alter());

        btnRemove.addActionListener(e -> remove());
    }

    private void alter() {
        var result = showConfirmDialog("Deseja alterar os dados do item selecionado?");

        if (result == JOptionPane.YES_OPTION) {
            try {
                ControllerSingleton.SUPPLY_CONTROLLER.alter(new String[]{
                        String.valueOf(currentSelection),
                        edtName.getText(),
                        edtDetails.getText(),
                        edtAmount.getText(),
                        ftfExpirationDate.getText(),
                        ftfPrice.getValue().toString()});

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
                ControllerSingleton.SUPPLY_CONTROLLER.remove(new String[]{String.valueOf(currentSelection)});
                clearFields();
                updateTable();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private void insert() {
        try {
            ControllerSingleton.SUPPLY_CONTROLLER.insert(new String[]{
                    edtName.getText(),
                    edtDetails.getText(),
                    edtAmount.getText(),
                    ftfExpirationDate.getText(),
                    ftfPrice.getValue().toString()});

            clearFields();

            ControllerSingleton.SUPPLY_CONTROLLER.updateData(new String[]{String.valueOf(ControllerSingleton.currentUser.getId())});

            ((AbstractTableModel) jtList.getModel()).fireTableDataChanged();
        } catch (InvalidInputException | SQLException e) {
            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTable() {
        try {
            ControllerSingleton.SUPPLY_CONTROLLER.updateData(new String[]{String.valueOf(ControllerSingleton.currentUser.getId())});
            if (jtList != null)
                ((AbstractTableModel) jtList.getModel()).fireTableDataChanged();
        } catch (SQLException throwables) {
            showErrorDialog("Sql error!");
        }
    }

    private void clearFields() {
        edtName.setText("");
        edtAmount.setText("");
        ftfExpirationDate.setValue("");
        edtDetails.setText("");
        ftfPrice.setValue(0.00);
        jtList.getSelectionModel().clearSelection();
    }

    private void createUIComponents() {
        try {
            jtList = new JTable(new SupplyTableModel());
            jtList.getSelectionModel().addListSelectionListener(evt -> {
                currentSelection = jtList.getSelectedRow();

                if (currentSelection == -1)
                    return;

                var selectedItem = ControllerSingleton.SUPPLY_CONTROLLER.getData().get(currentSelection);

                edtName.setText(selectedItem.getName());
                edtDetails.setText(selectedItem.getDetails());
                ftfPrice.setValue(selectedItem.getPrice());
                ftfExpirationDate.setText(Formatters.dateToLocalString(selectedItem.getExpirationDate()));
                edtAmount.setText(String.valueOf(selectedItem.getAmount()));
            });
            updateTable();

            ftfPrice = new JFormattedTextField(Formatters.moneyFormat());
            ftfPrice.setColumns(10);
            ftfPrice.setValue(0.00);

            ftfExpirationDate = new JFormattedTextField(Formatters.dateFormat());
        } catch (Exception e) {
            e.printStackTrace();
            showErrorDialog(e.getMessage());
        }
    }

    public static void main(String[] args) {
        DataMock.mockCleaner();

        JFrame frame = new JFrame();
        frame.setContentPane(new FormSupplyManagement().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
