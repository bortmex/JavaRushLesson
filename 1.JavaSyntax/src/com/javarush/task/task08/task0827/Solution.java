package com.javarush.task.task08.task0827;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        DateFormat format = new SimpleDateFormat("MMM d yyyy", Locale.ENGLISH);
        Date dateStr = new Date();
        try {
            dateStr = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat formatD = new SimpleDateFormat("D", Locale.ENGLISH);
        System.out.println(formatD.format(dateStr));
        return Integer.parseInt(formatD.format(dateStr)) % 2 == 1;
    }
}
