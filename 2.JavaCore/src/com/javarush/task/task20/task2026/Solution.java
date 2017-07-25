package com.javarush.task.task20.task2026;

import java.util.ArrayList;
import java.util.List;

/*
Алгоритмы-прямоугольники
*/
public class Solution {

    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        a = strategArr(a);
        if(a.length==0) return 0;
        List<Pair> list = new ArrayList<>();
        for (int i = 1; i < a.length - 1; i++) {
            for (int j = 1; j < a[0].length - 1; j++) {

                if (a[i - 1][j] == 0 && a[i][j - 1] == 0 && a[i][j]!=0) {
                    list.add(new Pair(i, j));
                    a[i][j] = 8;
                }
            }
        }
        return list.size();
    }

    public static byte[][] strategArr(byte[][] arr) {
        byte[][] arrNew = new byte[arr.length + 2][arr[0].length + 2];
        for (int i = 0; i < arrNew.length; i++) {
            for (int j = 0; j < arrNew[0].length; j++) {
                if (i == 0 || j == 0 || i == arrNew.length - 1 || j == arrNew[0].length - 1) arrNew[i][j] = 0;
                else arrNew[i][j] = arr[i - 1][j - 1];
            }
        }
        return arrNew;
    }

    public static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair " +
                    "x=" + x +
                    " y=" + y;
        }
    }
}