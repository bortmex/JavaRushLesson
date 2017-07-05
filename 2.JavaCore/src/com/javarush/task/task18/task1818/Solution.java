package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        String name3 = reader.readLine();
        FileOutputStream outputStream = new FileOutputStream(name1,true);
        FileInputStream inputStream1 = new FileInputStream(name2);
        FileInputStream inputStream2 = new FileInputStream(name3);
        byte[] buf1 = new byte[1000];
        byte[] buf2 = new byte[1000];

        while (inputStream1.available()>0){
            int count = inputStream1.read(buf1);
            outputStream.write(buf1,0,count);
        }

        while (inputStream2.available()>0){
            int count = inputStream2.read(buf2);
            outputStream.write(buf2,0,count);
        }
        outputStream.close();
        inputStream1.close();
        inputStream2.close();
    }
}
