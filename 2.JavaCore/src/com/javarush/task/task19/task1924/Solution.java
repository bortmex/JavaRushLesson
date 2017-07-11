package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //C:\Users\rogov\Desktop\231.txt
        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();
        BufferedReader fileRead = new BufferedReader(fileReader);
        String str = "";
        while (fileRead.ready()){
            str+=fileRead.readLine() + "\n\r";
        }
        str= str.substring(0,str.length()-2);
        fileRead.close();
        String[] arrstr = str.split(" ");
        for (int i = 0; i < arrstr.length; i++) {
            try {
                if(map.containsKey(Integer.parseInt(arrstr[i]))) arrstr[i] = map.get(Integer.parseInt(arrstr[i]));
            }catch (NumberFormatException e){}
        }
        str = "";
        for (int i = 0; i < arrstr.length; i++) {
            str+=arrstr[i] + " ";
        }
        str=str.trim();
        System.out.println(str);
    }
}