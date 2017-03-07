package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        inOrder();
    }

    public static void inOrder() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[3];
        int count = 0;

        for (int i = 0; i < 3; i++) {
            array[i]=Integer.parseInt(reader.readLine());
            if(array[i]>0) count++;
        }

        System.out.println(count);
    }
}
