package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int number = 0;
        while (number!=-1){
            number = Integer.parseInt(reader.readLine());
            count+=number;
        }
        System.out.println(count);
    }
}
