package controller.tableModels;

import controller.ControllerSingleton;
import model.Supply;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;

public class SupplyTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Nome", "Quantidade", "Validade", "Preço"};

    @Override
    public int getRowCount() {
        return ControllerSingleton.SUPPLY_CONTROLLER.getData().size();
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
        Supply supply = ControllerSingleton.SUPPLY_CONTROLLER.getData().get(rowIndex);
        String price = "R$ " + String.format("%.2f", supply.getPrice());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String data = supply.getExpirationDate() == null ? "--" : simpleDateFormat.format(supply.getExpirationDate());

        var result = new Object[]{supply.getName(), supply.getAmount(), data, price};
        return result[columnIndex];
    }
}
