package org.example.controller;

import org.example.model.User;
import org.example.model.UserRepository;
import org.example.model.Wallet;
import org.example.view.ConsoleView;

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
    public void execute(){
        String name = view.readString("Enter your name: ");
        String email = view.readString("Enter your email: ");
        String password = view.readString("Enter your password: ");
        try{
            registerUser(name,email,password);
            view.displayMessage("Registration succesful! Please proceed login with" +
                    "your new credentials");
        }catch(IllegalArgumentException e){
            view.displayMessage("Registration failed");
        }

    }
}
