package com.javarush.task.task04.task0408;

/* 
Хорошо или плохо?
*/

public class Solution {
    public static void main(String[] args) {
        compare(3);
        compare(6);
        compare(5);
    }

    public static void compare(int a) {
        String text = "";
        text =  (a<5) ? "Число меньше 5" : (a==5) ? "Число равно 5" : "Число больше 5";
        System.out.println(text);
    }
}