package etc.exception.invalid_input_exception;

public class InvalidIdentityException extends InvalidInputException {
    public InvalidIdentityException() {
        super("O RG informado possui formato inválido!");
    }
}
