package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String txt = "";
        int summa = 0;

        while (true){
            txt=reader.readLine();
            if(!txt.equals("сумма")) summa+=Integer.parseInt(txt); else break;
        }

        System.out.println(summa);
    }
}
