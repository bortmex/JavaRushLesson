package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }

        int coret = list.get(0);
        int max = 0;
        int save = 0;
        for (int i = 0; i < list.size(); i++) {
            if (coret == list.get(i)) {
                max++;
                if (save < max) save = max;
            } else {
                if (save < max) save = max;
                max = 1;
                coret = list.get(i);
            }
        }
        System.out.println(save);
    }
}