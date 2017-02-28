package com.javarush.task.task01.task0131;

/* 
Полнометражная картина
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getMetreFromCentimetre(243));
    }

    public static int getMetreFromCentimetre(int centimetre) {
        String text = Integer.toString(centimetre);
        if(text.length()<=2) return 0;
        else
        return Integer.parseInt(text.substring(0,text.length()-2));
    }
}