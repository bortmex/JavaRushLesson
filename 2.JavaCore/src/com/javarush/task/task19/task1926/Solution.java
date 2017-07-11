package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str = "";
        while (bufferedReader.ready()){
            str+=new StringBuffer(bufferedReader.readLine()).reverse().toString() + "\n\r";
        }
        str = str.substring(0,str.length()-2);
        fileReader.close();
        System.out.println(str);
    }
}