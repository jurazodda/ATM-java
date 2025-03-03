import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Account[] accounts = new Account[1];
        System.out.print("Enter your ID: ");
        int id = sc.nextInt();
        System.out.print("Enter your PIN: ");
        String pin = sc.next();
        accounts[0] = new Account(id, pin);

        ATM atm = new ATM(accounts);
        atm.login(id, pin);

        atm.showMenu();
    }

}
