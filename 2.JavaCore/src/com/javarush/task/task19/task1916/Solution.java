package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader1 = new FileReader(reader.readLine());
        FileReader fileReader2 = new FileReader(reader.readLine());
        reader.close();
        BufferedReader reader1 = new BufferedReader(fileReader1);
        BufferedReader reader2 = new BufferedReader(fileReader2); //C:\Users\alexa\Desktop\231.txt
        List<String> arr1 = new ArrayList<>();
        List<String> arr2 = new ArrayList<>();
        while (reader1.ready()) {
            arr1.add(reader1.readLine());
        }
        while (reader2.ready()) {
            arr2.add(reader2.readLine());
        }
        fileReader1.close();
        fileReader2.close();
        while (arr1.size() > 0 || arr2.size() > 0) {
            try {
                System.out.println("элмент первого файла: " + arr1.get(0));
                System.out.println("элмент второго файла: " + arr2.get(0));
                System.out.println(arr1.get(0).equals(arr2.get(0)));
                if (arr1.get(0).equals(arr2.get(0))) {
                    lines.add(new LineItem(Type.SAME, arr1.get(0)));
                    arr1.remove(0);
                    arr2.remove(0);
                } else {
                    if (arr1.get(0).equals(arr2.get(1))) {
                        lines.add(new LineItem(Type.ADDED, arr2.get(0)));
                        arr2.remove(arr2.get(0));
                    }else if (arr1.get(1).equals(arr2.get(0))) {
                        lines.add(new LineItem(Type.REMOVED, arr1.get(0)));
                        arr1.remove(arr1.get(0));
                    }
                }
                if(arr2.size()==0&&arr1.size()>0) {lines.add(new LineItem(Type.REMOVED, arr1.get(0))); arr1.remove(0);}
                if(arr1.size()==0&&arr2.size()>0) {lines.add(new LineItem(Type.ADDED, arr2.get(0))); arr2.remove(0);}
            } catch (IndexOutOfBoundsException e) {
            }
        }
        for (LineItem item:lines){
            System.out.println(String.format("Действие: %-8.8s Строка: %s", item.type ,item.line));
        }
    }
    public static enum Type {
        ADDED, //добавлена новая строка
        REMOVED, //удалена строка
        SAME //без изменений
    }
    public static class LineItem {
        public Type type;
        public String line;
        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}