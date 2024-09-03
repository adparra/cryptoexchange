package org.example.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Transaction {
    private static final AtomicInteger _ID = new AtomicInteger(0);
    protected final int id;
    protected User buyer;
    protected User seller;
    protected CryptoSymbol cryptoSymbol;
    protected BigDecimal amount;
    protected BigDecimal price;
    protected LocalDateTime transactionTime;


    public Transaction(User buyer,User seller, CryptoSymbol cryptoSymbol,
                       BigDecimal amount, BigDecimal price, LocalDateTime transactionTime) {
        this.id = _ID.incrementAndGet();
        this.buyer = buyer;
        this.seller = seller;
        this.cryptoSymbol = cryptoSymbol;
        this.amount = amount;
        this.price = price;
        this.transactionTime = transactionTime;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ",buyer= "+ buyer.getName() + '\'' +
                ",seller= "+ seller.getName() + '\'' +
                ", Cryptocurrency=" + cryptoSymbol + '\'' +
                ", amount=" + amount + '\'' +
                ", price=" + price + '\'' +
                ", transactionTime= " + transactionTime +
                '}';
    }
}
