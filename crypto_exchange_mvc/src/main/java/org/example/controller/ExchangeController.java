package org.example.controller;

import org.example.model.*;

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

    public void sellCrypto(Cryptocurrency coin,CryptoSymbol cryp, BigDecimal crypamount){
        BigDecimal price = coin.getCurrentPrice();
        BigDecimal fiatamount = price.multiply(crypamount);
        user.getWallet().debit(fiatamount);
        exchange.sellCrypto(cryp,crypamount);
        user.getWallet().addCrypto(cryp,crypamount);
    }


}
