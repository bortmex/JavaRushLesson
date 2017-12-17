package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.FileStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        StorageStrategy strategy1 = new FileStorageStrategy();
        testStrategy(strategy1, 10);

    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> set = new HashSet<>();
        for (String s:strings) {
            set.add(shortener.getId(s));
        }
        return set;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> set = new HashSet<>();
        for (Long s:keys) {
            set.add(shortener.getString(s));
        }
        return set;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) throws IllegalAccessException, InstantiationException {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> set = new HashSet<>();
        while (elementsNumber-->0){
            set.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);

        Date start = new Date();
        Set<Long> set1 = getIds(shortener,set);
        long end = new Date().getTime() - start.getTime();

        Date start1 = new Date();
        Set<String> set2 = getStrings(shortener,set1);
        long end1 = new Date().getTime() - start.getTime();

        Helper.printMessage(set2.size()==set.size() ? "Тест пройден." : "Тест не пройден.");
    }
}
