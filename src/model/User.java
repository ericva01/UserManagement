package model;

import java.util.UUID;


public class User {
    private static int nextId = 1;

    private int id;
    private UUID uuid;
    private String name;
    private String email;
    private boolean isDeleted;

    public User(String name, String email) {
        this.id = nextId++;
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.isDeleted = false;
    }

    public int getId() {
        return id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return String.format("| %-5d | %-36s | %-20s | %-30s | %-8s |",
                id, uuid, name, email, isDeleted);
    }
}