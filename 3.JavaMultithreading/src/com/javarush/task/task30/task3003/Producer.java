package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

/**
 * Created by alexa on 06.09.2017.
 */
public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            int i = 1;
            while (!Thread.currentThread().isInterrupted() && i < 10) {
                ShareItem shareItem = new ShareItem("ShareItem-" + i, i);
                System.out.format("Элемент 'ShareItem-%d' добавленn", i);
                queue.offer(shareItem);
                Thread.sleep(100);
                if (queue.hasWaitingConsumer()) {
                    System.out.format("Consumer в ожидании!\n");
                }
                i++;
            }
        } catch (InterruptedException e) {}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Producer producer = (Producer) o;

        return queue != null ? queue.equals(producer.queue) : producer.queue == null;
    }

    @Override
    public int hashCode() {
        return queue != null ? queue.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "queue=" + queue +
                '}';
    }
}
