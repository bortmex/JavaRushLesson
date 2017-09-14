package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by alexa on 13.09.2017.
 */
public class TestOrder extends Order{
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() {
        List<Dish> availableDishes = Arrays.asList(Dish.values());
        Collections.shuffle(availableDishes);
        int numOfSelectedDishes = ThreadLocalRandom.current().nextInt(availableDishes.size()) + 1;
        dishes = new ArrayList<>();
        for (int i = 0; i < numOfSelectedDishes; i++)
            dishes.add(availableDishes.get(i));
    }
}
