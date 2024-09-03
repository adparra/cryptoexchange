package org.example.controller;

import org.example.model.CryptoSymbol;
import org.example.model.User;

import java.math.BigDecimal;
import java.util.Map;

public class BalanceController {
    private final ConsoleView view;
    private User user;

    public BalanceController(ConsoleView view, User user){
        this.view=view;
        this.user=user;
    }

    public BigDecimal showFiatBalance(){
        return user.getWallet().getFiatBalance();
    }

    public Map<CryptoSymbol, BigDecimal> showCryptoBalance(){
        return user.getWallet().getCryptoBalance();
    }


}
