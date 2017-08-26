package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by alexa on 09.08.2017.
 */
public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < 6; i++) {
                map.put(Integer.toString(i), "Some text for " + i);
            }
        }catch (Exception e){
            System.out.println("thread was terminated");
        }
    }
}
