package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String,String> map = new HashMap<>();
        map.put("Громов", "Игорь");
        map.put("Грозов", "Вася");
        map.put("Грим", "Толя");
        map.put("Грим3", "Игорь5");
        map.put("Громо234в", "3Игорь");
        map.put("Гром4", "Иорь");
        map.put("Гров", "Игорь3");
        map.put("Громо21в", "И2горь");
        map.put("Гром1234ов", "Иго2рь");
        map.put("Гро1421мов", "Иго4рь");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int count = 0;
        for (Map.Entry<String, String> maps:map.entrySet()) {
            if(maps.getValue().equals(name)) count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int count = 0;
        for (Map.Entry<String, String> maps:map.entrySet()) {
            if(maps.getKey().equals(lastName)) count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
