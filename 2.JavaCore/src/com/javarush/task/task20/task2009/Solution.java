package com.javarush.task.task20.task2009;

import java.io.*;

/*
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic {
        public static String staticString = "it's test static string";
        public int i;
        public int j;
        public void save(OutputStream outputStream){
            PrintWriter printStream = new PrintWriter(outputStream);
            if(!this.equals(null)){
                printStream.println("Да");
                printStream.println(staticString);
                printStream.println(i);
                printStream.println(j);
                printStream.flush();
            }
        }
        public void load(InputStream inputStream) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            if(reader.readLine().equals("Да")){
                staticString = reader.readLine();
                i=Integer.parseInt(reader.readLine());
                j=Integer.parseInt(reader.readLine());
            }
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ClassWithStatic that = (ClassWithStatic) o;
            if (i != that.i) return false;
            return j == that.j;
        }
        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
    }
    public static void main(String[] args) throws IOException {
        ClassWithStatic classWithStatic = new ClassWithStatic();
        classWithStatic.i = 25;
        classWithStatic.j = 15;
        File your_file_name = File.createTempFile("2355", ".txt");
        OutputStream outputStream = new FileOutputStream(your_file_name);
        InputStream inputStream = new FileInputStream(your_file_name);
        classWithStatic.save(outputStream);
        outputStream.flush();

        ClassWithStatic classWithStatic1 = new ClassWithStatic();
        classWithStatic1.load(inputStream);
        System.out.println(classWithStatic1.equals(classWithStatic));
    }
}