package org.example.controller;

import org.example.model.User;
import org.example.model.UserRepository;

import java.util.Optional;

public class AccountLoginController {
    private final ConsoleView view;
    private final UserRepository users;
    private User currentUser;

    public AccountLoginController(ConsoleView view, UserRepository users) {
        this.view = view;
        this.users = users;
    }

    public boolean login(String username, String password) {
        User user = users.getUserByName(username);
        if (user != null && user.authenticate(password)) {
            currentUser = user;
            return true;
        }
        return false;
    }

    public User getCurrentUser(){
        return Optional.ofNullable(currentUser).
                orElseThrow(MissingAccountException::new);
    }
}
