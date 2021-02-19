package view;

import etc.MaskFormatters;
import etc.exception.invalid_input_exception.InvalidCpfInputException;
import etc.exception.invalid_input_exception.InvalidDateException;
import etc.exception.invalid_input_exception.InvalidInputException;
import etc.exception.invalid_input_exception.InvalididentityException;
import model.Endereco;
import repository.Persistence;

import javax.swing.*;

public class FormCadastroUsuario {
    private JButton btnAdicionar;
    private JButton btnCancelar;
    private JTextField edtNome;
    private JFormattedTextField ftfNascimento;
    private JFormattedTextField ftfCpf;
    private JFormattedTextField ftfIdentidade;
    private JComboBox cbEstado;
    private JTextField edtCidade;
    private JTextField edtNumero;
    private JPanel rootPanel;
    private JTextField edtLogradouro;
    private JTextField edtBairro;
    private JComboBox cbUsuario;
    private JComboBox cbSexo;

    public FormCadastroUsuario() {
        btnCancelar.addActionListener(e -> {
            clearFields();
        });

        btnAdicionar.addActionListener(e -> {
            insert();
        });
    }

    private void clearFields() {
        edtNome.setText("");
        edtNumero.setText("");
        edtCidade.setText("");
        edtBairro.setText("");
        edtLogradouro.setText("");

        ftfCpf.setValue("");
        ftfIdentidade.setValue("");
        ftfNascimento.setValue("");
    }

    private void insert() {
        try {
            String[] fields = new String[]{
                    edtNome.getText(),
                    ftfNascimento.getText(),
                    ftfCpf.getText().replace(".", "").replace("-", ""),
                    ftfIdentidade.getText().replace(".", ""),
                    (String) cbSexo.getSelectedItem(),
            };

            if (cbUsuario.getSelectedItem().equals("Cliente"))
                Persistence.CLIENTE_SERVICE.insert(fields);
            else
                Persistence.FAXINEIRO_SERVICE.insert(fields);

            Persistence.ENDERECO_SERVICE.insert(new String[]{
                    edtLogradouro.getText(),
                    edtNumero.getText(),
                    edtCidade.getText(),
                    (String) cbEstado.getSelectedItem(),
                    edtBairro.getText()
            });

            clearFields();
            SwingUtilities.getWindowAncestor(rootPanel).dispose();
        } catch (InvalidInputException e) {
            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createUIComponents() {
        cbEstado = new JComboBox<>(Endereco.ESTADOS);
        cbUsuario = new JComboBox<>(new String[]{"Faxineiro(a)", "Cliente"});
        cbSexo = new JComboBox<>(new String[]{"Masculino", "Feminino"});

        try {
            ftfNascimento = new JFormattedTextField(MaskFormatters.dateFormat());
            ftfCpf = new JFormattedTextField(MaskFormatters.cpfFormat());
            ftfIdentidade = new JFormattedTextField(MaskFormatters.identidadeFormat());

        } catch (InvalidDateException | InvalidCpfInputException | InvalididentityException e) {
            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new FormCadastroUsuario().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
