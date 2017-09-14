package com.javarush.task.task30.task3004;

import java.util.concurrent.RecursiveTask;

/**
 * Created by alexa on 07.09.2017.
 */
public class BinaryRepresentationTask extends RecursiveTask<String> {
    private int x;

    public BinaryRepresentationTask(int x) {
        this.x = x;
    }

    @Override
    protected String compute() {
            /*мое решение*/
        /*if(x<1){
            return "";
        }
            BinaryRepresentationTask task = new BinaryRepresentationTask(x/2);
            task.fork();
        return task.join() + x%2;*/
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            BinaryRepresentationTask task = new BinaryRepresentationTask(b);
            task.fork();
            return task.join() + result;
        }
        return result;
    }
}
