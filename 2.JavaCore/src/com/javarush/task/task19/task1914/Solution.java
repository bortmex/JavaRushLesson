package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        String result = outputStream.toString();

        System.setOut(consoleStream);

        StringBuilder stringBuilder = new StringBuilder(result);
        String resultUpperCase = stringBuilder.toString().replace("\r\n","");

        String[] minus = resultUpperCase.split("-");
        String[] plus = resultUpperCase.split("\\+");
        String[] mults = resultUpperCase.split("\\*");

        int resultOperation = 0;

        if(minus.length==2) resultOperation = Integer.parseInt(minus[0].replaceAll("[^0-9]","")) - Integer.parseInt(minus[1].replaceAll("[^0-9]",""));
        if(plus.length==2) resultOperation = Integer.parseInt(plus[0].replaceAll("[^0-9]","")) + Integer.parseInt(plus[1].replaceAll("[^0-9]",""));
        if(mults.length==2) resultOperation = Integer.parseInt(mults[0].replaceAll("[^0-9]","")) * Integer.parseInt(mults[1].replaceAll("[^0-9]",""));

        System.out.println(resultUpperCase + resultOperation);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

