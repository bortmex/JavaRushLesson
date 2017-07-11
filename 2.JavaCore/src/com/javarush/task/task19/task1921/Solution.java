package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();
    public static void main(String[] args) throws IOException, ParseException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader buf = new BufferedReader(fileReader);
        while (buf.ready()){
            String[] arrstr = buf.readLine().split(" ");
            String name = "";
            for (int i = 0; i < arrstr.length-3; i++) {
                name+=arrstr[i]+ " ";
            }
            name = name.trim();
            SimpleDateFormat dateformate = new SimpleDateFormat("dd MM yyyy");
            PEOPLE.add(new Person(name,dateformate.parse(arrstr[arrstr.length-3]+" "+arrstr[arrstr.length-2] + " " + arrstr[arrstr.length-1])));
        }
        fileReader.close();
    }
}