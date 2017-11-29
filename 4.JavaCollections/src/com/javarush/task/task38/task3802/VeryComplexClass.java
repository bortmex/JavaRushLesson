package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        BufferedReader rd = new BufferedReader(new FileReader(new File("123")));
        String inputLine = null;
        while((inputLine = rd.readLine()) != null)
        System.out.println(inputLine);
    }

    public static void main(String[] args) throws Exception {
    }
}
