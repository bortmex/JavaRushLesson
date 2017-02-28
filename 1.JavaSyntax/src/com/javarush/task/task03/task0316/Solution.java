package com.javarush.task.task03.task0316;

/* 
Экранирование символов
*/

public class Solution {
    public static void main(String[] args) {
        replasespec("C:\\Program Files\\Java\\jdk1.7.0\\bin");
    }

    public static void replasespec(String text){
        System.out.println("It's Windows path: \"" +   text + "\"");
        System.out.println("It's Java string: \\\"" +   text.replaceAll("\\\\","\\\\\\\\")  + "\\\"");
        System.out.println("It's Java string: \"C:\\Program Files\\Java\\jdk1.7.0\\bin\"");
    }
}
