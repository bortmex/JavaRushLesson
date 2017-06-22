package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int countSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            String text = "";
           while (true){
               try {
                   Thread.sleep(1000);
                   System.out.print(countSeconds-- + " ");
               } catch (InterruptedException e) {
                   if(countSeconds<=0) text = "Марш!"; else text = "Прервано!";
                       while (countSeconds>0){
                           System.out.print(countSeconds-- + " ");
                       }
                   System.out.print(text);
                       break;
               }
           }
        }
    }
}
