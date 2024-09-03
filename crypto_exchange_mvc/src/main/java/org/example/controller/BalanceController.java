package org.example.controller;

import org.example.model.CryptoSymbol;
import org.example.model.User;
import org.example.view.ConsoleView;
import java.math.BigDecimal;
import java.util.Map;

public class BalanceController {
    private final ConsoleView view;
    private User user;

    public BalanceController(ConsoleView view, User user){
        this.view=view;
        this.user=user;
    }

    public BigDecimal showFiatBalance(){
        return user.getWallet().getFiatBalance();
    }

    public Map<CryptoSymbol, BigDecimal> showCryptoBalance(){
        return user.getWallet().getCryptoBalance();
    }

    public void execute(){
        String[] options = {"Check fiat balance","Check crypto wallet","Back"};
        view.displayMenu(options);
        String choice = view.readString("Enter your choice: ");
        switch (choice) {
            case "1":
                view.displayMessage("Showing current fiat balance");
                showFiatBalance();
                break;
            case "2":
                view.displayMessage("Showing current crypto holdings");
                showCryptoBalance();
                break;
            case "3":
                return;
            default:
                view.displayMessage("Invalid choice. Please try again.");
        }
    }


}
