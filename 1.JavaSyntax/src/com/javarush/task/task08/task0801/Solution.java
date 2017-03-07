package com.javarush.task.task08.task0801;

/* 
HashSet из растений
*/

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("арбуз");
        hashSet.add("банан");
        hashSet.add("вишня");
        hashSet.add("груша");
        hashSet.add("дыня");
        hashSet.add("ежевика");
        hashSet.add("жень-шень");
        hashSet.add("земляника");
        hashSet.add("ирис");
        hashSet.add("картофель");

        for (String text:hashSet) {
            System.out.println(text);
        }
    }
}
