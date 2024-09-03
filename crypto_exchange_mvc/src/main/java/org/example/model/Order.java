package org.example.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Order {
    private static final AtomicInteger _ID = new AtomicInteger(0);
    protected final int id;
    protected User user;
    protected CryptoSymbol cryptoSymbol;
    protected BigDecimal amount;
    protected BigDecimal price;
    protected LocalDateTime creationTime;

    public Order(User user, CryptoSymbol cryptoSymbol, BigDecimal amount,
                 BigDecimal price) {
        this.id = _ID.incrementAndGet();
        this.user = user;
        this.cryptoSymbol = cryptoSymbol;
        this.amount = amount;
        this.price = price;
        this.creationTime = LocalDateTime.now();
    }

    public User getUser() {
        return user;
    }

    public CryptoSymbol getCryptoSymbol() {return cryptoSymbol;}

    public BigDecimal getAmount() {return amount;}

    public BigDecimal getPrice() {return price;}

    public LocalDateTime getCreationTime() {return creationTime;}
}
