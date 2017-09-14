package com.javarush.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/*
Пишем свою ThreadFactory
*/
public class Solution {

    public static class AmigoThreadFactory implements ThreadFactory {

        public AmigoThreadFactory() {
            intGroup.set(intFactoryGroup.incrementAndGet());
        }

        private AtomicInteger intGroup = new AtomicInteger(0);
        private static AtomicInteger intFactoryGroup = new AtomicInteger(0);
        private AtomicInteger intNumber = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread tr = new Thread(r);
            tr.setDaemon(false);
            tr.setPriority(Thread.NORM_PRIORITY);
            tr.setName(tr.getThreadGroup().getName() + "-pool-"+intGroup+"-thread-"+intNumber.getAndIncrement());
            return tr;
        }
    }

    public static void main(String[] args) {
        class EmulateThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulateThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulateThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }
}
