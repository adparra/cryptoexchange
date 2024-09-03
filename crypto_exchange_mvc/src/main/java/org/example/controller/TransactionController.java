package org.example.controller;

import org.example.model.User;

public class TransactionController {
    private ConsoleView view;
    private User user;

    public TransactionController(ConsoleView view,User user){
        this.view = view;
        this.user = user;
    }

    public String displayTransactions(){
        return user.getTransactions().toString();
    }
}
