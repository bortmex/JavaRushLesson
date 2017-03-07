package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;/*
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] arrInt = new int[20];
        int[] arrFirstInt = new int[10];
        int[] arrSecondInt = new int[10];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < arrInt.length/2; i++) {
            arrFirstInt[i] = arrInt[i];
        }

        for (int i = 0; i < arrInt.length/2; i++) {
            arrSecondInt[i] = arrInt[i + 10];
        }

        for (int i = 0; i < arrSecondInt.length; i++) {
            System.out.println(arrSecondInt[i]);
        }
    }
}
