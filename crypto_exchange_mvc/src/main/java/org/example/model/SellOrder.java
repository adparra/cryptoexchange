package org.example.model;

import java.math.BigDecimal;

public class SellOrder extends Order{

    public SellOrder(User user, CryptoSymbol cryptoSymbol, BigDecimal amount, BigDecimal price) {
        super(user, cryptoSymbol, amount, price);
    }
}
