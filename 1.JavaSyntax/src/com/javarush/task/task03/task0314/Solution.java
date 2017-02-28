package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            System.out.println(str(i));
        }
    }

    public static String str(int number){
        StringBuffer text = new StringBuffer();
        for (int i = number; i < number*11; i+=number) {
            text.append(i).append(" ");
        }
        return text.delete(text.length()-1,text.length()).toString();
    }

}
