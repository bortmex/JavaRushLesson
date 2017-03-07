package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> listMain = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list0 = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            listMain.add(Integer.parseInt(reader.readLine()));
        }

        for (int i = 0; i < 20; i++) {
            int number = listMain.get(i);
            if (number % 3 == 0 && number % 2 == 0) {
                list3.add(number);
                list2.add(number);
            } else if (number % 3 == 0) list3.add(number);
            else if (number % 2 == 0) list2.add(number);
            else list0.add(number);
        }

        printList(list3);
        printList(list2);
        printList(list0);

    }

    public static void printList(List<Integer> list) {
        for (Integer number : list) {
            System.out.println(number);
        }
    }
}
