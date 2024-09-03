package org.example.controller;

import org.example.model.User;

import java.math.BigDecimal;

public class DepositController {
    private final ConsoleView view;
    private User user;

    public DepositController(ConsoleView view, User user){
        this.view=view;
        this.user=user;
    }

    public void depositFiat(BigDecimal amount){
        user.getWallet().deposit(amount);
    }
}
