package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Stallone", 500);
        map.put("Stallone1", 499);
        map.put("Stallone2", 300);
        map.put("Stallone3", 501);
        map.put("Stallone4", 540);
        map.put("Stallone5", 5100);
        map.put("Stallone6", 1500);
        map.put("Stallone7", 10);
        map.put("Stallone8", 999);
        map.put("Stallone9", 123);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        HashMap<String, Integer> copy = new HashMap<String, Integer>(map);
        for (Map.Entry<String, Integer> pair : copy.entrySet()) {
            if (pair.getValue()<500)
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}