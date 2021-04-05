package etc.exception.invalid_input_exception;

public class ExistingAddressException extends InvalidInputException {
    public ExistingAddressException() {
        super("O endereço informado já foi cadastrado!");
    }
}
