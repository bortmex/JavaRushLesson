package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human grandMotherF = new Human("Анастасия", false, 71);
        Human grandFatherF = new Human("Петр", true, 76);
        Human grandMotherM = new Human("Виктория", false, 68);
        Human grandFatherM = new Human("Дмитрий", true, 71);

        Human mother = new Human("Наташа", false, 45, grandMotherM,grandFatherM);
        Human father = new Human("Виталий", true, 50, grandMotherF,grandFatherF);

        Human children1 = new Human("Костя", true, 22, mother,  father);
        Human children2 = new Human("Анна", false, 18, mother,  father);
        Human children3 = new Human("Тимур", true, 25, mother,  father);

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
        private String name;
        private boolean sex;
        private int age;
        private Human mother;
        private Human father;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human mother, Human father) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.mother = mother;
            this.father = father;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















