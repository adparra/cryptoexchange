package org.example.model;

import java.math.BigDecimal;

public class Transaction {
    protected String id;
    protected String userId;
    protected CryptoSymbol cryptoSymbol;
    protected BigDecimal amount;
    protected BigDecimal price;
    protected TransactionType type;


    public enum TransactionType{
        BUY,SELL;
    }

    public Transaction(String id, String userId, CryptoSymbol cryptoSymbol,
                       BigDecimal amount, BigDecimal price, TransactionType type) {
        this.id = id;
        this.userId = userId;
        this.cryptoSymbol = cryptoSymbol;
        this.amount = amount;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", Cryptocurrency=" + cryptoSymbol +
                ", amount=" + amount +
                ", price=" + price +
                ", type=" + type +
                '}';
    }
}
