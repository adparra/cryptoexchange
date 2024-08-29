package org.example.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public abstract class Order {
    protected String id;
    protected String userId;
    protected String cryptoSymbol;
    protected BigDecimal amount;
    protected BigDecimal price;
    protected LocalDateTime creationTime;

    public Order(String id, String userId, String cryptoSymbol, BigDecimal amount,
                 BigDecimal price) {
        this.userId = userId;
        this.cryptoSymbol = cryptoSymbol;
        this.amount = amount;
        this.price = price;
        this.creationTime = LocalDateTime.now();
    }

    public String getCryptoSymbol() {return cryptoSymbol;}

    public BigDecimal getAmount() {return amount;}

    public BigDecimal getPrice() {return price;}

    public LocalDateTime getCreationTime() {return creationTime;}
}
