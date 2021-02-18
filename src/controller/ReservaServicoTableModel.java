package controller;

import etc.Persistence;
import model.Insumo;
import model.ReservaServico;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;

public class ReservaServicoTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Nome", "Cliente", "Preço", "Data Reserva"};

    @Override
    public int getRowCount() {
        return Persistence.RESERVAS_SERVICOS.count();
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
        ReservaServico reservaServico = Persistence.RESERVAS_SERVICOS.getValueAt(rowIndex);
        String valorOferecido = "R$ " + String.format("%.2f", reservaServico.getValorOferecido());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = simpleDateFormat.format(reservaServico.getDataReserva());

        var result = new Object[]{reservaServico.getTitulo(), reservaServico.getCliente(),
                valorOferecido, date};
        return result[columnIndex];
    }
}
