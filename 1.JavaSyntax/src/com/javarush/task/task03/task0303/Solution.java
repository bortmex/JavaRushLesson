package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertEurToUsd(12,45));
        System.out.println(convertEurToUsd(13,455));
    }

    public static double convertEurToUsd(int eur, double course) {
        return eur*course;
    }
}
