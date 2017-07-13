package com.javarush.task.task20.task2011;

import java.io.*;

/*
Externalizable для апартаментов
*/
public class Solution {
    public static class Apartment implements Externalizable {
        private String address;
        private int year;
        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }
        public Apartment(String adr, int y) {
            address = adr;
            year = y;
        }
        /**
         * Prints out the fields. used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address);
            out.writeInt(year);
        }
        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            address = (String) in.readObject();
            year = in.readInt();
        }
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Apartment apartment = new Apartment();
        apartment.address = "МоскоуСити";
        apartment.year = 1990;

        FileOutputStream fileOutputStream = new FileOutputStream("date.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(apartment);
        FileInputStream inputStream = new FileInputStream("date.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Apartment apartment1 = (Apartment) objectInputStream.readObject();

        System.out.println(apartment);
        System.out.println(apartment1);
    }
}