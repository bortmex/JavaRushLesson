package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
//исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("2355", ".txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);
            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();
            Human somePerson = new Human();
            somePerson.load(inputStream);
            System.out.println(ivanov);
            System.out.println(somePerson);
            System.out.println("равны или нет?: " + somePerson.equals(ivanov));
            inputStream.close();
        } catch (IOException e) {
//e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
//e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();
        public Human() {
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Human human = (Human) o;
            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }
        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }
        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }
        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            if (name != null && !name.isEmpty()) {
                printWriter.println("Да");
                printWriter.println(name);
                    for (int i = 0; i < assets.size(); i++) {
                        printWriter.println(assets.get(i).getName());
                    }
                printWriter.flush();
            }
        }
        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            if (reader.readLine().equals("Да")) {
                name = reader.readLine();
                while (reader.ready()) {
                    assets.add(new Asset(reader.readLine()));
                }
            }
        }
    }
}