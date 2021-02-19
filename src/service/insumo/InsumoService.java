package service.insumo;

import dao.InsumoDAO;
import repository.Persistence;
import etc.exception.invalid_input_exception.InvalidInputException;
import model.Insumo;
import service.Service;

import java.util.ArrayList;

public class InsumoService implements Service<Insumo> {
    private InsumoDAO insumoDAO = new InsumoDAO();

    @Override
    public void insert(String[] args) throws InvalidInputException {
        InsumoValidation validation = new InsumoValidation(args);

        insumoDAO.insert(new Insumo(
                validation.nomeInsumoValidation(),
                validation.detalhesValidation(),
                validation.quantidadeValidation(),
                validation.validadeValidation(),
                validation.precoValidation()));
    }

    @Override
    public void alter(String[] args) {

    }

    @Override
    public void remove(String[] args) {

    }

    @Override
    public Insumo getItem(String[] args) {
        return insumoDAO.getItem(args);
    }

    @Override
    public ArrayList<Insumo> getList(String[] args) {
        return Persistence.INSUMOS.retrieveData();
    }
}
