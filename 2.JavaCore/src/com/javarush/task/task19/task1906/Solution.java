package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//"C:\\Users\\rogov\\Desktop\\231.txt"

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileReader fileReader = new FileReader(reader.readLine());
             FileWriter fileWriter = new FileWriter(reader.readLine())) {
            int rByte;
            int count = 0;
            while ((rByte = fileReader.read()) != -1) {
                if (++count % 2 == 0) {
                    fileWriter.write(rByte);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}