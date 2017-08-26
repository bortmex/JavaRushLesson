package com.javarush.task.task24.task2410;

/**
 * Created by alexa on 26.07.2017.
 */
public abstract class LocalIterator implements Iterator{
    private int countItems = 0;
    public LocalIterator(String name) {
        System.out.println(name + " item " + countItems++);
    }

    @Override
    public abstract Iterator next();
}
