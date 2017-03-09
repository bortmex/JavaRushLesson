package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat simpleFormatterExit = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        Date date = simpleFormatter.parse(reader.readLine());
        String newFormatdate = simpleFormatterExit.format(date);
        System.out.println(newFormatdate.substring(0,3).toUpperCase() + newFormatdate.substring(3,newFormatdate.length()));
    }
}
