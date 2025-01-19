package model;

// UserService.java (Model)
import java.util.*;
import java.util.stream.Collectors;

public class UserService {
    private List<User> users = new ArrayList<>();

    public void createUser(String name, String email) {
        User user = new User(name, email);
        users.add(user);
    }

    public User getUserByUuid(UUID uuid) {
        return users.stream()
                .filter(u -> u.getUuid().equals(uuid))
                .findFirst()
                .orElse(null);
    }

    public void updateUser(UUID uuid, String name, String email, boolean isDeleted) {
        User user = getUserByUuid(uuid);
        if (user != null) {
            user.setName(name);
            user.setEmail(email);
            user.setDeleted(isDeleted);
        }
    }

    public void deleteUser(UUID uuid) {
        User user = getUserByUuid(uuid);
        if (user != null) {
            user.setDeleted(true);
        }
    }

    public List<User> getAllActiveUsers() {
        return users.stream()
                .filter(user -> !user.isDeleted())
                .collect(Collectors.toList());
    }
}