package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String[] text = s.split(" ");
        String textUp = "";
        for (int i = 0; i < text.length; i++) {
            try {
                textUp += text[i].substring(0, 1).toUpperCase() + text[i].substring(1, text[i].length()) + " ";
            } catch (Exception e) {
                textUp += " ";
            }
        }
        textUp = textUp.substring(0, textUp.length() - 1);
        System.out.println(textUp);
    }
}
