package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1name = reader.readLine();
        String file2name = reader.readLine();
        FileInputStream file1 = new FileInputStream(file1name);//"C:\\Users\\alexa\\Desktop\\23.txt");
        FileInputStream file2 = new FileInputStream(file2name);//"C:\\Users\\alexa\\Desktop\\231.txt");
        BufferedReader br1 = new BufferedReader(new InputStreamReader(file1));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(file2));
        String lines;
        while ((lines = br1.readLine()) != null) {
            allLines.add(lines);
        }
        while ((lines = br2.readLine()) != null) {
            forRemoveLines.add(lines);
        }
        Solution solution = new Solution();
        solution.joinData();
    }

    public void joinData() throws CorruptedDataException {
        if(allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();}
    }
}
