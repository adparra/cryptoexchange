package org.example.controller;

import org.example.model.*;
import org.example.service.OrderService;

import java.math.BigDecimal;

public class OrderController {
    private ConsoleView view;
    private OrderService orderService;
    private User user;
    private OrderBook orderBook;

    public OrderController(ConsoleView view, OrderService orderService,
                           User user, OrderBook orderBook){
        this.view = view;
        this.orderService = orderService;
        this.user = user;
        this.orderBook = OrderBook.getInstance();
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
}
