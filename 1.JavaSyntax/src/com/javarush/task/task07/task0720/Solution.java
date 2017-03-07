package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<>();
        int firstNumber = Integer.parseInt(reader.readLine());
        int secondNumber = Integer.parseInt(reader.readLine());

        for (int i = 0; i < firstNumber; i++) {
            list.add(reader.readLine());
        }

        for (int i = 0; i < secondNumber; i++) {
            list.add(list.get(i));
            list.remove(i);
            i--;
            secondNumber--;
        }

        for (String text:list) {
            System.out.println(text);
        }
    }
}
