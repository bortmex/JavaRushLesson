package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor Dpljr");
        System.out.println(decode(reader, -3));  //Hello Amigo

    }

    public static String decode(StringReader reader, int key) throws IOException {
        if(reader==null) return "";
        StringBuilder text = new StringBuilder();
        while (true){
            int number = reader.read();
            if(number==-1) break;
            if(number==32) {text.append((char) number); continue;}
            text.append((char) (number + key));
        }

        return text.toString();
    }

}
