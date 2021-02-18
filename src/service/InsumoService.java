package service;

import dao.InsumoDAO;
import etc.exception.invalid_input_exception.InvalidNameInputException;
import etc.exception.invalid_input_exception.InvalidQuantityException;
import model.Insumo;
import model.Model;

import java.util.ArrayList;
import java.util.Date;

public class InsumoService implements Service {
    private InsumoDAO insumoDAO = new InsumoDAO();

    @Override
    public void insert(String[] args) throws InvalidNameInputException, InvalidQuantityException {
        InsumoValidation validation = new InsumoValidation(args);

        insumoDAO.insert(new Insumo(
                validation.nomeInsumoValidation(),
                validation.detalhesValidation(),
                validation.quantidadeValidation(),
                new Date(),
                Double.parseDouble(args[4])));
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
