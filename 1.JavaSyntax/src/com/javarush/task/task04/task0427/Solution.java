package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(reader.readLine());
        if(first>1000 || first<1) return;
        String text = "";

        switch (Integer.toString(first).length()){
            case 1: text+="однозначное число";
                break;
            case 2: text+="двузначное число";
                break;
            case 3: text+="трехзначное число";
                break;
            default: return;
        }

        text = (first%2==0 ? "четное " : "нечетное ") + text;
        System.out.println(text);
    }
}
