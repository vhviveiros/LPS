package controller;

import etc.Persistence;
import model.Insumo;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;

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
        String preco = "R$ " + String.format("%.2f", insumo.getPreco());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String data = simpleDateFormat.format(insumo.getValidade());

        var result = new Object[]{insumo.getNome(), insumo.getQuantidade(), data, preco};
        return result[columnIndex];
    }
}
