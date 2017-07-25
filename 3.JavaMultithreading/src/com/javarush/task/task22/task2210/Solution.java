package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTokens("sdf1sr 234 sr 234234sr234 sr234","sr")));
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        List<String> list = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()){
            String text = stringTokenizer.nextToken();
            list.add(text);
        }
        return list.toArray(new String[list.size()]);
    }
}