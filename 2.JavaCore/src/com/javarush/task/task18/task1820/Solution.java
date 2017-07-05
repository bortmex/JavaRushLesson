package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        FileReader fileReader = new FileReader(name1);
        FileWriter fileWriter = new FileWriter(name2);

        int c;
        String mytext="";
        while ((c=fileReader.read())!=-1){
            mytext+=(char)c;
        }

        String[] arrstrnumber = mytext.split(" ");
        int[] arrintnumber = new int[arrstrnumber.length];

        for (int i = 0; i < arrstrnumber.length; i++) {
            double number = Double.parseDouble(arrstrnumber[i]);
            arrintnumber[i]= number>0 ? (int)new BigDecimal(number).setScale(0, RoundingMode.HALF_UP).doubleValue() :
                    (int) new BigDecimal(number).setScale(0, RoundingMode.HALF_DOWN).doubleValue();
        }

        String text = "";
        for (int i = 0; i < arrintnumber.length; i++) {
            text+=arrintnumber[i] + " ";
        }
        text=text.trim();

        fileWriter.write(text);
        fileReader.close();
        fileWriter.close();
    }
}
