package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        for (Thread thread:threads) {
            switch (thread.getState()){
                case NEW:
                    thread.start();
                    break;
                case RUNNABLE:
                    thread.isInterrupted();
                    break;
                case WAITING:
                    thread.interrupt();
                    break;
                case TIMED_WAITING:
                    thread.interrupt();
                    break;
                case BLOCKED:
                    thread.interrupt();
                    break;
                case TERMINATED:
                    System.out.println(thread.getPriority());
                    break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
/*
        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();

        myThread2.start();
        myThread2.sleep(3000);
        MyThread[] arrThread = new MyThread[5];
        for (int i = 0; i < arrThread.length; i++) {
            arrThread[i]= myThread;
            arrThread[i]= myThread1;
            arrThread[i]= myThread2;
            arrThread[i]= myThread3;
        }

        processThreads(arrThread);
*/

    }

    public static class MyThread extends Thread{
        private int index = 0;
        @Override
        public void run() {
            System.out.println(this.getName() + " Я работать");
            while (index<10){
                index++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}