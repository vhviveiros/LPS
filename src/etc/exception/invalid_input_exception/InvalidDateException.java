package etc.exception.invalid_input_exception;

public class InvalidDateException extends InvalidInputException{
    public InvalidDateException() {
        super("A data informada possui formato inválido!");
    }
}
