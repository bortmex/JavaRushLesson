package com.javarush.task.task08.task0816;

import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Stallone1", new Date("SEPTEMBER 1 1980"));
        map.put("Stallone2", new Date("NOVEMBER 1 1980"));
        map.put("Stallone3", new Date("JUNE 2 1980"));
        map.put("Stallone4", new Date("MARCH 1 1980"));
        map.put("Stallone5", new Date("JUNE 5 1980"));
        map.put("Stallone6", new Date("JUNE 7 1980"));
        map.put("Stallone7", new Date("JULY 8 1980"));
        map.put("Stallone8", new Date("JUNE 1 1980"));
        map.put("Stallone9", new Date("AUGUST 10 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        for (Iterator<Map.Entry<String,Date>> iterator = map.entrySet().iterator();iterator.hasNext(); ){
            Map.Entry<String,Date> entry = iterator.next();
            Calendar cal = Calendar.getInstance();
            cal.setTime(entry.getValue());
            if(cal.get(Calendar.MONTH)>4 && cal.get(Calendar.MONTH)<8) iterator.remove();
        }
    }

    public static void main(String[] args) {
    }
}
