package view;

import controller.CadastroServicoTableModel;
import etc.MaskFormatters;
import repository.Persistence;
import etc.exception.invalid_input_exception.InvalidInputException;
import model.Cliente;
import model.ReservaServico;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.Date;

public class FormReservaServico {
    private JPanel rootPanel;
    private JButton btnAdicionar;
    private JButton btnAlterar;
    private JButton btnExcluir;
    private JButton btnCancelar;
    private JTextField edtPesquisar;
    private JButton pesquisarButton;
    private JTextField edtTitulo;
    private JTextArea edtInformacoes;
    private JFormattedTextField ftfPreco;
    private JTable lista;

    public FormReservaServico() {
        btnCancelar.addActionListener(e -> {
            clearFields();
        });

        btnAdicionar.addActionListener(e -> {
            insert();
        });
    }

    private void insert() {
        try {
            Persistence.<ReservaServico>getTipoDeServicoService().insert(new String[]{
                    edtTitulo.getText(),
                    edtInformacoes.getText(),
                    ftfPreco.getValue().toString()});

            clearFields();
            ((AbstractTableModel) lista.getModel()).fireTableDataChanged();
        } catch (InvalidInputException e) {
            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        edtTitulo.setText("");
        edtInformacoes.setText("");
        ftfPreco.setValue(0.00);
    }

    private void createUIComponents() {
        lista = new JTable(new CadastroServicoTableModel<ReservaServico>());
        ftfPreco = new JFormattedTextField(MaskFormatters.moneyFormat());
        ftfPreco.setColumns(10);
        ftfPreco.setValue(0.00);
    }

    public static void main(String[] args) {
        Persistence.usuario = new Cliente("Cliente", false, new Date(), 00000000000, 00000000, null);

        JFrame frame = new JFrame();
        frame.setContentPane(new FormReservaServico().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
