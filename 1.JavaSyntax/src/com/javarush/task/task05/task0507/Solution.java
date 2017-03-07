package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = 0;
        List<Integer> list = new ArrayList<>();

        while (number!=-1){
            list.add(number);
            number = Integer.parseInt(reader.readLine());
        }

        System.out.println(averageMid(list));
    }

    public static double averageMid(List<Integer> list){
        int average = 0;
        for (int i = 0; i < list.size(); i++) {
            average+=list.get(i);
        }
        return average/((list.size()-1)*1.0);
    }
}

