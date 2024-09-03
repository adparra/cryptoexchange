package org.example.controller;

import org.example.model.User;

public class TransactionController {
    private User user;

    public TransactionController(User user){
        this.user = user;
    }

    public displayTransactions(){
        user.getTransactions().toString();
    }
}
