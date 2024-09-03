package org.example.controller;

import org.example.model.Exchange;
import org.example.model.OrderBook;
import org.example.model.User;
import org.example.model.UserRepository;
import org.example.view.ConsoleView;
import org.example.service.OrderService;

import java.util.HashMap;
import java.util.Map;

public class RootController {
    private ConsoleView view;
    private AccountLoginController loginController;
    private AccountRegisterController registerController;
    private BalanceController balanceController;
    private DepositController depositController;
    private ExchangeController exchangeController;
    private OrderController orderController;
    private TransactionController transactionController;
    private UserRepository users;
    private OrderBook orderBook;
    private OrderService orderService;


    public RootController(ConsoleView view,
                          OrderBook orderBook, OrderService orderService) {
        this.view = view;
        this.loginController = new AccountLoginController(view,users);
        this.registerController = new AccountRegisterController(view,users);
        this.users = new UserRepository(new HashMap<>());
        this.orderBook = OrderBook.getInstance();
        this.orderService= new OrderService(orderBook);
    }

    public void execute() {
        boolean running = true;
        while (running) {
            if (loginController.getCurrentUser() == null) {
                running = executeLoggedOutMenu();
            } else {
                executeLoggedInMenu();
            }
        }
        view.displayMessage("Thank you for using the Crypto Exchange. Goodbye!");
    }

    private boolean executeLoggedOutMenu() {
        String[] options = {"Login", "Register", "Exit"};
        view.displayMenu(options);
        String choice = view.readString("Enter your choice: ");
        switch (choice) {
            case "1":
                loginController.execute();
                if (loginController.getCurrentUser() != null) {
                    initializeLoggedInControllers();
                }
                return true;
            case "2":
                registerController.execute();
                return true;
            case "3":
                return false;
            default:
                view.displayMessage("Invalid choice. Please try again.");
                return true;
        }
    }

    private void executeLoggedInMenu() {
        String[] options = {"Deposit", "Order Management", "Sell Crypto to the exchange", "Review Transactions",
                "View balance","Logout"};
        view.displayMenu(options);
        String choice = view.readString("Enter your choice: ");
        switch (choice) {
            case "1":
                depositController.execute();
                break;
            case "2":
                orderController.execute();
                break;
            case "3":
                exchangeController.execute();
                break;
            case "4":
                transactionController.execute();
                break;
            case "5":
                balanceController.execute();
                break;
            case "6":
                loginController = new AccountLoginController(view, users);
                view.displayMessage("Logged out successfully.");
                break;
            default:
                view.displayMessage("Invalid choice. Please try again.");
        }
    }




    private void initializeLoggedInControllers() {
        User currentUser = loginController.getCurrentUser();
        this.depositController = new DepositController(view, currentUser);
        this.orderController = new OrderController(view, orderService, currentUser, orderBook);
        this.exchangeController = new ExchangeController(view, currentUser);
        this.transactionController = new TransactionController(view, currentUser);
        this.balanceController = new BalanceController(view, currentUser);
    }
}
