package exceptions;

public class InvalidPinException extends ATMExceptions {
    public InvalidPinException(String message) {
        super(message);
    }
}
