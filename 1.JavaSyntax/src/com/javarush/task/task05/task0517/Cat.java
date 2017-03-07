package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    private String name;
    private int age;
    private int weight;
    private String color;
    private String address;

    public Cat(String name) {
        this.name = name;
        this.age = 12;
        this.weight = 12;
        this.color = "red";
    }

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = "red";
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = 10;
        this.color = "red";
    }

    public Cat(int weight, String color) {
        this.age = 12;
        this.weight = weight;
        this.color = color;
    }

    public Cat(int weight, String color, String address) {
        this.age = 12;
        this.weight = weight;
        this.color = color;
        this.address = address;
    }

    public static void main(String[] args) {

    }
}
