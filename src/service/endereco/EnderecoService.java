package service.endereco;

import dao.EnderecoDao;
import etc.exception.invalid_input_exception.InvalidInputException;
import model.Endereco;
import service.Service;

import java.util.ArrayList;

public class EnderecoService implements Service<Endereco> {
    private final EnderecoDao enderecoDao = new EnderecoDao();

    @Override
    public void insert(String[] args) throws InvalidInputException {
        EnderecoValidation validation = new EnderecoValidation(args);

        enderecoDao.insert(new Endereco(
                validation.logradouroValidation(),
                validation.numeroValidation(),
                validation.cidadeValidation(),
                validation.estadoValidation(),
                validation.bairroValidation()));
    }

    @Override
    public void alter(String[] args) {

    }

    @Override
    public void remove(String[] args) {

    }

    @Override
    public Endereco getItem(String[] args) {
        return null;
    }

    @Override
    public ArrayList<Endereco> getList(String[] args) {
        return null;
    }
}
