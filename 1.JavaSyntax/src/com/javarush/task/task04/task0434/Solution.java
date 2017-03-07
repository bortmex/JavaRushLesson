package com.javarush.task.task04.task0434;


/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int number = 1;
        String text = "";
        while (number<11){
            int number1 = 1;
            while (number1<11){
                text+=number*number1 + " ";
                number1++;
            }
            text=text.substring(0,text.length()-1) + "\n";
            number++;
        }

        System.out.println(text);
    }
}
