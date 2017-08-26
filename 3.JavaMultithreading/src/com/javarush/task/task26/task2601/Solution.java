package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
    /*    Integer[] arsd = {3, 4, 7, 6, 5, 2, 1, 11, 5, 48, 49, 56, 92, 94};
        Integer[] arsd2 = {13, 8, 15, 5, 17};
        System.out.println(Arrays.toString(sort(arsd)));
        System.out.println("------------------------------");
        System.out.println(Arrays.toString(sort(arsd2)));*/
    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        Integer[] arr2 = new Integer[array.length];
        Integer median = array[array.length / 2];
        if (array.length % 2 == 0)
            median = (array[array.length / 2-1] + array[array.length / 2]) / 2;

        final Integer finalMedian1 = median;
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1-finalMedian1) - Math.abs(o2-finalMedian1);
            }
        });

        return array;
    }
}