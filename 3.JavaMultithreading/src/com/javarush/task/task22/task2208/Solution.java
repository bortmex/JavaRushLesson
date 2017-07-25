package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> mapss = new HashMap<>();
        mapss.put("name","Ivanov");
        mapss.put("country","Ukraine");
        mapss.put("city","Kiev");
        mapss.put("age",null);
        System.out.println(getQuery(mapss));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> mapa:params.entrySet()){
            if(mapa.getValue()!=null){
                if (stringBuilder.toString().equals(""))
                    stringBuilder.append(mapa.getKey()).append(" = '").append(mapa.getValue()).append("'");
                else
                    stringBuilder.append(" and ").append(mapa.getKey()).append(" = '").append(mapa.getValue()).append("'");
            }
        }
        return stringBuilder.toString();
    }
}
