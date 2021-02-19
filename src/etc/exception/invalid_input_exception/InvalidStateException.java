package etc.exception.invalid_input_exception;

public class InvalidStateException extends InvalidInputException{
    public InvalidStateException() {
        super("O estado informado é inválido!");
    }
}
