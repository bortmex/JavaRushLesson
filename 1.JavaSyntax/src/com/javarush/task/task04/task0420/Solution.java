package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        for (int i =  array.length-1; i >=0; i--) {
            text+=array[i]+ " ";
        }
        System.out.println(text.substring(0,text.length()-1));
    }

}
