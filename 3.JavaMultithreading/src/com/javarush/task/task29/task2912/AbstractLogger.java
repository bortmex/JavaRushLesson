package com.javarush.task.task29.task2912;

/**
 * Created by alexa on 05.09.2017.
 */
public abstract class AbstractLogger  implements Logger {
    int level;
    Logger next;

    @Override
    public void inform(String message, int level) {
        if (this.level <= level) {
            info(message);
        }
        if (next != null) {
            next.inform(message, level);
        }
    }

    @Override
    public void setNext(Logger next) {
        this.next = next;
    }

    @Override
    public abstract void info(String message);
}
