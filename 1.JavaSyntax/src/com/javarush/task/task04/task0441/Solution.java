package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arrayNumber = new int[3];

        for (int i = 0; i < 3; i++) {
            arrayNumber[i] = Integer.parseInt(reader.readLine());
        }

        inOrder(arrayNumber);
    }

    public static void inOrder(int[] array){
        String text="";
        Arrays.sort(array);
        System.out.println(array[1]);
    }
}
