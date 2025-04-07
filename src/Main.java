import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account[] accounts = {new Account(1, "1234")};
        ATM atm = new ATM(accounts);

        try {
            System.out.println("=== WELCOME TO ATM ===");
            System.out.print("Enter your ID: ");
            int id = sc.nextInt();

            int attempts = 0;
            while (attempts < 3) {
                System.out.print("Enter your PIN: ");
                String pin = sc.next();

                atm.login(id, pin);

                if (atm.getCurrentAccount() != null) break;

                attempts++;
                if (attempts < 3) {
                    System.out.printf("\n✖ Wrong PIN. Attempts left: %d\n", 3 - attempts);
                } else {
                    System.out.println("\n✖ Too many failed attempts. ATM blocked");
                }
            }
        } catch (Exception e) {
            System.out.println("\n⚠ System error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
