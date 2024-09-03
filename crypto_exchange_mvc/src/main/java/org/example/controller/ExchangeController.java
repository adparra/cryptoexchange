package org.example.controller;

import org.example.model.CryptoSymbol;
import org.example.model.Exchange;
import org.example.model.InsufficientFundsException;
import org.example.model.User;

import java.math.BigDecimal;

public class ExchangeController {
    private final ConsoleView view;
    private User user;
    private Exchange exchange;

    ExchangeController(ConsoleView view, User user){
        this.view = view;
        this.user = user;
        this.exchange = Exchange.getInstance();
    }

    public void initExchange(){
        exchange.initializeExchange();
    }

    public void sellCrypto(CryptoSymbol cryp, BigDecimal crypamount,
                           BigDecimal fiatamount){
        user.getWallet().debit(fiatamount);
        exchange.sellCrypto(cryp,crypamount);
        user.getWallet().addCrypto(cryp,crypamount);

    }


}
