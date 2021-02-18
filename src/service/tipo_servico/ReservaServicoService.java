package service.tipo_servico;

import dao.ReservaServicoDao;
import etc.exception.invalid_input_exception.InvalidInputException;
import model.ReservaServico;
import service.Service;

import java.util.ArrayList;

public class ReservaServicoService implements Service<ReservaServico> {
    private final ReservaServicoDao reservaServicoDao = new ReservaServicoDao();

    @Override
    public void insert(String[] args) throws InvalidInputException {
        TipoDeServicoValidation validation = new TipoDeServicoValidation(args);

        reservaServicoDao.insert(new ReservaServico(
                validation.tituloValidation(),
                validation.informacoesValidation(),
                validation.clienteValidation(),
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
    public ReservaServico getItem(String[] args) {
        return reservaServicoDao.getItem(args);
    }

    @Override
    public ArrayList<ReservaServico> getList(String[] args) {
        return reservaServicoDao.getList(args);
    }
}
