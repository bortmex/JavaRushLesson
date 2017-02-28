package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double t = Double.parseDouble(reader.readLine());
        trafficLight(t);
    }

    public static void trafficLight(double number){
        double zerofive = number%5.0;
        System.out.println((zerofive>=0.0 && zerofive<3.0) ? "зелёный" : (zerofive>=3.0 && zerofive<4.0) ? "желтый" : ((zerofive%5<5)&&(zerofive%5>=4)) ? "красный" : "");
    }

}