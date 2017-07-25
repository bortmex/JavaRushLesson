package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexa on 18.07.2017.
 */
public class Hippodrome {
    public Hippodrome() {
    }

    public static Hippodrome game;

    private List<Horse> horses;

    public static void main(String[] args) throws InterruptedException {
        Horse horse1 = new Horse("Стрелка", 3, 0);
        Horse horse2 = new Horse("Ракета", 3, 0);
        Horse horse3 = new Horse("Черная молния", 3, 0);
        List<Horse> listH = new ArrayList<>();
        listH.add(horse1);
        listH.add(horse2);
        listH.add(horse3);
        game = new Hippodrome(listH);
        game.run();
        game.printWinner();
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int j = 0; j < 100; j++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse:horses){
            horse.move();
        }
    }

    public void print() {
        for (Horse horse:horses){
            horse.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner(){
        Horse horseMax = new Horse();
        horseMax.setDistance(0);
        for (Horse horse:horses){
            if(horse.getDistance()>horseMax.getDistance()) horseMax=horse;
        }
        return horseMax;
    }

    public void printWinner(){
        System.out.println("Winner is "+this.getWinner().getName()+"!");
    }

}
