package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        inOrder();
    }

    public static void inOrder() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[2];

        for (int i = 0; i < 2; i++) {
            array[i] = reader.readLine();
        }

        if(array[0].equals(array[1])) System.out.println("Имена идентичны");else  if (array[0].length() == array[1].length()) System.out.println("Длины имен равны");
    }
}
