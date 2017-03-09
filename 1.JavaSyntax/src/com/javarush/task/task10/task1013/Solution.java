package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private boolean sex;
        private int age;
        private String adress;
        private double price;
        private short rts;

        public Human(boolean sex, int age) {
            this.sex = sex;
            this.age = age;
        }

        public Human(boolean sex, int age, String adress, double price) {
            this.sex = sex;
            this.age = age;
            this.adress = adress;
            this.price = price;
        }

        public Human(double price, short rts) {
            this.price = price;
            this.rts = rts;
        }

        public Human(int age, String adress) {
            this.age = age;
            this.adress = adress;
        }

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, boolean sex) {
            this.name = name;
            this.sex = sex;
        }

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, String adress) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.adress = adress;
        }

        public Human(String name, boolean sex, int age, String adress, double price) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.adress = adress;
            this.price = price;
        }

        public Human(String name, boolean sex, int age, String adress, double price, short rts) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.adress = adress;
            this.price = price;
            this.rts = rts;
        }
    }
}
