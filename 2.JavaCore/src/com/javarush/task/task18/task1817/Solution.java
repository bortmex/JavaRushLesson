package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        int spacesum = 0;
        int sumall = inputStream.available();
        while (inputStream.available()>0){
            int number = inputStream.read();
            if(32==number) spacesum++;
        }
        System.out.println(String.format("%.2f",spacesum * 1.0/sumall *100));
        inputStream.close();
    }
}
