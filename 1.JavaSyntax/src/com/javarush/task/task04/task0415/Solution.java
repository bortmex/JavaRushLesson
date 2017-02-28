package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println(triangleTrue(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()) ? "Треугольник не существует." : "Треугольник существует.");
    }

    public static boolean triangleTrue(int a, int b, int c){

        return ((a + b) <= c || (a + c) <= b || (b + c) <= a);
    }
}