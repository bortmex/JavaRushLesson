package com.javarush.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {

        System.out.println(newHashMap(newArrayList("1","12"), newArrayList(1,8)));
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        ArrayList<T> list = new ArrayList<T>();
        for (int i = 0; i < elements.length; i++) {
            list.add(elements[i]);
        }
        return list;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        HashSet<T> hashSet = new HashSet<>();
        for (int i = 0; i < elements.length; i++) {
            hashSet.add(elements[i]);
        }
        return hashSet;
    }

    public static <K, V> HashMap<K,V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        if(keys.size()!= values.size()) throw new IllegalArgumentException();
        HashMap<K,V> hashMap = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            hashMap.put(keys.get(i),values.get(i));
        }
        return hashMap;
    }
}