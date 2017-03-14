package com.javarush.task.task12.task1209;

/* 
Три метода возвращают минимальное из двух переданных в него чисел
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static int min(int x, int y){
        return y>x ? x : y;
    }
    public static long min(long x, long y){
        return y>x ? x : y;
    }
    public static double min(double x, double y){
        return y>x ? x : y;
    }
}
