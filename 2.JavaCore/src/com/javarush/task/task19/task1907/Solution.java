package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by rogov on 06.07.2017.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        //C:\Users\alexa\Desktop\\231.txt
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        StringBuilder builder = new StringBuilder();

        int count = 0;

        while (fileReader.ready()){
            builder.append((char) fileReader.read());
        }

        String s = builder.toString();

        String[] parts = s.split("[^A-Za-z0-9]");

        for (int i = 0; i < parts.length; i++){
            if (parts[i].equals("world"))
                count++;
        }

        System.out.println(count);

        reader.close();
        fileReader.close();


    }
}