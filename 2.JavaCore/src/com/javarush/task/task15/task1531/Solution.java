package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        return String.valueOf(factorials(new BigInteger(String.valueOf(n))));
    }

    public static BigInteger factorials(BigInteger n)
    {
        if(new BigInteger(String.valueOf(n)).compareTo(new BigInteger(String.valueOf(0)))==0) return new BigInteger(String.valueOf(1));
        else if(new BigInteger(String.valueOf(n)).compareTo(new BigInteger(String.valueOf(0)))==-1) return new BigInteger(String.valueOf(0));
        return n.multiply(factorials(new BigInteger(String.valueOf(n)).subtract(new BigInteger(String.valueOf(1)))));
    }
}
