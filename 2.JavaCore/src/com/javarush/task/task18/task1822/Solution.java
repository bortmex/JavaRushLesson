package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream inputStream = new FileInputStream(name);
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(inputStream));
        Map<Integer,String> map = new HashMap<>();
        String statsinfo;
        Info infounit;
        while ((statsinfo=reader1.readLine())!=null){
            infounit = getOneUnitInfo(statsinfo);
            map.put(infounit.id,infounit.productName + " " + Double.toString(infounit.price) + " " + Integer.toString(infounit.quantity));
        }
        inputStream.close();
        System.out.println(args[0] + " " + map.get(Integer.parseInt(args[0])));
    }
    public static Info getOneUnitInfo(String text){
        Info infoone = new Info();
        String[] arrinfo = text.split(" ");
        infoone.id = Integer.parseInt(arrinfo[0]);
        infoone.productName = text.substring(arrinfo[0].length()+1,text.length() - (2 + arrinfo[arrinfo.length-2].length()+arrinfo[arrinfo.length-1].length()));
        infoone.price = Double.parseDouble(arrinfo[arrinfo.length-2]);
        infoone.quantity = Integer.parseInt(arrinfo[arrinfo.length-1]);
        return infoone;
    }
}
