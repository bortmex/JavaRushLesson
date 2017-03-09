package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("1");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("2");
        ArrayList<String> list3 = new ArrayList<>();
        ArrayList<String>[] arr = new ArrayList[3];
        list3.add("3");
        arr[0] = list1;
        arr[1] = list2;
        arr[2] = list3;
        return arr;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}