package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        if (!Files.isDirectory(Paths.get(name))) {
            System.out.println(name + " - не папка");
            return;
        }
        final int[] countPapok = {0};
        final int[] countFiles = {0};
        final int[] countSize = {0};

        Files.walkFileTree(Paths.get(name),new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    countSize[0]+=attrs.size();
                    countFiles[0]++;
                    return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                countPapok[0]++;
                return FileVisitResult.CONTINUE;
            }
        });

        System.out.println("Всего папок - " + (countPapok[0] - 1));
        System.out.println("Всего файлов - " + countFiles[0]);
        System.out.println("Общий размер - " + countSize[0]);
    }
}
