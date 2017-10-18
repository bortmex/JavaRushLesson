package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.recursion(88);
    }

    public void recursion(int n) {
        if (n > 1) {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    System.out.print(i + " ");
                    recursion(n / i);
                    break;
                }
                if(i==n-1) System.out.print(n);
            }

        }
    }
}