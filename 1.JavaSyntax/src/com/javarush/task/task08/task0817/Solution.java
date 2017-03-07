package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Громов", "Игорь");
        map.put("Грозов", "Вася");
        map.put("Грим", "Толя");
        map.put("Грим3", "Игорь5");
        map.put("Громо234в", "Вася");
        map.put("Гром4", "Игорь3");
        map.put("Гро2в", "Игорь3");
        map.put("Громо21в", "И2горь");
        map.put("Гром1234ов", "Игорь3");
        map.put("Гро1421мов", "Иго4рь");
        return map;
    }


    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        HashMap<String, Integer> mapsDubl = new HashMap<>();
        for (Map.Entry<String, String> maps : map.entrySet()) {
            mapsDubl.put(maps.getValue(), 0);
        }
        for (Map.Entry<String, String> maps : map.entrySet()) {
            mapsDubl.put(maps.getValue(), mapsDubl.get(maps.getValue()) + 1);
        }
        HashMap<String, Integer> copy = new HashMap<String, Integer>(mapsDubl);
        for (Map.Entry<String, Integer> pair : copy.entrySet()) {
            if(pair.getValue()==1) mapsDubl.remove(pair.getKey());
        }
        ArrayList<String> listDbl = new ArrayList<>(mapsDubl.keySet());

        for (String text:listDbl) {
            removeItemFromMapByValue(map,text);
        }

}

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
    }
}
