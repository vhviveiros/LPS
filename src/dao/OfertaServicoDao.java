package dao;

import repository.Persistence;
import model.OfertaServico;

import java.util.ArrayList;

public class OfertaServicoDao implements Dao<OfertaServico> {
    @Override
    public void insert(OfertaServico ofertaServico) {
        Persistence.<OfertaServico>getTipoDeServicoRepository().addItem(ofertaServico);
    }

    @Override
    public void remove(OfertaServico ofertaServico) {

    }

    @Override
    public void alter(OfertaServico oldValue, OfertaServico newValue) {

    }

    @Override
    public OfertaServico getItem(String[] args) {
        return null;
    }

    @Override
    public ArrayList<OfertaServico> getList(String[] args) {
        return Persistence.<OfertaServico>getTipoDeServicoRepository().retrieveData();
    }
}
