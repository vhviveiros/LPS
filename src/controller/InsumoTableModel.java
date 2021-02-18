package controller;

import etc.Persistence;
import model.Insumo;

import javax.swing.table.AbstractTableModel;

public class InsumoTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Nome", "Quantidade", "Validade", "Preço"};

    @Override
    public int getRowCount() {
        return Persistence.INSUMOS.count();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Insumo insumo = Persistence.INSUMOS.getValueAt(rowIndex);
        var result = new Object[]{insumo.getNome(), insumo.getQuantidade(), insumo.getValidade(),
                "R$ " + String.format("%.2f", insumo.getPreco())};
        return result[columnIndex];
    }
}
