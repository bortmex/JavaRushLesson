package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        inOrder(3);
    }

    public static void inOrder(int numberOfDigits) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int countplus = 0;
        for (int i = 0; i < numberOfDigits; i++) {
            if(Integer.parseInt(reader.readLine())>0) countplus++;
        }
        System.out.println("количество отрицательных чисел: "+(numberOfDigits - countplus)+"\n" +
                "количество положительных чисел: " + countplus);
    }
}
