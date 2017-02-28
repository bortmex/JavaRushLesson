package com.javarush.task.task04.task0418;
/*
Минимум двух чисел
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        miNumber(Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()));
    }

    public static void miNumber(int a, int b) {
        System.out.println(a < b ? a : b);
    }
}