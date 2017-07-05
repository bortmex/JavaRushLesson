package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        int ascitruesum = 0;
        while (inputStream.available()>0){
            int number = inputStream.read();
            if((64<number && number<91) || (96<number && number<123)) ascitruesum++;
        }
        System.out.println(ascitruesum);
        inputStream.close();
    }
}
