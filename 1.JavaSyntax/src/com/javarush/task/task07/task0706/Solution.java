package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.InputStreamReader;/*
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arrInt = new int[15];
        int leftHouse = 0;
        int rightHouse = 0;

        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < arrInt.length; i+=2) {
            leftHouse+=arrInt[i];
        }

        for (int i = 1; i < arrInt.length; i+=2) {
            rightHouse+=arrInt[i];
        }

        System.out.println(leftHouse>rightHouse ? "В домах с четными номерами проживает больше жителей." : "В домах с нечетными номерами проживает больше жителей.");
    }
}
