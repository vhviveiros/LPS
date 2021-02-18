package dao;

import etc.Persistence;
import model.ReservaServico;

import java.util.ArrayList;

public class ReservaServicoDao implements Dao<ReservaServico> {
    @Override
    public void insert(ReservaServico reserva) {
        Persistence.<ReservaServico>getTipoDeServicoRepository().addItem(reserva);
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
        return Persistence.<ReservaServico>getTipoDeServicoRepository().retrieveData();
    }
}
