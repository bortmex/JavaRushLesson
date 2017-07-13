package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String name;
    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.name = fileName;
    }
    public Solution() {
    }
    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(name);
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(name, true);
    }
    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        Solution solution = new Solution("C:\\Users\\rogov\\Desktop\\231.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\rogov\\Desktop\\231.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(solution);
        Solution solution1;
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\rogov\\Desktop\\231.txt"));
        solution1 = (Solution) objectInputStream.readObject();
        System.out.println(solution);
        System.out.println(solution1);
    }
}