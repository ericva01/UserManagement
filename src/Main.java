// Main.java
import controller.UserController;
import model.UserService;
import view.UserView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        UserView userView = new UserView();
        UserController userController = new UserController(userService, userView);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            userView.displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    userController.createUser();
                    break;
                case 2:
                    userController.searchUserByUuid();
                    break;
                case 3:
                    userController.updateUserByUuid();
                    break;
                case 4:
                    userController.deleteUserByUuid();
                    break;
                case 5:
                    userController.displayAllUsers();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}