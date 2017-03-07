package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(reader.readLine());
        if(first==0) {
            System.out.println("ноль");
            return;
        }
        String text = "";

        text += first>0 ? "положительное " : "отрицательное ";
        text += first%2==0 ? "четное число" : "нечетное число";
        System.out.println(text);
    }
}
