package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112")); //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123")); //expected output: [6]
        System.out.println(getRadix("5321")); //expected output: []
        System.out.println(getRadix("1A")); //expected output: []
    }

    private static Set<Integer> getRadix(String number){
        Set<Integer> set = new HashSet<>();
        if(!Pattern.compile("^[0-9A-Za-z]+$").matcher(number).matches()) return set;
        for (int i = 2; i < 37; i++) {
            try {
                String numberLocal = Integer.toString(Integer.parseInt(number),i);
                if(isPolindromic(numberLocal)){
                    set.add(i);
//System.out.println(numberLocal);
                }
            }catch (Exception e){}
        }
        return set;
    }

    private static boolean isPolindromic(String newNumb)
    {
        int center = newNumb.length()/2;
        for (int i = 0; i < center; i++) {
            if(newNumb.charAt(i)!=newNumb.charAt(newNumb.length()-(i+1)))
            {
                return false;
            }
        }
        return true;
    }
}