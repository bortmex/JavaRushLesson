package com.javarush.task.task05.task0532;

import java.io.*;
import java.util.Arrays;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = Integer.parseInt(reader.readLine());
        int[] arrint = new int[maximum];

        for (int i = 0; i < maximum; i++) {
            arrint[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(arrint);
        maximum= arrint[maximum-1];
        System.out.println(maximum);
    }
}
