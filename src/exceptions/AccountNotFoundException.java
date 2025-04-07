package exceptions;

public class AccountNotFoundException extends ATMExceptions {
    public AccountNotFoundException(String message) {
        super(message);
    }
}
