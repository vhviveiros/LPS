package view;

import controller.InsumoTableModel;
import etc.MaskFormatters;
import etc.Persistence;
import etc.exception.invalid_input_exception.InvalidInputException;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class GerenciaInsumo {
    private JButton btnAdicionar;
    private JButton btnAlterar;
    private JButton btnExcluir;
    private JButton btnCancelar;
    private JTextField edtPesquisar;
    private JButton pesquisarButton;
    private JTable lista;
    private JTextField edtNome;
    private JTextField edtQtd;
    private JTextField edtValidade;
    private JTextArea edtDetalhes;
    private JPanel rootPanel;
    private JFormattedTextField ftfPreco;

    public GerenciaInsumo() {
        btnCancelar.addActionListener(e -> {
            clearFields();
        });

        btnAdicionar.addActionListener(e -> {
            insert();
        });
    }

    private void insert() {
        try {
            Persistence.INSUMO_SERVICE.insert(new String[]{
                    edtNome.getText(),
                    edtDetalhes.getText(),
                    edtQtd.getText(),
                    edtValidade.getText(),
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
        edtNome.setText("");
        edtQtd.setText("");
        edtValidade.setText("");
        edtDetalhes.setText("");
        ftfPreco.setText("");
    }

    private void createUIComponents() {
        lista = new JTable(new InsumoTableModel());
        ftfPreco = new JFormattedTextField(MaskFormatters.moneyFormat());
        ftfPreco.setColumns(10);
        ftfPreco.setValue(0.00);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame ();
        frame.setContentPane(new GerenciaInsumo().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
