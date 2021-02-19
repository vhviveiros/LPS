package etc.exception.invalid_input_exception;

public abstract class InvalidPlaceException extends InvalidInputException{
    public InvalidPlaceException(String message) {
        super(message);
    }

    public static class LongNameException extends InvalidPlaceException {
        public LongNameException() {
            super("O nome do logradouro informado é muito longo!");
        }
    }

    public static class ShortNameException extends InvalidPlaceException {
        public ShortNameException() {
            super("O nome do logradouro informado é muito curto!");
        }
    }

    public static class InvalidCharactersException extends InvalidPlaceException {
        public InvalidCharactersException() {
            super("O nome do logradouro informado possui caracteres inválidos! Utilize apenas letras de 'a' a 'z' e números. Além disso, o " +
                    "primeiro caractere de cada palavra deve ser maiúsculo!");
        }
    }
}
