package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null || string.isEmpty()) throw new TooShortStringException();
        String[] arrStr = string.split("\t");

        String end = "";
        try {
            end = arrStr[2];
            end = arrStr[1];
        }catch (ArrayIndexOutOfBoundsException e){
            throw new TooShortStringException();
        }
        return end;
    }
    public static class TooShortStringException extends Exception {
    }
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}