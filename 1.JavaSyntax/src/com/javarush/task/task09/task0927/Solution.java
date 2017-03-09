package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args){
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap(){
        HashMap<String, Cat> mapCats = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            mapCats.put("Барсик1", new Cat("Матроскинин1"));
            mapCats.put("Барсик2", new Cat("Матроскинин2"));
            mapCats.put("Барсик3", new Cat("Матроскинин3"));
            mapCats.put("Барсик4", new Cat("Матроскинин4"));
            mapCats.put("Барсик5", new Cat("Матроскинин5"));
            mapCats.put("Барсик6", new Cat("Матроскинин6"));
            mapCats.put("Барсик7", new Cat("Матроскинин7"));
            mapCats.put("Барсик8", new Cat("Матроскинин8"));
            mapCats.put("Барсик9", new Cat("Матроскинин9"));
            mapCats.put("Барсик10", new Cat("Матроскинин10"));
        }

        return mapCats;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        return new HashSet<>(map.values());
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
