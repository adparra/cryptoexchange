package org.example.service;

import org.example.model.*;

import java.time.LocalDateTime;

public class OrderService {
    private OrderBook orderBook;

    public OrderService(OrderBook orderBook){
        this.orderBook = OrderBook.getInstance();
    }

    public void matchOrders(){
        while(orderBook.hasBuyOrders() && orderBook.hasSellOrders()){
            BuyOrder buyOrder = orderBook.peekBuyOrder();
            SellOrder sellOrder = orderBook.peekSellOrder();

            if(buyOrder.getCryptoSymbol().equals(sellOrder.getCryptoSymbol()) &&
                    (buyOrder.getAmount().compareTo(sellOrder.getAmount()) == 0) &&
                    (buyOrder.getPrice().compareTo(sellOrder.getPrice()) >= 0)){
                executeTransaction(buyOrder,sellOrder);
                buyOrder.getUser().getWallet().debit(sellOrder.getPrice());
                buyOrder.getUser().getWallet().addCrypto(buyOrder.getCryptoSymbol(),buyOrder.getAmount());
                sellOrder.getUser().getWallet().deposit(sellOrder.getPrice());
                sellOrder.getUser().getWallet().debitCrypto(buyOrder.getCryptoSymbol(),
                        buyOrder.getAmount());
                orderBook.pollBuyOrder();
                orderBook.pollSellOrder();
            }else{
                break;
            }
        }
    }

    public void executeTransaction(BuyOrder buyOrder,SellOrder sellOrder){
        Transaction transaction = new Transaction(
                buyOrder.getUser(),
                sellOrder.getUser(),
                buyOrder.getCryptoSymbol(),
                buyOrder.getAmount(),
                sellOrder.getPrice(),
                LocalDateTime.now());
    }


}
