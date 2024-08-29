package org.example.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public abstract class Order {
    protected String id;
    protected String userId;
    protected String cryptoSymbol;
    protected BigDecimal amount;
    protected BigDecimal price;
    protected LocalDateTime dateTime;

    public Order(String id, String userId, String cryptoSymbol, BigDecimal amount,
                 BigDecimal price, LocalDateTime dateTime) {
        this.id = id;
        this.userId = userId;
        this.cryptoSymbol = cryptoSymbol;
        this.amount = amount;
        this.price = price;
        this.dateTime = dateTime;
    }
}
