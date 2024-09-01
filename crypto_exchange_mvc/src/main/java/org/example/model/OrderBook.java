package org.example.model;

import java.util.Comparator;
import java.util.PriorityQueue;

public class OrderBook {
    private PriorityQueue<BuyOrder> buyOrders;
    private PriorityQueue<SellOrder> sellOrders;

    private static volatile OrderBook instance;

    private OrderBook(){
        Comparator<Order> orderComparator =
                Comparator.comparing(Order::getCreationTime);
        buyOrders = new PriorityQueue<>(orderComparator);
        sellOrders = new PriorityQueue<>(orderComparator);
    }

    public static OrderBook getInstance(){
        if(instance == null){
            instance = new OrderBook();
        }
        return instance;
    }

    public void addBuyOrder(BuyOrder order){
        buyOrders.offer(order);
        matchOrders();
    }
    public void addSellOrder(SellOrder order){
        sellOrders.offer(order);
        matchOrders();
    }

    private void matchOrders(){
        while(!buyOrders.isEmpty() && !sellOrders.isEmpty()){
            BuyOrder buyOrder = buyOrders.peek();
            SellOrder sellOrder = sellOrders.peek();

            if(buyOrder.getCryptoSymbol().equals(sellOrder.getCryptoSymbol()) &&
                    (buyOrder.getAmount().compareTo(sellOrder.getAmount()) == 0) &&
                    (buyOrder.getPrice().compareTo(sellOrder.getPrice()) >= 0)){
                executeTransaction(buyOrder,sellOrder);
                buyOrders.poll();
                sellOrders.poll();
            }else{
                break;
            }
        }
    }



}
