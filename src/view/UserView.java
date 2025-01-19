package view;


import model.User;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class UserView {
    private Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("\nUser Management System");
        System.out.println("1. Create User");
        System.out.println("2. Search User by UUID");
        System.out.println("3. Update User by UUID");
        System.out.println("4. Delete User by UUID");
        System.out.println("5. Display All Users");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }

    public String[] getCreateUserInput() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        return new String[]{name, email};
    }

    public UUID getUuidInput() {
        System.out.print("Enter UUID: ");
        String uuidStr = scanner.nextLine();
        return UUID.fromString(uuidStr);
    }

    public String[] getUpdateUserInput() {
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        System.out.print("Set isDeleted (true/false): ");
        boolean isDeleted = scanner.nextBoolean();
        scanner.nextLine();
        return new String[]{name, email, String.valueOf(isDeleted)};
    }

    public void displayUser(User user) {
        if (user != null) {
            System.out.println("User found:");
            System.out.println(user);
        } else {
            System.out.println("User not found.");
        }
    }

    public void displayAllUsers(List<User> users) {
        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }

        System.out.println("All Users:");
        System.out.println("+-------+--------------------------------------+----------------------+--------------------------------+----------+");
        System.out.println("| ID    | UUID                                 | Name                 | Email                          | isDeleted|");
        System.out.println("+-------+--------------------------------------+----------------------+--------------------------------+----------+");

        for (User user : users) {
            System.out.println(user);
        }

        System.out.println("+-------+--------------------------------------+----------------------+--------------------------------+----------+");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}