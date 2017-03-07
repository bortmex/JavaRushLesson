package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Громов", "Игорь");
        map.put("Грозов", "Вася");
        map.put("Грим3", "Толя");
        map.put("Грим3", "Игорь5");
        map.put("Громо234в", "Вася");
        map.put("Гром4", "Игорь3");
        map.put("Гро2в", "Игорь3");
        map.put("Гро2в", "И2горь");
        map.put("Гром1234ов", "Игорь3");
        map.put("Гро1421мов", "Иго4рь");
        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
