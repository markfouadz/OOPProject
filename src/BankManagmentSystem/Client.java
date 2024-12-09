package BankManagmentSystem;
import java.util.Scanner;

public class Client {
    public int id;
    public String firstName;
    public String lastName;
    public String accountNumber;
    public double balance;

    public Client(int id, String firstName, String lastName, String accountNumber, double balance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + firstName + " " + lastName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }

    public static Client createClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter client ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter client first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter client last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter client account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter client balance: ");
        double balance = scanner.nextDouble();
        return new Client(id, firstName, lastName, accountNumber, balance);
    }
}
