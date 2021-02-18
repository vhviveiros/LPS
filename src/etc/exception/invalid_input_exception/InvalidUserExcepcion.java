package etc.exception.invalid_input_exception;

public class InvalidUserExcepcion extends InvalidInputException{
    public InvalidUserExcepcion() {
        super("Erro ao efetuar a transação, usuário não autorizado. Isso pode ser devido a falha no login.");
    }
}
