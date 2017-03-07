package com.javarush.task.task07.task0707;

/*
Что за список такой?
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            list.add("text" + i);
        }

        System.out.println(list.size());

        for (String text: list) {
            System.out.println(text);
        }
    }
}
