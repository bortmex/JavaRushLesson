package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[1]);
        FileOutputStream outputStream = new FileOutputStream(args[2]);
        while (inputStream.available()>0){
            int number = inputStream.read();
            int number1 = number+1;
            int number2 = number-1;
            if(args[0].equals("-e")) outputStream.write(number+1);
            else if(args[0].equals("-d")) outputStream.write(number-1);
        }
        outputStream.close();
        inputStream.close();
    }
}
