package org.example.model;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<String, User> users;

    public UserRepository(Map<String, User> users) {
        this.users = new HashMap<>();
    }

    public void addUser(User user){
        users.put(user.getId(), user);
    }
    public User getUserById(String id){
        return users.get(id);
    }
    public User getUserByName(String name) {
        return users.values().stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public User getUserByEmail(String email){
        return users.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }
}
