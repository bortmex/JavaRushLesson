package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        year(scanner.nextInt());
    }

    public static void year(int year){
        System.out.println( "количество дней в году: " + ((year%100==0) ? (year%400)==0 ? 366: 365 : (year%4==0) ? 366 : 365));
    }
}