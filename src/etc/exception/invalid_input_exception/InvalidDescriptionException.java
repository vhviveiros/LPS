package etc.exception.invalid_input_exception;

public class InvalidDescriptionException extends InvalidInputException{
    public InvalidDescriptionException(String message) {
        super(message);
    }

    public static class LongDescriptionException extends InvalidDescriptionException {
        public LongDescriptionException() {
            super("A descrição não deve conter mais de 500 caracteres!");
        }
    }
}
