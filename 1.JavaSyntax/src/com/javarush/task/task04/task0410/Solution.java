package com.javarush.task.task04.task0410;

/* 
Попадём-не-попадём
*/

public class Solution {
    public static void main(String[] args) {
        checkInterval(60);
        checkInterval(112);
    }

    public static void checkInterval(int a) {
        System.out.println((a>50 && a<100) ? "Число "+ a +" содержится в интервале." : "Число "+ a +" не содержится в интервале.");
    }
}