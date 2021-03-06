package view;

import etc.MaskFormatters;
import etc.exception.invalid_input_exception.InvalidCpfInputException;
import etc.exception.invalid_input_exception.InvalidDateException;
import etc.exception.invalid_input_exception.InvalidInputException;
import etc.exception.invalid_input_exception.InvalididentityException;
import model.Address;
import model.Client;
import model.Credentials;
import service.Persistence;

import javax.swing.*;

import java.sql.SQLException;
import java.util.Date;

import static view.Tools.showErrorDialog;

public class FormCreateUser {
    private JButton btnAdd;
    private JButton btnCancel;
    private JTextField edtName;
    private JFormattedTextField ftfBirthDay;
    private JFormattedTextField ftfCpf;
    private JFormattedTextField ftfIdentity;
    private JComboBox cbState;
    private JTextField edtCity;
    private JTextField edtNumber;
    private JPanel rootPanel;
    private JTextField edtAddress;
    private JTextField edtDistrict;
    private JComboBox cbUser;
    private JComboBox cbGender;

    public FormCreateUser() {
        btnCancel.addActionListener(e -> {
            clearFields();
        });

        btnAdd.addActionListener(e -> {
            insert();
        });
    }

    private void clearFields() {
        edtName.setText("");
        edtNumber.setText("");
        edtCity.setText("");
        edtDistrict.setText("");
        edtAddress.setText("");

        ftfCpf.setValue("");
        ftfIdentity.setValue("");
        ftfBirthDay.setValue("");
    }

    private void insert() {
        try {
            String[] userFields = new String[]{
                    edtName.getText(),
                    ftfBirthDay.getText(),
                    ftfCpf.getText().replace(".", "").replace("-", ""),
                    ftfIdentity.getText().replace(".", ""),
                    (String) cbGender.getSelectedItem(),
            };

            String[] addressFields = new String[]{
                    edtAddress.getText(),
                    edtNumber.getText(),
                    edtCity.getText(),
                    (String) cbState.getSelectedItem(),
                    edtDistrict.getText()
            };

            Persistence.ADDRESS_SERVICE.insert(addressFields);
            Persistence.ADDRESS_SERVICE.updateData(addressFields);

            if (cbUser.getSelectedItem().equals("Cliente"))
                Persistence.CLIENT_SERVICE.insert(userFields);
            else
                Persistence.CLEANER_SERVICE.insert(userFields);

            var address = Persistence.currentUser.getAddress();
            Persistence.CLIENT_SERVICE.updateData(new String[]{userFields[2], userFields[3]});
            Persistence.currentUser.setAddress(address);

            clearFields();
            SwingUtilities.getWindowAncestor(rootPanel).dispose();
        } catch (InvalidInputException e) {
            showErrorDialog(e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            showErrorDialog("Sql error!");
        }
    }

    private void createUIComponents() {
        cbState = new JComboBox<>(Address.STATES);
        cbUser = new JComboBox<>(new String[]{"Faxineiro(a)", "Cliente"});
        cbGender = new JComboBox<>(new String[]{"Masculino", "Feminino"});

        try {
            ftfBirthDay = new JFormattedTextField(MaskFormatters.dateFormat());
            ftfCpf = new JFormattedTextField(MaskFormatters.cpfFormat());
            ftfIdentity = new JFormattedTextField(MaskFormatters.identidadeFormat());

        } catch (InvalidDateException | InvalidCpfInputException | InvalididentityException e) {
            showErrorDialog(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Persistence.currentUser = new Client("Cliente", true, new Date(), 00000000000, 00000000, null,
                new Credentials(1, "teste", "teste"));

        JFrame frame = new JFrame();
        frame.setContentPane(new FormCreateUser().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
