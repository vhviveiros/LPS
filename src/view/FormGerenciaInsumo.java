package view;

import controller.InsumoTableModel;
import etc.MaskFormatters;
import repository.Persistence;
import etc.exception.invalid_input_exception.InvalidDateException;
import etc.exception.invalid_input_exception.InvalidInputException;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class FormGerenciaInsumo {
    private JButton btnAdicionar;
    private JButton btnAlterar;
    private JButton btnExcluir;
    private JButton btnCancelar;
    private JTextField edtPesquisar;
    private JButton pesquisarButton;
    private JTable lista;
    private JTextField edtNome;
    private JTextField edtQtd;
    private JTextArea edtDetalhes;
    private JPanel rootPanel;
    private JFormattedTextField ftfPreco;
    private JFormattedTextField ftfValidade;

    public FormGerenciaInsumo() {
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
                    ftfValidade.getText(),
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
        ftfValidade.setValue("");
        edtDetalhes.setText("");
        ftfPreco.setValue(0.00);
    }

    private void createUIComponents() {
        lista = new JTable(new InsumoTableModel());
        ftfPreco = new JFormattedTextField(MaskFormatters.moneyFormat());
        ftfPreco.setColumns(10);
        ftfPreco.setValue(0.00);

        try {
            ftfValidade = new JFormattedTextField(MaskFormatters.dateFormat());
        } catch (InvalidDateException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new FormGerenciaInsumo().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
