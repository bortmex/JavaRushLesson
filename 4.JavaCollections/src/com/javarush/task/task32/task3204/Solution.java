package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int countAllSymbols[] = takeThreeNumber(8);
        List<String> symbolsForPassword = new ArrayList<>();
        symbolsForPassword.addAll(new AlphSymbolz().getSymbols(countAllSymbols[0]));
        symbolsForPassword.addAll(new ALPHSymbols().getSymbols(countAllSymbols[1]));
        symbolsForPassword.addAll(new NumberSymbols().getSymbols(countAllSymbols[2]));
        Collections.shuffle(symbolsForPassword);

        for (String symbols:symbolsForPassword) {
            try {
                byteArrayOutputStream.write(symbols.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return byteArrayOutputStream;
    }

    public static int[] takeThreeNumber(int quantity){
        int[] result = new int[3];
        result[0] = (int) (1+(Math.random()*(quantity-3)));
        result[1] = (int) (1+Math.random()*((quantity-2)-result[0]));
        result[2] = (int) (1+Math.random()*((quantity-1)-result[1]-result[0]));
        while (true){
            int expections = result[0] + result[1] + result[2];
            if(expections==8) break;
            result[(int) (Math.random()*2)]+=1;
        }
        return result;
    }
}