package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels = new ArrayList<>();

        public Car() {
            String[] wheel = loadWheelNamesFromDB();
            if(wheel.length!=4)
                throw new IllegalArgumentException();
            for (String wheelz:wheel) {
                if(wheelz.equals(Wheel.BACK_LEFT.toString())){
                    wheels.add(Wheel.BACK_LEFT);
                } else if(wheelz.equals(Wheel.BACK_RIGHT.toString())){
                    wheels.add(Wheel.BACK_RIGHT);
                } else if(wheelz.equals(Wheel.FRONT_LEFT.toString())){
                    wheels.add(Wheel.FRONT_LEFT);
                } else if(wheelz.equals(Wheel.FRONT_RIGHT.toString())){
                    wheels.add(Wheel.FRONT_RIGHT);
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }

        protected String[] loadWheelNamesFromDB() {
//this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}