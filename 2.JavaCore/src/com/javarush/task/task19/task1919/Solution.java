package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader readeRecord = new BufferedReader(fileReader);
        Map<String,Double> listStr = new HashMap<>();
        while (readeRecord.ready()){
            String[] str = readeRecord.readLine().split(" ");
            double dobl = Double.parseDouble(str[1]);
            try {
                listStr.put(str[0], listStr.get(str[0]) + dobl);
            }catch (NullPointerException e){
                listStr.put(str[0], dobl);
            }
        }
        fileReader.close();
        Map<String, Double> treeMap = new TreeMap<>(listStr);
        for(Map.Entry<String, Double> personDat : treeMap.entrySet()){
            System.out.println(personDat.getKey() + " " + personDat.getValue());
        }

    }
}
