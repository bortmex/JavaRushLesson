package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try {
        if (!Pattern.compile("^[0-9A-Za-z]+$").matcher(args[0]).matches()) {
            System.out.println("incorrect");
            return;
        }
        int i = 1;
            while (i++ < 35) {
                try {
                    BigDecimal bi = new BigDecimal(new BigInteger(args[0], i));
                    break;
                } catch (NumberFormatException e) {
                }
            }
            System.out.println(i);

        } catch (Exception e) {

        }


    }
}