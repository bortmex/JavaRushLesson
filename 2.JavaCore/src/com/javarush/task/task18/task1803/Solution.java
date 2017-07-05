package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine()); //C:\Users\alexa\Desktop\231.txt
        Map<Integer,Integer> maps = new HashMap<>();
        while (fileInputStream.available()>0){
            int number = fileInputStream.read();

            try {
                maps.put(number,maps.get(number)+1);
            }catch (NullPointerException e){
                maps.put(number,1);
            }
        };
        fileInputStream.close();

        maps = sortByValue(maps);
        int value = -1;
        String finish = "";
        for (Map.Entry<Integer,Integer> map: maps.entrySet()){
            if(value!=-1){
                if(value!=map.getValue()) break;
            }
            finish += map.getKey() + " ";
            value = map.getValue();
        }
        System.out.println(finish.trim());
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