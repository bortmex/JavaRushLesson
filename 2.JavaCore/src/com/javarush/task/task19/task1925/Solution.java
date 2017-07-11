package com.javarush.task.task19.task1925;

/* 
Длинные слова
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
            String[] arrstr = reader.readLine().split(" ");
            for (int i = 0; i < arrstr.length; i++) {
                if(arrstr[i].length()>6) str+=arrstr[i] + ",";
            }
        }
        str=str.substring(0,str.length()-1);
        writer.write(str);
        writer.close();
        reader.close();
    }
}