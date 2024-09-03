package org.example.controller;

import org.example.model.User;
import org.example.view.ConsoleView;

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

    public void execute(){
        view.displayMessage("Showing all transactions related to the user");
        displayTransactions();
    }


}
