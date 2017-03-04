package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        coordinatePlane();
    }

    public static void coordinatePlane() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(reader.readLine());
        int second = Integer.parseInt(reader.readLine());
        System.out.println(first>0&&second>0 ? 1 : first> 0 && second<0 ? 4 : first<0 && second<0 ? 3 : 2);
    }
}
