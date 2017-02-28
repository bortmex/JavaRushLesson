package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(miNumber(miNumber(Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine())),miNumber(Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()))));
    }

    public static int miNumber(int a, int b) {
        return a > b ? a : b;
    }
}
