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

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            balance = balance.add(amount);
        }
    }

    public void withdraw(BigDecimal amount){
        if (amount.compareTo(BigDecimal.ZERO) > 0 && balance.compareTo(amount) >= 0) {
            balance = balance.subtract(amount);
        }
    }

    public void changePin(String oldPin, String newPin) {
        if (this.pin.equals(oldPin) && !newPin.isEmpty()) {
            this.pin = newPin;
        }
    }
}