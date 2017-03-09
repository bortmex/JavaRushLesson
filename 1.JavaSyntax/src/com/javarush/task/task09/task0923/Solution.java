package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] text = reader.readLine().toCharArray();
        String textFirst = "";
        String textSecond = "";

        for (char simbol:text) {
            if(isVowel(simbol)) textFirst+= simbol + " ";
        }

        for (char simbol:text) {
            if(!isVowel(simbol) && simbol!=' ') textSecond+= simbol + " ";
        }

        System.out.println(textFirst);
        System.out.println(textSecond);
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}