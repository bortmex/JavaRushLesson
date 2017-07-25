package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] sarr = new Solution[2];
        Solution s = new Solution();
        s.innerClasses[0] = s.new InnerClass();
        s.innerClasses[1] = s.new InnerClass();
        Solution s1 = new Solution();
        s1.innerClasses[0] = s1.new InnerClass();
        s1.innerClasses[1] = s1.new InnerClass();
        sarr[0] = s;
        sarr[1] = s1;
        return sarr;
    }

    public static void main(String[] args) {

    }
}
