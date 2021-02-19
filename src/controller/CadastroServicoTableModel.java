package controller;

import repository.Persistence;
import model.TipoDeServico;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;

public class CadastroServicoTableModel<T extends TipoDeServico<?>> extends AbstractTableModel {
    private final String[] columnNames = {"Nome", "Usuário", "Preço", "Data Reserva"};

    @Override
    public int getRowCount() {
        return Persistence.<T>getTipoDeServicoService().getList(null).size();
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
        T reservaServico = Persistence.<T>getTipoDeServicoService().getList(null).get(rowIndex);
        String valorOferecido = "R$ " + String.format("%.2f", reservaServico.getPreco());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = simpleDateFormat.format(reservaServico.getDataCriacao());

        var result = new Object[]{reservaServico.getTitulo(), reservaServico.getUsuario(),
                valorOferecido, date};
        return result[columnIndex];
    }
}
