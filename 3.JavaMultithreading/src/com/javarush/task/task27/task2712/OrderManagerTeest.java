package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Order;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by alexa on 13.09.2017.
 */
public class OrderManagerTeest implements Observer{

    private final static LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();
/*
    public OrderManagerTeest() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Set<Cook> cookSet = StatisticManager.getInstance().getCooks();
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                    if (!orderQueue.isEmpty()) {
                        for (Cook cook : cookSet) {
                            if (!cook.isBusy()) {
                                Order order = orderQueue.poll();
                                if (order != null)
                                    try {
                                        cook.startCookingOrder(order);
                                    } catch (InterruptedException e) {
                                    }
                            }
                            if (orderQueue.isEmpty())
                                break;
                        }
                    }


                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
*/

    @Override
    public void update(Observable o, Object arg) {
        orderQueue.add((Order) arg);
    }
}
