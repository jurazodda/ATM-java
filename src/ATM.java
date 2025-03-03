import java.math.BigDecimal;
import java.util.Scanner;

public class ATM {
    private Account[] accounts;
    private Account currentAccount;
    private Scanner sc;

    public ATM(Account[] accounts) {
        this.accounts = accounts;
        this.sc = new Scanner(System.in);
    }

    public void login(int id, String pin) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                if (account.verifyPin(pin)) {
                    currentAccount = account;
                    System.out.println("Successfully logged in!");
                    return;
                } else {
                    System.out.println("Invalid PIN. Try again.");
                    return;
                }
            }
        }
        System.out.println("Account not found.");
    }

    public void showMenu() {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Change PIN");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");

            int userChoice = sc.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.println("Your balance: " + currentAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    BigDecimal depositAmount = sc.nextBigDecimal();
                    currentAccount.deposit(depositAmount);
                    System.out.println("Deposit successful.");
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    BigDecimal withdrawAmount = sc.nextBigDecimal();
                    currentAccount.withdraw(withdrawAmount);
                    System.out.println("Withdraw successful.");
                    break;
                case 4:
                    System.out.print("Enter current PIN: ");
                    String oldPin = sc.next();
                    System.out.print("Enter new Pin: ");
                    String newPin = sc.next();
                    currentAccount.changePin(oldPin, newPin);
                    System.out.println("PIN changed successfully.");
                    break;
                case 5:
                    System.out.println("Logging out...");
                    currentAccount = null;
                    return;
                default:
                    System.out.println("Invalid operation. Try again.");
            }
        }
    }

}
