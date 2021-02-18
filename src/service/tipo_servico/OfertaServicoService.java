package service.tipo_servico;

import dao.OfertaServicoDao;
import etc.exception.invalid_input_exception.InvalidInputException;
import model.OfertaServico;
import service.Service;

import java.util.ArrayList;

public class OfertaServicoService implements Service<OfertaServico> {
    private final OfertaServicoDao ofertaServicoDao = new OfertaServicoDao();

    @Override
    public void insert(String[] args) throws InvalidInputException {
        TipoDeServicoValidation validation = new TipoDeServicoValidation(args);

        ofertaServicoDao.insert(new OfertaServico(
                validation.tituloValidation(),
                validation.informacoesValidation(),
                validation.faxineiroValidation(),
                validation.valorOferecidoValidation(),
                validation.dataReservaValidation()
        ));
    }

    @Override
    public void alter(String[] args) {

    }

    @Override
    public void remove(String[] args) {

    }

    @Override
    public OfertaServico getItem(String[] args) {
        return ofertaServicoDao.getItem(args);
    }

    @Override
    public ArrayList<OfertaServico> getList(String[] args) {
        return ofertaServicoDao.getList(args);
    }
}
