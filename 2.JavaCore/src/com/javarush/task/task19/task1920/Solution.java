package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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
        listStr=sortByValue(listStr);
        double max = listStr.entrySet().iterator().next().getValue();
        for(Map.Entry<String, Double> personDat : listStr.entrySet()){
            if(max==personDat.getValue()) {
                System.out.println(personDat.getKey());
                max=personDat.getValue();
            }
        }

    }

    public static <K, V extends Comparable<? super V>> Map<K, V>
    sortByValue(Map<K, V> map )
    {
        List<Map.Entry<K, V>> list =
                new LinkedList<>(map.entrySet());
        Collections.sort( list, new Comparator<Map.Entry<K, V>>()
        {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2)
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list)
        {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
