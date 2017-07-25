package com.javarush.task.task22.task2212;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
/*      //мой вариант, ниже рабочий вариант...
        return  ((telNumber.matches("^\\+(\\d[\\(\\)\\-]?){11}\\d$") || telNumber.matches("^\\(?(\\d[\\-\\(\\)]?){9}\\d$"))
                && telNumber.matches("[\\+]?\\d*(\\(\\d{3}\\))?\\d*\\-?\\d*\\-?\\d*\\d$"));*/

        if (telNumber == null||telNumber.equals("")) return false;
        Pattern pattern1 = Pattern.compile("\\+\\d*(\\(?\\d{3}\\)?)?\\d+\\-?\\d+\\-?\\d+");
        Pattern pattern2 = Pattern.compile("\\d*(\\(?\\d{3}\\)?)?\\d+\\-?\\d+\\-?\\d+");
        Matcher matcher1 = pattern1.matcher(telNumber);
        Matcher matcher2 = pattern2.matcher(telNumber);
        if (matcher1.matches()){

            if (telNumber.replaceAll("\\D","").length()==12){

                return true;

            }
            return false;
        }
        if (matcher2.matches()) {

            if (telNumber.replaceAll("^\\D", "").length() == 10) {

                return true;

            }
            return false;
        }



        return false;
    }

    public static void main(String[] args) throws IOException {
        checkTelNumber("+380501234567");
        print();
    }

    public static String[] takeAllNumber() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\alexa\\Desktop\\231.txt"));
        String text = "";
        while (reader.ready()){
            text+=reader.readLine() + "\n\r";
        }
        return text.split("\n\r");
    }

    public static void print() throws IOException {
        String[] arr =takeAllNumber();
        System.out.println(String.format("%-20.20s | %-8.8s | %s" ," number","MyDirect","Нужно"));
        System.out.println("---------------------------------------------------------------------");
        for (int i = 0; i < arr.length; i++) {
            String number =arr[i].split(" - ")[0];
            System.out.println(String.format("%20.20s | %-8.8b | %s" ,number,checkTelNumber(number),arr[i].split(" - ")[1]));
        }
    }

    public static boolean takeAllNumberAndCointainHim(String telNumber, int cont){
        boolean yes = true;
        int contNumber = 0;
        for (int i = 0; i < telNumber.length(); i++) {
            if(Pattern.compile("(\\d)").matcher(Character.toString(telNumber.charAt(i))).matches()){
                contNumber++;
            }
        }
        return contNumber==cont;
    }
}
