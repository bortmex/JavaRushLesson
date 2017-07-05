package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(name1);
        FileOutputStream outputStream = new FileOutputStream(name2);

        /*FileInputStream inputStream = new FileInputStream("C:\\Users\\alexa\\Desktop\\231.txt");
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\alexa\\Desktop\\2311");*/
        byte[] buf = new byte[1000];

        int count;
        while (inputStream.available()>0) {
            count = inputStream.read(buf);
            for (int i = count-1; i >= 0; i--) {
                outputStream.write(buf[i]);
            }
        };

        inputStream.close();
        outputStream.close();
    }
}
