package service;

import dao.InsumoDAO;
import etc.exception.invalid_input_exception.InvalidInputException;
import model.Insumo;
import model.Model;

import java.util.ArrayList;

public class InsumoService implements Service {
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
    public Model getItem(String[] args) {
        return insumoDAO.getItem(args);
    }

    @Override
    public ArrayList getList(String[] args) {
        return null;
    }
}
