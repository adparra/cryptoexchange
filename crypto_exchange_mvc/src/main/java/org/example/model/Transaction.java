package org.example.model;

import java.math.BigDecimal;

public class Transaction {
    protected String id;
    protected String userId;
    protected String cryptoSymbol;
    protected BigDecimal amount;
    protected BigDecimal price;
    protected TransactionType type;


    public enum TransactionType{
        BUY,SELL;
    }
}
