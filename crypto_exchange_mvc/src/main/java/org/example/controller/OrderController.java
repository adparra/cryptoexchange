package org.example.controller;

import org.example.model.*;
import org.example.service.OrderService;
import org.example.view.ConsoleView;
import java.math.BigDecimal;

public class OrderController {
    private ConsoleView view;
    private OrderService orderService;
    private User user;
    private OrderBook orderBook;
    private Exchange exchange;

    public OrderController(ConsoleView view, OrderService orderService,
                           User user, OrderBook orderBook){
        this.view = view;
        this.orderService = orderService;
        this.user = user;
        this.orderBook = OrderBook.getInstance();
        this.exchange = Exchange.getInstance();
    }

    public void addBuyOrder(User user, CryptoSymbol cryptoSymbol,
                            BigDecimal amount, BigDecimal price){
        BuyOrder order = new BuyOrder(user, cryptoSymbol,amount,price);
        orderBook.addBuyOrder(order);
        orderService.matchOrders();
    }

    public void addSellOrder(User user, CryptoSymbol cryptoSymbol,
                            BigDecimal amount, BigDecimal price){
        SellOrder order = new SellOrder(user, cryptoSymbol,amount,price);
        orderBook.addSellOrder(order);
        orderService.matchOrders();
    }

    public void execute() {
        String[] options = {"View current prices","Place Buy Order", "Place Sell Order", "View available crypto", "Back"};
        view.displayMenu(options);
        String choice = view.readString("Enter your choice: ");
        switch (choice) {
            case "1":
                view.displayCurrentPrices(exchange.getAllCurrentPrices());
                break;
            case "2":
                CryptoSymbol symbol = view.readCryptoSymbol("Enter crypto symbol: ");
                BigDecimal amount = view.readBigDecimal("Enter amount to buy: ");
                BigDecimal price = view.readBigDecimal("Enter desired price: ");
                addBuyOrder(user,symbol,amount,price);
                break;
            case "3":
                CryptoSymbol sellsymbol = view.readCryptoSymbol("Enter crypto symbol: ");
                BigDecimal sellamount = view.readBigDecimal("Enter amount to sell: ");
                BigDecimal sellprice = view.readBigDecimal("Enter desired price: ");
                addSellOrder(user,sellsymbol,sellamount,sellprice);
                break;
            case "4":
                view.displayCryptoSymbols();
                break;
            case "5":
                return;
            default:
                view.displayMessage("Invalid choice. Please try again.");
        }
    }
}
