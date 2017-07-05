package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
    public static void main(String[] args) throws InterruptedException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //C:\Users\rogov\Desktop\231.txt
        String text = "";
        while (!(text = reader.readLine()).equals("exit")){
            ReadThread thread = new ReadThread(text);
            thread.start();
            thread.join();
        }
    }
    public static class ReadThread extends Thread {
        private String fileName;
        private Map<Byte,Integer> map = new HashMap<>();
        public ReadThread(String fileName) throws FileNotFoundException {
            this.fileName = fileName;
        }
        @Override
        public void run() {
            byte i = -1;
            try {
                FileInputStream inputStream = new FileInputStream(fileName);
                BufferedReader readerFile = new BufferedReader(new InputStreamReader(inputStream));
                while ((i= (byte) inputStream.read())!=-1){
                    try {
                        map.put(i,map.get(i)+1);
                    }catch (NullPointerException e){
                        map.put(i,1);
                    }
                }
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            map = sortByValue(map);
            resultMap.put(fileName, (int) map.entrySet().iterator().next().getKey());
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
