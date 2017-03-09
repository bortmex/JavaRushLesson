package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        ArrayList<Integer> listInt = new ArrayList<>();
        for (int i = 0; i < alphabet.size(); i++) {
            listInt.add(0);
        }

        for (String text:list) {
            char[] arrChar = text.toCharArray();
            for (int i = 0; i < arrChar.length; i++) {
                try {
                    listInt.set(abc.indexOf(arrChar[i]+""),listInt.get(abc.indexOf(arrChar[i]+""))+1);
                }catch (ArrayIndexOutOfBoundsException ignored){
                }
            }
        }

        for (int i = 0; i < listInt.size(); i++) {
            System.out.println(alphabet.get(i) + " " + listInt.get(i));
        }
    }

}
