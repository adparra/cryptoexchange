package org.example.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Wallet {
    protected String id;
    protected String userId;
    protected BigDecimal fiatBalance;
    protected Map<String,BigDecimal> cryptoBalance;

    public Wallet(String id,String userId) {
        this.id = id;
        this.userId = userId;
        this.fiatBalance = BigDecimal.ZERO;
        this.cryptoBalance = new HashMap<>();
    }

    public Map<String, BigDecimal> getCryptoBalance() {
        return cryptoBalance;
    }

    public BigDecimal getFiatBalance() {return fiatBalance;}

    public String getId() {return id;}

    public void deposit(BigDecimal amount) {
        this.fiatBalance = fiatBalance.add(amount);
    }

}
