package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by alexa on 31.08.2017.
 */
public class MyThread extends Thread {
    public static AtomicInteger counter = new AtomicInteger(1);

    public MyThread() {
        priorPlus();
    }

    public MyThread(Runnable target) {
        super(target);
        priorPlus();

    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        priorPlus();
    }

    public MyThread(String name) {
        super(name);
        priorPlus();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        priorPlus();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        priorPlus();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        priorPlus();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        priorPlus();
    }

    private void priorPlus() {

        if (counter.get() < 10) {
            setPriority(counter.getAndIncrement());
        } else {
            setPriority(counter.get());
            counter.set(1);
        }
    }
}