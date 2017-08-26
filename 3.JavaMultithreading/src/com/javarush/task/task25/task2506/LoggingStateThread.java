package com.javarush.task.task25.task2506;

/**
 * Created by alexa on 06.08.2017.
 */
public class LoggingStateThread extends Thread{

    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        State state = null;
        while (thread.getState()!=State.TERMINATED){
            if(state!=thread.getState()){
                state=thread.getState();
                System.out.println(thread.getState());
            }
        }
        interrupt();
    }
}