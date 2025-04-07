import exceptions.InvalidAmountException;
import exceptions.InvalidPinException;
import exceptions.NotEnoughMoneyException;

import java.math.BigDecimal;

public class Account {
    private int id;
    private String pin;
    private BigDecimal balance;

    public Account(int id, String pin) {
        this.id = id;
        this.pin = pin;
        this.balance = BigDecimal.ZERO;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public boolean verifyPin(String pin) {
        return this.pin.equals(pin);
    }

    public void deposit(BigDecimal amount) throws InvalidAmountException {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive");
        }
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) throws NotEnoughMoneyException {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (balance.compareTo(amount) < 0) {  // Правильное условие
            throw new NotEnoughMoneyException("Insufficient funds!");
        }
        balance = balance.subtract(amount);
    }

    public void changePin(String oldPin, String newPin) throws InvalidPinException {
        /*
        if (this.pin.equals(oldPin) && !newPin.isEmpty()) {
            this.pin = newPin;
        }
        */

        if (!this.pin.equals(oldPin)) {
            throw new InvalidPinException("Incorrect current PIN!");
        }
        if (newPin.length() != 4) {
            throw new InvalidPinException("PIN must be 4 digits!");
        }
        this.pin = newPin;
    }
}