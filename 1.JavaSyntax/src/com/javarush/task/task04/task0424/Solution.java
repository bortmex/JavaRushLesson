package com.javarush.task.task04.task0424;

/* 
Три числа
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
        int[] array = new int[3];

        for (int i = 0; i < 3; i++) {
            array[i]=Integer.parseInt(reader.readLine());
        }

        if(array[0]==array[1]) System.out.println(3);
        else if(array[1]==array[2]) System.out.println(1);
        else if(array[0]==array[2]) System.out.println(2);
    }
}
