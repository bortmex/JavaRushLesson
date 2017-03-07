package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        return multExpert(anotherCat.age, anotherCat.weight, anotherCat.strength)>multExpert(this.age, this.weight, this.strength);
    }

    public int multExpert(int age, int weight, int strength){
        return age*2 + weight*5 + strength*10;
    }

    public static void main(String[] args) {

    }
}
