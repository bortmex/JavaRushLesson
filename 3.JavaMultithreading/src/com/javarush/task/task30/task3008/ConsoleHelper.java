package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by alexa on 15.08.2017.
 */
public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString(){
        String text = "";
        label:
        try {
            text = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            text = readString();
        }
        return text;
    }

    public static int readInt(){
        int number = 0;
        try {
            number = Integer.parseInt(readString());
        }catch (NumberFormatException e){
            System.out.println("Произошла ошибка\n" +
                    "при попытке ввода числа. Попробуйте еще раз.");
            number = readInt();
        }
        return number;
    }

    public static void main(String[] args) {
        String name = readString();
    }
}
