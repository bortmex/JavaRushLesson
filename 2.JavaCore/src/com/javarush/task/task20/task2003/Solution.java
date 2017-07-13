package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties prop = new Properties();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        //FileInputStream inputStream = new FileInputStream("C:\\Users\\rogov\\Desktop\\JavaRushHomeWork\\src\\test\\песочница\\papapa\\papapa27\\123.properties");
        reader.close();
        load(inputStream);
    }

    public void save(OutputStream outputStream) throws Exception {
        prop.clear();
        for (Map.Entry<String, String> pair : properties.entrySet()) {
            prop.put (pair.getKey(), pair.getValue());
        }

        prop.store(outputStream,"");
    }

    public void load(InputStream inputStream) throws Exception {
        prop.load(inputStream);
        Enumeration<?> e = prop.propertyNames();
        while (e.hasMoreElements()) {
            String textKey = (String) e.nextElement();
            properties.put(textKey, prop.getProperty(textKey));
        }
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.fillInPropertiesMap();
        File file = File.createTempFile("date", ".txt");
        solution.load(new FileInputStream(file));

    }
}