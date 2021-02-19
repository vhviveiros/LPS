package etc.exception.invalid_input_exception;

public class InvalidCityException extends InvalidInputException{
    public InvalidCityException(String message) {
        super(message);
    }

    public static class LongNameException extends InvalidCityException {
        public LongNameException() {
            super("O nome da cidade informada é muito longo!");
        }
    }

    public static class ShortNameException extends InvalidCityException {
        public ShortNameException() {
            super("O nome da cidade informada é muito curto!");
        }
    }

    public static class InvalidCharactersException extends InvalidCityException {
        public InvalidCharactersException() {
            super("O nome da cidade informada possui caracteres inválidos! Utilize apenas letras de 'a' a 'z' e números. Além disso, o " +
                    "primeiro caractere de cada palavra deve ser maiúsculo!");
        }
    }
}
