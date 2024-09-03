package org.example.model;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class Exchange {
    protected Map<CryptoSymbol, BigDecimal> cryptoBalance;
    private Map<CryptoSymbol, Cryptocurrency> cryptocurrencies;
    private static volatile Exchange instance;

    private Exchange(){
        cryptocurrencies = new EnumMap<>(CryptoSymbol.class);
        this.cryptoBalance = new HashMap<>();
        initializeExchange();
        initializeCryptocurrencies();
    }

    private void initializeCryptocurrencies() {
        cryptocurrencies.put(CryptoSymbol.BTC, new Cryptocurrency("Bitcoin", CryptoSymbol.BTC, new BigDecimal("30000.00")));
        cryptocurrencies.put(CryptoSymbol.ETH, new Cryptocurrency("Ethereum", CryptoSymbol.ETH, new BigDecimal("2000.00")));
        cryptocurrencies.put(CryptoSymbol.SOL, new Cryptocurrency("Solana", CryptoSymbol.SOL, new BigDecimal("100.00")));
        cryptocurrencies.put(CryptoSymbol.ADA, new Cryptocurrency("Cardano", CryptoSymbol.ADA, new BigDecimal("0.50")));
    }

    public BigDecimal getCurrentPrice(CryptoSymbol symbol) {
        Cryptocurrency crypto = cryptocurrencies.get(symbol);
        if (crypto == null) {
            throw new IllegalArgumentException("Invalid cryptocurrency symbol: " + symbol);
        }
        return crypto.getCurrentPrice();
    }

    public void updatePrice(CryptoSymbol symbol, BigDecimal newPrice) {
        Cryptocurrency crypto = cryptocurrencies.get(symbol);
        if (crypto == null) {
            throw new IllegalArgumentException("Invalid cryptocurrency symbol: " + symbol);
        }
        crypto.updatePrice(newPrice);
    }

    public Map<CryptoSymbol, BigDecimal> getAllCurrentPrices() {
        Map<CryptoSymbol, BigDecimal> prices = new EnumMap<>(CryptoSymbol.class);
        for (Map.Entry<CryptoSymbol, Cryptocurrency> entry : cryptocurrencies.entrySet()) {
            prices.put(entry.getKey(), entry.getValue().getCurrentPrice());
        }return prices;
    }


    public static Exchange getInstance(){
        if(instance == null){
            instance = new Exchange();
        }
        return instance;
    }
    public void initializeExchange(){
        for (CryptoSymbol cryp : CryptoSymbol.values()){
            cryptoBalance.put(cryp,new BigDecimal("300.0"));
        }
    }

    public void sellCrypto(CryptoSymbol cryp, BigDecimal amount){
        if (cryptoBalance.get(cryp).compareTo(amount) >= 0){
            BigDecimal currentValue= cryptoBalance.get(cryp);
            cryptoBalance.put(cryp,currentValue.subtract(amount));
        }else{
            throw new InsufficientFundsException();
        }
    }
}
