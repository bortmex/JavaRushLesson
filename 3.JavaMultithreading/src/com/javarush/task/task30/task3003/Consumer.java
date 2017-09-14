package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

/**
 * Created by alexa on 06.09.2017.
 */
public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(450);
            while (!Thread.currentThread().isInterrupted()) {
                queue.take();
                System.out.format("Processing item.toString()");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Consumer consumer = (Consumer) o;

        return queue != null ? queue.equals(consumer.queue) : consumer.queue == null;
    }

    @Override
    public int hashCode() {
        return queue != null ? queue.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "queue=" + queue +
                '}';
    }
}
