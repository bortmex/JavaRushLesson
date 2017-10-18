package com.javarush.task.task32.task3202;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) {
        StringWriter writer = new StringWriter();

        if(is == null) return new StringWriter();
        StringBuilder textBuilder = new StringBuilder();

            Reader reader = new BufferedReader(new InputStreamReader
                    (is, Charset.forName(StandardCharsets.UTF_8.name())));
            int c = 0;
        try {
            while ((c = reader.read()) != -1) {
                textBuilder.append((char) c);
            }
        } catch (IOException | NullPointerException e) {
            return new StringWriter();
        }
        writer.write(textBuilder.toString());
        return writer;
    }
}