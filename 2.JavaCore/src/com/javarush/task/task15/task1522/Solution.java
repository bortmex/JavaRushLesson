package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;/*
Закрепляем Singleton pattern
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();

        if(text.equals(Planet.EARTH)) thePlanet = Earth.getInstance();
        else if(text.equals(Planet.MOON)) thePlanet = Moon.getInstance();
        else if(text.equals(Planet.SUN)) thePlanet = Sun.getInstance();
        else thePlanet = null;
    }
}
