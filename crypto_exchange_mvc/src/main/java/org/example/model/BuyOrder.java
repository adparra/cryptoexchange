package org.example.model;

import java.math.BigDecimal;

public class BuyOrder extends Order{
    public BuyOrder(String id, String userId, String cryptoSymbol, BigDecimal amount, BigDecimal price) {
        super(id, userId, cryptoSymbol, amount, price);
    }
}
