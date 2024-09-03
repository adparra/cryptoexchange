package org.example;

import org.example.controller.AccountLoginController;
import org.example.controller.AccountRegisterController;
import org.example.controller.RootController;
import org.example.model.OrderBook;
import org.example.model.UserRepository;
import org.example.service.OrderService;
import org.example.view.ConsoleView;

import java.util.HashMap;

public class CryptoApp {

    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        OrderBook orderBook = OrderBook.getInstance();
        OrderService orderService = new OrderService(orderBook);

        RootController rootController= new RootController(view, orderBook,orderService);
        rootController.execute();

    }
}