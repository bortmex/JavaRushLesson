package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);
        BufferedReader reader = new BufferedReader(fileReader);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        String str = "";
        while (reader.ready()){
            String[] ihavenumber = reader.readLine().split(" ");
            for (int i = 0; i < ihavenumber.length; i++) {
                if(!ihavenumber[i].matches("^\\D*$")) str+=ihavenumber[i] + " ";
            }
        }
        str=str.trim();
        writer.write(str);
        writer.close();
        reader.close();
    }
}