package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Самая длинная строка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        int[] arrInt = new int[5];
        for (int i = 0; i < 5; i++) {
            list.add(reader.readLine());
        }

        for (int i = 0; i < list.size(); i++) {
            arrInt[i] = list.get(i).length();
        }

        Collections.sort(list);

        for (String text : list) {
            if (text.length() == list.get(list.size() - 1).length()) System.out.println(text);
        }
    }
}
