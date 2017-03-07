package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        int[] arrInt = new int[10];

        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }

        for (int i = 0; i < list.size(); i++) {
            arrInt[i] = list.get(i).length();
        }
        Arrays.sort(arrInt);


        for (String text : list) {
            if (text.length() == arrInt[0] || text.length() == arrInt[9]) {System.out.println(text); break;}
        }
    }
}
