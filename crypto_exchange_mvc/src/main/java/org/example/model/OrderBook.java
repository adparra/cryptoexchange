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
    }
    public void addSellOrder(SellOrder order){
        sellOrders.offer(order);
    }
    public BuyOrder peekBuyOrder(){
        return buyOrders.peek();
    }
    public SellOrder peekSellOrder(){
        return sellOrders.peek();
    }
    public BuyOrder pollBuyOrder(){
        return buyOrders.poll();
    }
    public SellOrder pollSellOrder(){
        return sellOrders.poll();
    }
    public boolean hasBuyOrders(){
        return !buyOrders.isEmpty();
    }
    public boolean hasSellOrders(){
        return !sellOrders.isEmpty();
    }

//    private void matchOrders(){
//        while(!buyOrders.isEmpty() && !sellOrders.isEmpty()){
//            BuyOrder buyOrder = buyOrders.peek();
//            SellOrder sellOrder = sellOrders.peek();
//
//            if(buyOrder.getCryptoSymbol().equals(sellOrder.getCryptoSymbol()) &&
//                    (buyOrder.getAmount().compareTo(sellOrder.getAmount()) == 0) &&
//                    (buyOrder.getPrice().compareTo(sellOrder.getPrice()) >= 0)){
//                executeTransaction(buyOrder,sellOrder);
//                buyOrders.poll();
//                sellOrders.poll();
//            }else{
//                break;
//            }
//        }
//    }



}
