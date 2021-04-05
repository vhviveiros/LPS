package etc.exception.invalid_input_exception;

public class ExistingUserException extends InvalidNameInputException {
    public ExistingUserException() {
        super("O usuário já foi cadastrado!");
    }
}
