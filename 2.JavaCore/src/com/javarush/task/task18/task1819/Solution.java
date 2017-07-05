package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        FileOutputStream outputStream = new FileOutputStream(name1,true);
        FileInputStream inputStream1 = new FileInputStream(name1);
        FileInputStream inputStream2 = new FileInputStream(name2);

        byte[] buf1 = new byte[1000];
        byte[] buf2 = new byte[1000];

        int count1 = 0;

        while (inputStream1.available()>0){
            count1 = inputStream1.read(buf1);
        }

        PrintWriter out = new PrintWriter(name1);
        out.print("");
        out.close();
        while (inputStream2.available()>0){
            int count = inputStream2.read(buf2);
            outputStream.write(buf2,0,count);
            outputStream.write(buf1, 0,count1);
        }

        inputStream2.close();
        inputStream1.close();
        outputStream.close();
    }
}
