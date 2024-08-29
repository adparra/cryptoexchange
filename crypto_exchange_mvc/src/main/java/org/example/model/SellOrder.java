package org.example.model;

import java.math.BigDecimal;

public class SellOrder extends Order{
    public SellOrder(String id, String userId, String cryptoSymbol, BigDecimal amount, BigDecimal price) {
        super(id, userId, cryptoSymbol, amount, price);
    }
}
