package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        int max = 9999999;
        while (fileInputStream.available()>0){
            int number = 0;
            if((number = fileInputStream.read())<max) max = number;
        }
        System.out.println(max);
        fileInputStream.close();
    }
}
