package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader readerFile = new FileReader(reader.readLine());
        reader.close();
        BufferedReader bufferedReader = new BufferedReader(readerFile);
        String fileStr = "";
        while (bufferedReader.ready()) {
            fileStr += bufferedReader.readLine();
        }
        readerFile.close();
        String starTeg = "<" + args[0];
        String endTeg = "</" + args[0] + ">";
        Map<Integer, Integer> mapTeg = new HashMap<>();
        Pattern pstart = Pattern.compile(starTeg);
        Pattern pend = Pattern.compile(endTeg);
        Matcher mstart = pstart.matcher(fileStr);
        Matcher mend = pend.matcher(fileStr);
        while (mstart.find()) {
            mapTeg.put(mstart.start(), 0);
        }
        while (mend.find()) {
/* System.out.println("Текст: "+fileStr.substring(mend.start(),mend.end()));
System.out.println("Начальная позиция вхождения: "+mend.start());
System.out.println("Конечная позиция вхождения: "+mend.end());*/
            mapTeg.put(mend.end() - 1, 1);
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(mapTeg);
        List<String> listExit = new ArrayList<>();
        while (treeMap.size()>0){
            listExit.add(getText(fileStr,treeMap));
        }
        for (String text:listExit){
            System.out.println(text);
        }
    }
    public static String getText(String text, Map<Integer, Integer> map) {
        int index = 0;
        Iterator iterator = map.entrySet().iterator();
        Map.Entry entry1 = (Map.Entry) iterator.next();
        Map.Entry entry2 = null;
        while (iterator.hasNext()) {
            entry2 = (Map.Entry) iterator.next();
            if ((int) entry2.getValue() == 1) {
                if(index==0){
                    break;}
                else index--;
            } else index++;
        }
        String exitText = text.substring((Integer)entry1.getKey(),(Integer)entry2.getKey()+1);
        map.remove(entry1.getKey());
        map.remove(entry2.getKey());
        return exitText;
    }
}