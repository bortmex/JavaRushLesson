package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine()); //C:\Users\alexa\Desktop\231.txt
        Set<Integer> set = new TreeSet<Integer>();
        while (fileInputStream.available() > 0) {
            set.add(fileInputStream.read());
        }
        fileInputStream.close();

        String text = "";
        for (Integer chislo : set) {
            text += chislo + " ";
        }
        text = text.trim();

        System.out.println(text);
    }
}
