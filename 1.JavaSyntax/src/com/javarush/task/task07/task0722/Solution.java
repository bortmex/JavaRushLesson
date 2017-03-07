package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String warning = "";

        while (!warning.equals("end")) {
            list.add(warning);
            warning = reader.readLine();
        }
        list.remove(0);
        for (String text : list) {
            System.out.println(text);
        }
    }
}