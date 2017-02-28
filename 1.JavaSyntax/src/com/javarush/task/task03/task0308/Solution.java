package com.javarush.task.task03.task0308;

/* 
Произведение 10 чисел
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(factorial(10));
    }

    public static int factorial(int number){
        int result;

        if (number == 1)
            return 1;
        result = factorial(number - 1) * number;
        return result;
    }
}
