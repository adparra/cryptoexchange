package org.example.controller;

import org.example.model.*;
import org.example.view.ConsoleView;
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

    public void sellCrypto(BigDecimal price,CryptoSymbol cryp, BigDecimal crypamount){
        BigDecimal fiatamount = price.multiply(crypamount);
        user.getWallet().debit(fiatamount);
        exchange.sellCrypto(cryp,crypamount);
        user.getWallet().addCrypto(cryp,crypamount);
    }

    public void execute(){
        view.displayCurrentPrices(exchange.getAllCurrentPrices());
        CryptoSymbol symbol = view.readCryptoSymbol("Enter crypto symbol");
        BigDecimal currentPrice = exchange.getCurrentPrice(symbol);
        view.displayMessage("Current price of " + symbol + ": $" + currentPrice);
        BigDecimal amount = view.readBigDecimal("Enter amount to buy: ");
        sellCrypto(currentPrice,symbol, amount);
        view.displayMessage("Crypto bought successfully!");
    }


}
