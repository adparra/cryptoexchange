package org.example.model;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;
import java.util.List;

public class User {
    private static final AtomicInteger _ID = new AtomicInteger(0);
    protected final int id;
    protected String name;
    protected String email;
    protected String password;
    protected Wallet wallet;
    protected List<Transaction> transactions;

    public User(String name,String email,String password, Wallet wallet){
        this.id = _ID.incrementAndGet();
        this.name = name;
        this.email = email;
        this.password = password;
        this.wallet = wallet;
        this.transactions = new ArrayList<>();
    }

    public String getId() {
        return String.valueOf(id);
    }
    public String getName(){
        return name;
    }

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions(){
        return new ArrayList<>(transactions);
    }
}
