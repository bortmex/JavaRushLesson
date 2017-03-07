package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        HashSet<Integer> listSet = new HashSet<>();

        for (int i = 1; i < 21; i++) {
            listSet.add(i);
        }
        return listSet;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            if((int) iterator.next()>10) iterator.remove();
        }
        return set;
    }

    public static void main(String[] args) {
    }
}
