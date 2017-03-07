package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        Human children1 = new Human("Костя", true, 22);
        Human children2 = new Human("Анна", false, 18);
        Human children3 = new Human("Тимур", true, 25);

        ArrayList<Human> children = new ArrayList<>();
        children.add(children1);
        children.add(children2);
        children.add(children3);

        Human mother = new Human("Наташа", false, 45, children);
        Human father = new Human("Виталий", true, 50, children);

        ArrayList<Human> childrenM = new ArrayList<>();
        childrenM.add(mother);
        ArrayList<Human> childrenF = new ArrayList<>();
        childrenF.add(father);

        Human grandMotherF = new Human("Анастасия", false, 71, childrenF);
        Human grandFatherF = new Human("Петр", true, 76, childrenF);
        Human grandMotherM = new Human("Виктория", false, 68, childrenM);
        Human grandFatherM = new Human("Дмитрий", true, 71, childrenM);

        System.out.println(grandFatherF);
        System.out.println(grandFatherM);
        System.out.println(grandMotherF);
        System.out.println(grandMotherM);

        System.out.println(mother);
        System.out.println(father);

        System.out.println(children1);
        System.out.println(children2);
        System.out.println(children3);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
