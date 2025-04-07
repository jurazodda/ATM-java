import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM {
    private Account[] accounts;
    private Account currentAccount;
    private Scanner sc;

    public ATM(Account[] accounts) {
        this.accounts = accounts;
        this.sc = new Scanner(System.in);
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public void login(int id, String pin) {
        try {
            for (Account account : accounts) {
                if (account.getId() == id) {
                    if (account.verifyPin(pin)) {
                        currentAccount = account;
                        System.out.println("\n✔ Login successful!");
                        showMenu();
                        return;
                    } else {
                        System.out.println("\n✖ Incorrect PIN");
                        return;
                    }
                }
            }
            System.out.println("\n✖ Account not found");
        } catch (Exception e) {
            System.out.println("\n⚠ Error: " + e.getMessage());
        }
    }

    public boolean checkRepeatApplication() {
        while (true) {
            try {
                System.out.println("\n9. Back to main menu");
                System.out.println("0. Exit");
                System.out.print("Select option: ");
                int choice = sc.nextInt();

                if (choice == 9) return true;
                if (choice == 0) {
                    System.out.println("\nThank you for using our ATM!");
                    return false;
                }
                System.out.println("\n✖ Invalid choice");
            } catch (InputMismatchException e) {
                System.out.println("\n✖ Please enter a number (9 or 0)");
                sc.next();
            }
        }
    }

    public void showMenu() {
        while (true) {
            try {
                System.out.println("\n=== MAIN MENU ===");
                System.out.println("1. Check balance");
                System.out.println("2. Make deposit");
                System.out.println("3. Withdraw cash");
                System.out.println("4. Change PIN");
                System.out.println("5. Logout");
                System.out.print("Select option: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.printf("\nCurrent balance: $%.2f\n", currentAccount.getBalance());
                        if (!checkRepeatApplication()) return;
                        break;

                    case 2:
                        System.out.print("\nEnter deposit amount: $");
                        BigDecimal depositAmount = sc.nextBigDecimal();
                        currentAccount.deposit(depositAmount);
                        System.out.println("✔ Deposit successful");
                        if (!checkRepeatApplication()) return;
                        break;

                    case 3:
                        System.out.print("\nEnter withdrawal amount: $");
                        BigDecimal withdrawAmount = sc.nextBigDecimal();
                        currentAccount.withdraw(withdrawAmount);
                        System.out.println("✔ Withdrawal successful");
                        if (!checkRepeatApplication()) return;
                        break;

                    case 4:
                        System.out.print("\nEnter current PIN: ");
                        String oldPin = sc.next();
                        System.out.print("Enter new PIN: ");
                        String newPin = sc.next();
                        currentAccount.changePin(oldPin, newPin);
                        System.out.println("✔ PIN changed successfully");
                        if (!checkRepeatApplication()) return;
                        break;

                    case 5:
                        System.out.println("\nLogging out...");
                        currentAccount = null;
                        System.exit(0);
                    default:
                        System.out.println("\n✖ Invalid option");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n✖ Invalid input. Please enter a number");
                sc.next();
            } catch (Exception e) {
                System.out.println("\n⚠ Error: " + e.getMessage());
            }
        }
    }
}
