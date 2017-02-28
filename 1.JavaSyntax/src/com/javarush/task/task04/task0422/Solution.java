package com.javarush.task.task04.task0422;

/* 
18+
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        inOrder();
    }

    public static void inOrder() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        int age;

        name = reader.readLine();
        age = Integer.parseInt(reader.readLine());

        if (age<18) System.out.println("Подрасти еще");
    }
}
