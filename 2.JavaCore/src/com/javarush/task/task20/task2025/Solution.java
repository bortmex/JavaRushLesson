package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/*
Алгоритмы-числа
*/
public class Solution {

    public static long[][] matrix = new long[20][20];
    public static TreeSet<Long> treeList = new TreeSet<>();
    public static TreeSet<Long> treeList1 = new TreeSet<>();

    static {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] = multPow(i, j);
            }
        }
    }

    public static long[] getNumbers(long N) {
        long[] result = null;

        for (long imax = 0; imax < N; imax++) {
            if (nextNuberMore(imax)) continue;
            whoIsAmstrongNumberMyFirst(imax, N);
        }

        result = new long[treeList.size()];
        int i = 0;
        for (Long number : treeList) {
            result[i++] = number;
        }
        return result;
    }

    public static void main(String[] args) {
        mySearch1(1888899902348L);
    }


    public static void mySearch1(long max) {
        long start = System.currentTimeMillis();

        for (long imax = 0; imax < max; imax++) {
            if (nextNuberMore(imax)) continue;
            whoIsAmstrongNumberMyFirst(imax,max);
        }

        StringBuilder text = new StringBuilder();
        for (Long number : treeList) {
            text.append(new StringBuilder(Long.toString(number))).append(",").append(" ");
        }

        System.out.println("MyAlgoritm");
        System.out.println(text.toString().trim().substring(0,text.toString().length()-2));
        System.out.println("Время выполнения программы: " + (System.currentTimeMillis() - start) / 1000 + " с");
        System.out.println(String.format("Затраченно памяти: %.2f МБ",(((double) Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (double) (1024 * 1024))));
        System.out.println("---------------------------------------------------------------------------------------------------------------");

    }


/*
    public static void mySearch2(int max) {
        long start = System.currentTimeMillis();

        System.out.println("StandartAlgoritm");

        for (int imax = 0; imax <= max; imax++)

            if (whoIsAmstrongNumber(imax)) System.out.print(imax + ", ");

        System.out.println("\n\rВремя выполнения программы: " + (System.currentTimeMillis() - start) / 1000 + " с");
        System.out.println(String.format("Затраченно памяти: %.2f МБ",(((double) Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (double) (1024 * 1024))));
        System.out.println("---------------------------------------------------------------------------------------------------------------");
    }
*/

    public static int countAmstNum(long ArmstrongNumber) {
        int i = 0;
//int temp=0;
//Проверяем сколько цифр в числе

//for(byte i=0;i<;)
        if (ArmstrongNumber > 0)
            while (ArmstrongNumber != 0) {
                ArmstrongNumber = ArmstrongNumber / 10;
                i++;
            }
//System.out.println(i);
        return i;
    }

    public static boolean detectOOOOO(long x) {

        int length = countAmstNum(x);
        long[] list1 = new long[length];
        for (int i = 0; i < length; i++) {
            list1[i] = ((int) (x % 10));
            x = x / 10;
        }
        int yes = 0;
        for (int i = length - 1; i > 0; i--) {
            if ((list1[i - 1] != list1[i]) && list1[i - 1] == 0) yes++;
        }
        if (yes == 1 && list1[0] != 0) return true;
        else return false;
    }

    public static boolean containTwo(long x1, long x2) {
        List<Long> list1 = new ArrayList<>();
        List<Long> list2 = new ArrayList<>();
        while (x1 != 0) {
            list1.add(x1 % 10);
            x1 = x1 / 10;
        }
        while (x2 != 0) {
            list2.add(x2 % 10);
            x2 = x2 / 10;
        }

        if (list1.size() != list2.size()) return false;

        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).equals(list2.get(j))) {
                    list2.remove(j);
                    break;
                }
            }
        }

        if (list2.size() == 0) return true;
        else return false;
    }

    public static boolean nextNuberMore(long x) {
        int needdontmore = 10;
        long orig = x;
        boolean yes = false;
        while (x != 0) {
            int index = (int) (x % 10);
            if (index > needdontmore) {
                if (needdontmore == 0) {
                    yes = true;
                    needdontmore = index;
                    x = x / 10;
                    continue;
                }
                return true;
            }
            needdontmore = index;
            x = x / 10;
        }
        if (yes) {
            if (detectOOOOO(orig)) {
                return true;
            }

        }
        return false;
    }

    public static long multPow(int x, int pow) {
        long exit = 1;
        for (int i = 0; i < pow; i++) {
            exit *= x;
        }
        return exit;
    }

    public static void whoIsAmstrongNumberMyFirst(long ArmstrongNumber, long N) {
        int drob = 0;
        long result = 0;
        long orig = ArmstrongNumber;
        int count = countAmstNum(ArmstrongNumber);

        if ((int) Math.log10(ArmstrongNumber) < (int) Math.log10(N)) {
            while (ArmstrongNumber != 0) {
                drob = (int) (ArmstrongNumber % 10);
                result = result + matrix[drob][count];
                ArmstrongNumber = ArmstrongNumber / 10;
            }


            if (containTwo(orig, result))
                treeList.add(result);
        }
    }

/*    public static boolean whoIsAmstrongNumber(int ArmstrongNumber) {
        int drob = 0;
        long result = 0;
        int orig = ArmstrongNumber;
        int count = countAmstNum(ArmstrongNumber);

        while (ArmstrongNumber != 0) {
//выдиляем поледнюю цифру в числе
            drob = ArmstrongNumber % 10;
            result = result + ((int) Math.pow(drob, count));
            ArmstrongNumber = ArmstrongNumber / 10;
        }

        if (orig == result) return true;

        return false;

    }*/
}