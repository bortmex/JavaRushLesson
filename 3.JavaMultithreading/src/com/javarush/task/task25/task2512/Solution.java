package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.List;

/*
Живем своим умом
*/
public class Solution extends Thread implements Thread.UncaughtExceptionHandler {
   /* protected final Thread.UncaughtExceptionHandler handler;*/

    public Solution() {
       /* this.handler = new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                List<Throwable> throwables = new ArrayList<>();
                Throwable eTrace = e;
                throwables.add(0, eTrace);
                while (eTrace.getCause() != null) {
                    eTrace = eTrace.getCause();
                    throwables.add(0, eTrace); }

                for (Throwable throwable : throwables) {
                    System.out.println(throwable);
                }
            }
        };*/
    }
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        List<Throwable> throwables = new ArrayList<>();
        Throwable eTrace = e;
        throwables.add(0, eTrace);
        while (eTrace.getCause() != null) {
            eTrace = eTrace.getCause();
            throwables.add(0, eTrace); }

        for (Throwable throwable : throwables) {
            System.out.println(throwable);
        }
    }


    @Override
    public void run() {
        try {
            throw new Exception();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
           /* handler.uncaughtException(currentThread, new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));*/
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Thread d = new Thread(s);
        d.start();
    }
}