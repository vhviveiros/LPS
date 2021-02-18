package etc.exception.invalid_input_exception;

public class InvalidPriceException extends InvalidInputException {
    public InvalidPriceException() {
        super("O preço informado é inválido!");
    }
}
