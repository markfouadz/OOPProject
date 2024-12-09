package BankManagmentSystem;

import java.util.Scanner;

public class Employee {
    public int id;
    public String firstName;
    public String lastName;
    public String position;

    public Employee(int id, String firstName, String lastName, String position) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + firstName + " " + lastName + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    public static Employee createEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter employee first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter employee last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter employee position: ");
        String position = scanner.nextLine();
        return new Employee(id, firstName, lastName, position);
    }
}
