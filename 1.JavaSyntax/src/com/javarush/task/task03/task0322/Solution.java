package com.javarush.task.task03.task0322;


/* 
Большая и чистая
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String text = bufferedReader.readLine();
        String text1 = bufferedReader.readLine();
        String text2 = bufferedReader.readLine();

        System.out.println(text+" + "+text1+" + "+text2+" = Чистая любовь, да-да!");
    }
}