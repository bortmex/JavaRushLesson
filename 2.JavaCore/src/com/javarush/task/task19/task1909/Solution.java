package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by rogov on 06.07.2017.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
//"C:\\Users\\rogov\\Desktop\\231.txt"
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            try (FileReader fileReader = new FileReader(reader.readLine())) {
                try (BufferedReader readerstr = new BufferedReader(fileReader)) {
                    FileWriter fileWriter = new FileWriter(reader.readLine());
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        List<String> list = new ArrayList<>();
                        while (readerstr.ready()) {
                            list.add(readerstr.readLine());
                        }
                        for (String text : list) {
                            bufferedWriter.write(text.replace(".", "!") + "\n");
                        }
                    bufferedWriter.close();
                    fileWriter.close();
                }
            }
        }
    }
        /*fileContains("C:\\\\Users\\\\rogov\\\\Desktop\\\\231.txt");
        fileContains("C:\\\\Users\\\\rogov\\\\Desktop\\\\2311.txt");
    }
    public static void fileContains(String text) throws IOException{
        try (FileReader fileReader = new FileReader(text)) {
            try (BufferedReader readerstr = new BufferedReader(fileReader)) {
                System.out.println("File contains ("+text+") :");
                while (readerstr.ready()) {
                    System.out.println(readerstr.readLine());
                }
            }
        }
    }*/
}