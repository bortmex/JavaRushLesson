package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String[] args) throws IOException { //C:\Users\rogov\Desktop\12345.txt 4 ppppooo
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName,"rw");

        byte[] buff = new byte[1024];
        byte[] buff1 = new byte[1024];
        randomAccessFile.seek(number);
        randomAccessFile.read(buff,0,text.length());

        String text1 = "";
        int i = 0;
        while (true){
            if(i==text.length()) break;
            text1 +=(char) buff[i++];
        }
        randomAccessFile.seek(randomAccessFile.length());
        if(text1.equals(text))
            randomAccessFile.write("true".getBytes());
        else randomAccessFile.write("false".getBytes());
        randomAccessFile.close();
    }
}