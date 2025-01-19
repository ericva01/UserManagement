package controller;

import model.User;
import model.UserService;
import view.UserView;

import java.util.List;
import java.util.UUID;

public class UserController {
    private UserService userService;
    private UserView userView;

    public UserController(UserService userService, UserView userView) {
        this.userService = userService;
        this.userView = userView;
    }

    public void createUser() {
        String[] inputs = userView.getCreateUserInput();
        userService.createUser(inputs[0], inputs[1]);
        userView.showMessage("User created successfully!");
        sendTelegramNotification("New user created: " + inputs[0] + " (" + inputs[1] + ")");
    }

    public void searchUserByUuid() {
        UUID uuid = userView.getUuidInput();
        User user = userService.getUserByUuid(uuid);
        userView.displayUser(user);
    }

    public void updateUserByUuid() {
        UUID uuid = userView.getUuidInput();
        String[] inputs = userView.getUpdateUserInput();
        userService.updateUser(uuid, inputs[0], inputs[1], Boolean.parseBoolean(inputs[2]));
        userView.showMessage("User updated successfully!");
    }

    public void deleteUserByUuid() {
        UUID uuid = userView.getUuidInput();
        userService.deleteUser(uuid);
        userView.showMessage("User deleted successfully!");
    }

    public void displayAllUsers() {
        List<User> activeUsers = userService.getAllActiveUsers();
        userView.displayAllUsers(activeUsers);
    }

    private void sendTelegramNotification(String message) {
        // Mock implementation for sending a notification to Telegram
        System.out.println("[Telegram Notification] " + message);
    }
}
