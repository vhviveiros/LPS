package view;

import etc.DataMock;
import etc.Formatters;
import etc.exception.invalid_input_exception.InvalidCpfInputException;
import etc.exception.invalid_input_exception.InvalidDateException;
import etc.exception.invalid_input_exception.InvalidInputException;
import etc.exception.invalid_input_exception.InvalididentityException;
import model.Address;
import model.Client;
import model.Credentials;
import controller.ControllerSingleton;
import model.User;

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
        btnCancel.addActionListener(e -> clearFields());

        btnAdd.addActionListener(e -> insert());
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

            ControllerSingleton.currentUser = new Client("Cliente", true, new Date(), 00000000000, 00000000, null,
                    null);

            ControllerSingleton.ADDRESS_CONTROLLER.insert(addressFields);
            ControllerSingleton.ADDRESS_CONTROLLER.updateData(addressFields);

            ControllerSingleton.currentUser.setCredentials(DataMock.mockCredentials());

            if (cbUser.getSelectedItem().equals("Cliente"))
                ControllerSingleton.CLIENT_CONTROLLER.insert(userFields);
            else
                ControllerSingleton.CLEANER_CONTROLLER.insert(userFields);

            var address = ControllerSingleton.currentUser.getAddress();
            ControllerSingleton.CLIENT_CONTROLLER.updateData(new String[]{userFields[2], userFields[3]});
            ControllerSingleton.currentUser.setAddress(address);

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
            ftfBirthDay = new JFormattedTextField(Formatters.dateFormat());
            ftfCpf = new JFormattedTextField(Formatters.cpfFormat());
            ftfIdentity = new JFormattedTextField(Formatters.identidadeFormat());

        } catch (InvalidDateException | InvalidCpfInputException | InvalididentityException e) {
            showErrorDialog(e.getMessage());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new FormCreateUser().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
