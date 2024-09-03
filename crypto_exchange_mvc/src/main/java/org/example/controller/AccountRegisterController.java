package org.example.controller;

import org.example.model.User;
import org.example.model.UserRepository;
import org.example.model.Wallet;

public class AccountRegisterController {
    private final ConsoleView view;
    private final UserRepository users;

    public AccountRegisterController(ConsoleView view, UserRepository users) {
        this.view = view;
        this.users = users;
    }
    public void registerUser(String username, String email, String password) {
        if (users.getUserByName(username) == null && users.getUserByEmail(email) == null) {
            Wallet wallet = new Wallet();
            User newUser = new User(username,email, password,wallet);
            newUser.getWallet().initializeWallet();
            users.addUser(newUser);
        } else {
            throw new IllegalArgumentException("Name or email already in use.");
        }
    }
}
