package com.javarush.task.task05.task0531;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Совершенствуем функциональность
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arrint = new int[5];
        arrint[0] = Integer.parseInt(reader.readLine());
        arrint[1] = Integer.parseInt(reader.readLine());
        arrint[2] = Integer.parseInt(reader.readLine());
        arrint[3] = Integer.parseInt(reader.readLine());
        arrint[4] = Integer.parseInt(reader.readLine());

        int minimum = min(arrint[0], arrint[1], arrint[2], arrint[3], arrint[4]);

        System.out.println("Minimum = " + minimum);
    }


    public static int min(int arr1,int arr2,int arr3,int arr4,int arr5) {
        int[] arr = new int[5];
        arr[0] = arr1;
        arr[1] = arr2;
        arr[2] = arr3;
        arr[3] = arr4;
        arr[4] = arr5;
        Arrays.sort(arr);
        return arr[0];
    }
}
