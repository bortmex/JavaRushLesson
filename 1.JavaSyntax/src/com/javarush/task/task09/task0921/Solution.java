package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;/*
Метод в try..catch
*/
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        try {
            while (true) {
                list.add(Integer.parseInt(reader.readLine()));
            }
        } catch (Exception e) {
            for (Integer number:list) {
                System.out.println(number);
            }
        }
    }
}
