package org.example.model;

import java.math.BigDecimal;

public class Cryptocurrency {
    protected String name;
    protected CryptoSymbol symbol;
    protected BigDecimal currentPrice;

    public Cryptocurrency(String name, CryptoSymbol symbol, BigDecimal currentPrice) {
        this.name = name;
        this.symbol = symbol;
        this.currentPrice = currentPrice;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void updatePrice(BigDecimal newPrice){
        this.currentPrice = newPrice;
    }
}
