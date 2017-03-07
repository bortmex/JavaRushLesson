package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
В убывающем порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 10; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        Collections.sort(list, Collections.reverseOrder());

        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
    }
}
