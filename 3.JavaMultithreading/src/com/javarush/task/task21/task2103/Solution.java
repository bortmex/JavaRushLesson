package com.javarush.task.task21.task2103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Все гениальное - просто!
*/
public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
        return c;
    }
    public static boolean calculate2(boolean a, boolean b, boolean c, boolean d) {
        return ((a && b && !d) || !a || !b) & c;
}
    public static boolean calculate3(boolean a, boolean b, boolean c, boolean d) {
        return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
    }

    public static void main(String[] args) throws IOException {
        int i = 10;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if(reader.readLine().equals("1")) {
            while (i > 0) {
                boolean a = randomBoolean();
                boolean b = randomBoolean();
                boolean c = randomBoolean();
                boolean d = randomBoolean();

                System.out.println(calculate2(a, b, c, d));
                System.out.println(calculate3(a, b, c, d));
                i--;
            }
        } else {
        boolean a = true;
        boolean b = false;
        boolean c = true;
        boolean d = false;

        System.out.println(calculate(a,b,c,d));
        System.out.println(calculate2(a,b,c,d));
        System.out.println(calculate3(a,b,c,d));}
    }

    public static boolean randomBoolean(){
        int rand = (int) (Math.random() * 2);
        System.out.println(rand);
        if(rand==1) return true;
        else return false;
    }
}
