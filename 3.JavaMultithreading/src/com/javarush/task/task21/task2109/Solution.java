package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;
        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }
        public int getI() {
            return i;
        }
        public int getJ() {
            return j;
        }
        @Override
        protected A clone() throws CloneNotSupportedException {
            return new A(this.getI(),this.getJ());
        }
        @Override
        public String toString() {
            return "A{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }
    public static class B extends A {
        private String name;
        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }
        public String getName() {
            return name;
        }
        @Override
        protected B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
        @Override
        public String toString() {
            return "B{" +
                    super.toString() +
                    " name='" + name + '\'' +
                    '}';
        }
    }
    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }
        @Override
        protected C clone() throws CloneNotSupportedException {
            return new C(this.getI(),this.getJ(),this.getName());
        }
        @Override
        public String toString() {
            return super.toString();
        }
    }
    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A(1,2);
        A a1 = a.clone();
        B b = null;
        B b1 = null;
        try {
            b = new B(12,23,"Бэшка");
            b1 = b.clone();
        }catch (CloneNotSupportedException e){
            System.out.println("Объект B нельзя клонировать");
        }
        C c = new C(24,48,"Сэшка");
        C c1 = c.clone();
        ABC abc = new ABC(a,a1,b,b1,c,c1);
        abc.printLn();
    }
}