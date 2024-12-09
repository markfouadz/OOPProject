import BankManagmentSystem.Admin;
import BankManagmentSystem.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();

        // Adding employees
        System.out.println("Enter details for employee 1:");
        Employee emp1 = Employee.createEmployee();
        admin.addEmployee(emp1);

        System.out.println("Enter details for employee 2:");
        Employee emp2 = Employee.createEmployee();
        admin.addEmployee(emp2);

        // Adding clients
        System.out.println("Enter details for client 1:");
        Client client1 = Client.createClient();
        admin.addClient(client1);

        System.out.println("Enter details for client 2:");
        Client client2 = Client.createClient();
        admin.addClient(client2);

        // Adding a transaction
        System.out.println("Enter details for a transaction:");
        Transaction transaction1 = Transaction.createTransaction(admin.clients, admin.employees);
        admin.addTransaction(transaction1);

        // Main menu loop
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Display all employees");
            System.out.println("2. Display all clients");
            System.out.println("3. Display transactions by date");
            System.out.println("4. Display transactions by client");
            System.out.println("5. Display transactions by employee");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    admin.displayAllEmployees();
                    break;
                case 2:
                    admin.displayAllClients();
                    break;
                case 3:
                    System.out.print("Enter date to filter transactions (e.g., Wed Feb 15 00:00:00 UTC 2024): ");
                    String date = scanner.nextLine();
                    admin.displayTransactionsByDate(date);
                    break;
                case 4:
                    System.out.print("Enter client first name to filter transactions: ");
                    String clientName = scanner.nextLine();
                    Client client = admin.clients.stream()
                            .filter(c -> c.getFirstName().equals(clientName))
                            .findFirst()
                            .orElse(null);
                    if (client != null) {
                        admin.displayTransactionsByClient(client);
                    } else {
                        System.out.println("Client not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter employee first name to filter transactions: ");
                    String employeeName = scanner.nextLine();
                    Employee employee = admin.employees.stream()
                            .filter(e -> e.getFirstName().equals(employeeName))
                            .findFirst()
                            .orElse(null);
                    if (employee != null) {
                        admin.displayTransactionsByEmployee(employee);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 9:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
