package service.usuario;

import dao.UsuarioDao;
import etc.exception.invalid_input_exception.InvalidInputException;
import model.Cliente;
import model.Faxineiro;
import service.Service;

import java.util.ArrayList;

public class FaxineiroService implements Service<Faxineiro> {
    private final UsuarioDao usuarioioDao = new UsuarioDao();

    @Override
    public void insert(String[] args) throws InvalidInputException {
        UsuarioValidation validation = new UsuarioValidation(args);

        boolean sexo = args[4].equals("Masculino");

        usuarioioDao.insert(new Faxineiro(
                validation.nomeValidation(),
                sexo,
                validation.nascimentoValidation(),
                validation.cpfValidation(),
                validation.identidadeValidation(),null));
    }

    @Override
    public void alter(String[] args) {

    }

    @Override
    public void remove(String[] args) {

    }

    @Override
    public Faxineiro getItem(String[] args) {
        return null;
    }

    @Override
    public ArrayList<Faxineiro> getList(String[] args) {
        return null;
    }
}
