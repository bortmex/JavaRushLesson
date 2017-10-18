package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

/* 
Десериализация JSON объекта
*/
public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {  //C:\Users\alexa\Desktop\12345.txt
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(fileName),clazz);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(convertFromJsonToNormal("C:\\Users\\alexa\\Desktop\\12345.txt", Cat.class));
    }



    public static class Cat
    {
        public Cat() {

        }

        public String name;
        public int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static String readFile(String path){
        StringBuilder text = new StringBuilder();
        try{
            FileInputStream fstream = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null){
                text.append(strLine).append("\\n");
            }
        }catch (IOException e){
            System.out.println("Ошибка");
        }
        return text.toString();
    }
}
