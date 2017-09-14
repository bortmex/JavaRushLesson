package com.javarush.task.task27.task2712.kitchen;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by alexa on 14.09.2017.
 */
public class Waitor implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Cook cook = (Cook) o;
        Order order = (Order) arg;

    }
}