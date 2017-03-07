package com.javarush.task.task04.task0436;


/* 
Рисуем прямоугольник
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(reader.readLine());
        int second = Integer.parseInt(reader.readLine());

        for (int i = 0; i < first; i++) {
            for (int j = 0; j < second; j++) {
                System.out.print("8");
            }
            System.out.println();
        }
    }
}
