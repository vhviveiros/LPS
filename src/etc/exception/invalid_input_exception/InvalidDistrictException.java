package etc.exception.invalid_input_exception;

public class InvalidDistrictException extends InvalidInputException{
    public InvalidDistrictException(String message) {
        super(message);
    }

    public static class LongNameException extends InvalidDistrictException {
        public LongNameException() {
            super("O nome do bairro informado é muito longo!");
        }
    }

    public static class ShortNameException extends InvalidDistrictException {
        public ShortNameException() {
            super("O nome do bairro informado é muito curto!");
        }
    }

    public static class InvalidCharactersException extends InvalidDistrictException {
        public InvalidCharactersException() {
            super("O nome do bairro informado possui caracteres inválidos! Utilize apenas letras de 'a' a 'z' e números. Além disso, o " +
                    "primeiro caractere de cada palavra deve ser maiúsculo!");
        }
    }
}