package com.javarush.task.task20.task2006;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Как сериализовать?
*/
public class Solution{
    public static class Human implements Serializable{
        public String name;
        public List<Asset> assets = new ArrayList<>();
        public Human() {
        }
        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
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
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Human human = new Human();
        human.name = "Вася";
        human.assets.add(new Asset("карбюратор"));
        human.assets.add(new Asset("каноэ"));
        FileOutputStream outputStream = new FileOutputStream("human.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(human);
        objectOutputStream.close();
        outputStream.close();
        FileInputStream inputStream = new FileInputStream("human.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Object object = objectInputStream.readObject();
        objectInputStream.close();
        inputStream.close();
        Human human1 = (Human) object;
        System.out.println(human.equals(human1));
    }
}
