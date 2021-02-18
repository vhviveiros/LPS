package dao;

import etc.Persistence;
import model.ReservaServico;

import java.util.ArrayList;

public class ReservaServicoDao implements Dao<ReservaServico> {
    @Override
    public void insert(ReservaServico reserva) {
        Persistence.RESERVAS_SERVICOS.addItem(reserva);
    }

    @Override
    public void remove(ReservaServico reserva) {

    }

    @Override
    public void alter(ReservaServico oldValue, ReservaServico newValue) {

    }

    @Override
    public ReservaServico getItem(String[] args) {
        return null;
    }

    @Override
    public ArrayList<ReservaServico> getList(String[] args) {
        return Persistence.RESERVAS_SERVICOS.retrieveData();
    }
}
