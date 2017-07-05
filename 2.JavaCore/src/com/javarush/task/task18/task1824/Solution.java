package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String name = "";
            try {
                name = reader.readLine();
                File file = new File(name);
                FileInputStream fis = new FileInputStream(file);
                fis.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println(name);
                break;
            }}
    }
}
