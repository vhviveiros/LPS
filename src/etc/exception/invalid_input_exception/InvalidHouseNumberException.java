package etc.exception.invalid_input_exception;

public class InvalidHouseNumberException extends InvalidInputException{
    public InvalidHouseNumberException() {
        super("O número de casa informado é inválido!");
    }
}
