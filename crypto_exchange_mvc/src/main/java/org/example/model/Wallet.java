package org.example.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Wallet {
    private static final AtomicInteger _ID = new AtomicInteger(0);
    protected final int id;
    protected BigDecimal fiatBalance;
    protected Map<CryptoSymbol,BigDecimal> cryptoBalance;

    public Wallet() {
        this.id = _ID.incrementAndGet();
        this.fiatBalance = BigDecimal.ZERO;
        this.cryptoBalance = new HashMap<>();
    }

    public void initializeWallet(){
        for (CryptoSymbol cryp : CryptoSymbol.values()){
            cryptoBalance.put(cryp,new BigDecimal("0.0"));
        }
    }

    public Map<CryptoSymbol, BigDecimal> getCryptoBalance() {
        return cryptoBalance;
    }

    public BigDecimal getFiatBalance() {return fiatBalance;}

    public String getId() {return String.valueOf(id);}

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
