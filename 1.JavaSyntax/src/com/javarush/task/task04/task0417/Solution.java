package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        couple(Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()));
    }

    public static void couple(int a, int b, int c){
        String text = "";
        text = a == b && c == b ? a + " " + b + " " + c : a == b ? a + " " + b : b == c ? b + " " + c : a == c ? a + " " + c : "";
        if(!text.equals("")) System.out.println(text);
    }
}