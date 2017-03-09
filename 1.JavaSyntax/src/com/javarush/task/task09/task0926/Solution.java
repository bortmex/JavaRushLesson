package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> listArr = new ArrayList<>();
        int[] arr1 = new int[5];
        fillArrRand(arr1);
        int[] arr2 = new int[2];
        fillArrRand(arr2);
        int[] arr3 = new int[4];
        fillArrRand(arr3);
        int[] arr4 = new int[7];
        fillArrRand(arr4);
        int[] arr5 = new int[0];
        fillArrRand(arr5);
        listArr.add(arr1);
        listArr.add(arr2);
        listArr.add(arr3);
        listArr.add(arr4);
        listArr.add(arr5);
        return listArr;
    }

    public static void fillArrRand(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
