package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null || string.isEmpty()) throw new TooShortStringException();
        String[] arrStr = string.split(" ");
        String end = "";
        try {
            for (int i = 1; i < 5; i++) {
                end += arrStr[i] + " ";
            }
            end=end.trim();
        }catch (IndexOutOfBoundsException e){
            throw new TooShortStringException();
        }
        return end;
    }
    public static class TooShortStringException extends RuntimeException {
    }
}