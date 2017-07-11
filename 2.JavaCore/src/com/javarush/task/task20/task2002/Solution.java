package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static class JavaRush {
        public List<User> users = new ArrayList<>();
        public void save(OutputStream outputStream){
            PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println("Да");
                for(User user: users){
                    printWriter.println(user.getFirstName());
                    printWriter.println(user.getLastName());
                    printWriter.println(user.getBirthDate());
                    printWriter.println(user.isMale());
                    printWriter.println(user.getCountry());
                }
                printWriter.flush();
        }
        public void load(InputStream inputStream) throws IOException, ParseException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            if(bufferedReader.readLine().equals("Да")){
                while (bufferedReader.ready()){
                    User user = new User();
                    user.setFirstName(bufferedReader.readLine());
                    user.setLastName(bufferedReader.readLine());
                    user.setBirthDate(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).parse(bufferedReader.readLine()));
                    user.setMale(bufferedReader.readLine().equals("true"));
                    String country = bufferedReader.readLine();
                    User.Country count = null;
                    if(country.equals("RUSSIA")) count = User.Country.RUSSIA;
                    else if(country.equals("UKRAINE")) count = User.Country.UKRAINE;
                    else if(country.equals("OTHER")) count = User.Country.OTHER;
                    user.setCountry(count);
                    users.add(user);
                }
            }
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            JavaRush javaRush = (JavaRush) o;
            return users != null ? users.equals(javaRush.users) : javaRush.users == null;
        }
        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
    public static void main(String[] args) throws IOException, ParseException {
        JavaRush javaRush = new JavaRush();
        User user = new User();
        user.setFirstName("Вася");
        user.setLastName("Карась");
        user.setBirthDate(new Date());
        user.setMale(true);
        user.setCountry(User.Country.RUSSIA);
        javaRush.users.add(user);
        File your_file_name = File.createTempFile("2355", ".txt");
        OutputStream outputStream = new FileOutputStream(your_file_name);
        InputStream inputStream = new FileInputStream(your_file_name);
        javaRush.save(outputStream);
        outputStream.flush();
        JavaRush javaRush1 = new JavaRush();
        javaRush1.load(inputStream);
        System.out.println("Равны или нет " + javaRush.equals(javaRush1));
    }
}