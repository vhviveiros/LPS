package etc.exception.invalid_input_exception;

public class InvalidCpfInputException extends InvalidInputException{
    public InvalidCpfInputException() {
        super("O cpf informado possui formato inválido.");
    }
}
