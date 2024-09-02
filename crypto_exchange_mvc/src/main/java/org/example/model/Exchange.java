package org.example.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Exchange {
    protected Map<CryptoSymbol, BigDecimal> cryptoBalance;
    private static volatile Exchange instance;

    private Exchange(){
        this.cryptoBalance = new HashMap<>();
    }

    public static Exchange getInstance(){
        if(instance == null){
            instance = new Exchange();
        }
        return instance;
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
