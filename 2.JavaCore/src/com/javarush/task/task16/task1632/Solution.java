package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Infinitely());
        threads.add(new Exception());
        threads.add(new Grac());
        threads.add(new Interrupt());
        threads.add(new Sum());
    }

    public static void main(String[] args) {
    }

    public static class Infinitely extends Thread{
        @Override
        public void run() {
            while (true){

            }
        }
    }

    public static class Exception extends Thread{
        @Override
        public void run() {
            try {
               Thread.sleep(1000000000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Grac extends Thread{
        @Override
        public void run() {
            try {
                while (true){
                System.out.println("Ура");
                sleep(500);}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Interrupt extends Thread implements Message {
        @Override
        public void run() {
            while (!isInterrupted()) {
            }
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }

    public static class Sum extends Thread{
        int sum = 0;
        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String txt= reader.readLine();
                sum = Integer.parseInt(txt);
                while (true){
                    String text = reader.readLine();
                    if(text.equals("N")) break;
                    sum+=Integer.parseInt(text);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(sum);
        }

    }
}