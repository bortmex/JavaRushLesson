package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandMotherName = reader.readLine();
        Cat catGrandMother = new Cat(grandMotherName);

        String grandFatherName = reader.readLine();
        Cat catFatherMother = new Cat(grandFatherName);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName, catGrandMother, null);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, null, catFatherMother);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catFather, catMother);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catFather, catMother);

        System.out.println(catGrandMother);
        System.out.println(catFatherMother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat father;
        private Cat mother;

        Cat(String name) {
            this.name = name;
        }

        public Cat(String name, Cat father, Cat mother) {
            this.name = name;
            this.father = father;
            this.mother = mother;
        }

        @Override
        public String toString() {

            String mother = "";
            String father = "";

            mother = this.mother==null ? ", no mother" : ", mother is " + this.mother.name;
            father = this.father==null ? ", no father" : ", father is " + this.father.name;

            return "Cat name is " + name + mother + father;
        }
    }

}
