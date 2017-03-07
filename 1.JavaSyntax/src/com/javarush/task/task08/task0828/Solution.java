package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();
        ArrayList<DateFormat> listFormat = new ArrayList<>();
        listFormat.add(new SimpleDateFormat("MMM", Locale.ENGLISH));
        listFormat.add(new SimpleDateFormat("M", Locale.ENGLISH));
        Date dateStr = new Date();
        try {
            dateStr = listFormat.get(0).parse(month);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(month +" is " + listFormat.get(1).format(dateStr) + " month");
    }

}
