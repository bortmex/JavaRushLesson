package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);

        Map<Integer,Integer> maps = new HashMap<>();

        int i = -1;
        while ((i=inputStream.read())!=-1){
            try {
                maps.put(i,maps.get(i)+1);
            }catch (NullPointerException e){
                maps.put(i,1);
            }
        }
        inputStream.close();

        Map<Integer,Integer> treeMap = new TreeMap<>(maps);

        for(Map.Entry<Integer,Integer> map:treeMap.entrySet()){
            System.out.println( (char)(int) map.getKey() + " " + map.getValue());
        }
    }
}