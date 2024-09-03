package org.example.view;

import org.example.model.CryptoSymbol;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class ConsoleView {

    private final Scanner scanner;
    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public BigDecimal readBigDecimal(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return new BigDecimal(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public CryptoSymbol readCryptoSymbol(String prompt) {
        while (true) {
            String input = readString(prompt + " (BTC/ETH/SOL/ADA): ").toUpperCase();
            try {
                return CryptoSymbol.valueOf(input);
            } catch (IllegalArgumentException e) {
                displayMessage("Invalid symbol. Please try again.");
            }
        }
    }

    public void displayCryptoSymbols() {
        displayMessage("Available crypto symbols:");
        for (CryptoSymbol symbol : CryptoSymbol.values()) {
            displayMessage("- " + symbol.name());
        }
    }

    public void displayCurrentPrices(Map<CryptoSymbol, BigDecimal> prices) {
        System.out.println("Current Cryptocurrency Prices:");
        for (Map.Entry<CryptoSymbol, BigDecimal> entry : prices.entrySet()) {
            System.out.printf("%s: $%.2f%n", entry.getKey(), entry.getValue());
        }
        System.out.println();
    }

    public void displayMenu(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public void close() {
        scanner.close();
    }
}
