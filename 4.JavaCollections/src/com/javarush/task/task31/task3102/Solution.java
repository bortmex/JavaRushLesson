package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File file = new File(root);
        List<String> list = new ArrayList<>();
        Queue<File> queue = new PriorityQueue<>();

        Collections.addAll(queue,file.listFiles());

        while (!queue.isEmpty()){
            File file1 = queue.remove();

            if(file1.isDirectory()) Collections.addAll(queue, file1.listFiles());
            else list.add(file1.getAbsolutePath());
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        for (String t:getFileTree("C:\\Users\\rogov\\Desktop\\filesJobe")) {
            System.out.println(t);
        }
    }
}