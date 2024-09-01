package org.example.model;

import java.math.BigDecimal;

public class BuyOrder extends Order{
    public BuyOrder(User user, String cryptoSymbol, BigDecimal amount, BigDecimal price) {
        super(user, cryptoSymbol, amount, price);
    }
}
