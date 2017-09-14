package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexa on 15.08.2017.
 */
public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return bufferedReader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();
        String dish = "";
        while (true) got:{
            int i = 0;
            dish=readString();
            if(dish.contains("exit")) break;
            for (Dish disher:Dish.values()) {
                i++;
                if(disher.toString().contains(dish)){
                    dishes.add(disher);
                    break got;
                }

            }
            if(i == Dish.values().length)
            writeMessage("такого блюда нет ");
        }
        return dishes;
    }

}
