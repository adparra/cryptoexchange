package org.example.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Wallet {
    protected String id;
    protected String userId;
    protected BigDecimal fiatBalance;
    protected Map<CryptoSymbol,BigDecimal> cryptoBalance;

    public Wallet(String id,String userId) {
        this.id = id;
        this.userId = userId;
        this.fiatBalance = BigDecimal.ZERO;
        this.cryptoBalance = new HashMap<>();
    }

    public Map<CryptoSymbol, BigDecimal> getCryptoBalance() {
        return cryptoBalance;
    }

    public BigDecimal getFiatBalance() {return fiatBalance;}

    public String getId() {return id;}

    public void deposit(BigDecimal amount) {
        this.fiatBalance = fiatBalance.add(amount);
    }
    public void debit(BigDecimal amount) {
        if (fiatBalance.compareTo(amount) >= 0) {
            fiatBalance = fiatBalance.subtract(amount);
        } else{
            throw new InsufficientFundsException();
        }
    }
    public void addCrypto(CryptoSymbol cryp, BigDecimal amount){
        BigDecimal currentValue= cryptoBalance.get(cryp);
        cryptoBalance.put(cryp, currentValue.add(amount));
    }
    public void debitCrypto(CryptoSymbol cryp, BigDecimal amount){
        if (cryptoBalance.get(cryp).compareTo(amount) >= 0){
            BigDecimal currentValue= cryptoBalance.get(cryp);
            cryptoBalance.put(cryp,currentValue.subtract(amount));
        }else{
            throw new InsufficientFundsException();
        }
    }

}
