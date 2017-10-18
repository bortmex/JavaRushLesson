package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String[] args) throws IOException { //C:\Users\alexa\Desktop\12345.txt 3 pizdec
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");


        if (randomAccessFile.length() < number) randomAccessFile.seek(randomAccessFile.length());
        else randomAccessFile.seek(number);
        randomAccessFile.write(text.getBytes());
        randomAccessFile.close();
    }
}