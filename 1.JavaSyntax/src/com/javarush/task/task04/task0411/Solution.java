package com.javarush.task.task04.task0411;

/* 
Времена года на Терре
*/

public class Solution {
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
    }

    public static void checkSeason(int month) {
        System.out.println(((month>0 && month<3) || month==12) ? "зима" : (month>2 && month<6) ? "весна" : (month>5 && month<9) ? "лето" : "осень");
    }
}