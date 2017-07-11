package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {
    public static void main(String[] args) throws IOException, ParseException {

    }
    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;
        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }
        @Override
        public Person read() throws IOException, ParseException {
            String[] arrPersonInfo = fileScanner.nextLine().split(" ");
            SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
            return new Person(arrPersonInfo[1],arrPersonInfo[2],arrPersonInfo[0], formatter.parse(arrPersonInfo[3] + " " + arrPersonInfo[4] + " " +arrPersonInfo[5]));
        }
        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}