package com.javarush.task.task27.task2712.kitchen;

/**
 * Created by alexa on 06.09.2017.
 */
public enum  Dish {

    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    private int duration;


    Dish(int i) {
        this.duration = i;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString(){
        String text = Dish.values()[0] + ", ";
        for (int i = 1; i < Dish.values().length-1; i++) {
            text+=Dish.values()[i] +", ";
        }
        text += Dish.values()[Dish.values().length-1];
        return text;
    }
}
