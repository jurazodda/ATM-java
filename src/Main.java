import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account[] accounts = new Account[1];
        ATM atm = new ATM(accounts);

        accounts[0] = new Account(1, "1234");

        System.out.print("Enter your ID: ");
        int id = sc.nextInt();

        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Enter your PIN: ");
            String pin = sc.next();

            atm.login(id, pin);

            if (atm.getCurrentAccount() != null) {
                break;
            } else {
                attempts++;
                if (attempts < 3) {
                    System.out.println("Invalid PIN. Try again.");
                }
            }

            if (attempts == 3) {
                System.out.println("Too many failed attempts. Exiting...");
                return;
            }
        }
    }
}
