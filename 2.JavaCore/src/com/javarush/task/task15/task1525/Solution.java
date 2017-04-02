package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        BufferedReader  fin = null;
        try {
            fin = new BufferedReader( new InputStreamReader(new FileInputStream(Statics.FILE_NAME),"windows-1251"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String str ;
        try {
            while( (str = fin.readLine() ) != null )
                lines.add(str) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fin.close() ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
