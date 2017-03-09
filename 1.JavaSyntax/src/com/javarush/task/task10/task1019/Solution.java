package com.javarush.task.task10.task1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> maps = new HashMap<>();
        String name = null;
        while (true) {
            String text= reader.readLine();
            if(text.equals("")) break;
            int id = Integer.parseInt(text);
            name = reader.readLine();

            maps.put(name,id);
        }

        for (Map.Entry<String,Integer> map:maps.entrySet()) {
            System.out.println(map.getValue() + " "+ map.getKey());
        }
    }
}
