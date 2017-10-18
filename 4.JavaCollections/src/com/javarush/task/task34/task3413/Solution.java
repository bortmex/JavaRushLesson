package com.javarush.task.task34.task3413;

/* 
Кеш на основании SoftReference
*/

public class Solution {

    public static void main(String[] args) {
        /*SoftCache cache = new SoftCache();

        for (long i = 0; i < 2_500_000; i++) {
            cache.put(i, new AnyObject(i, null, null));
        }*/
        System.out.println("hello");
        smg();
        System.out.println("bye");
    }

    public static void smg(){
        try {
           while (true){

           }
        }catch (Throwable e){
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
    }
}