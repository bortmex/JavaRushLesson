package com.javarush.task.task21.task2106;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* 
Ошибка в equals/hashCode
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution() {
    }

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Solution)) return false;

        if (this == o) return true;
        if (getClass() != o.getClass()) return false;

        Solution solution1 = (Solution) o;

        if (anInt != solution1.anInt) return false;
        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        if (string != null ? !string.equals(solution1.string) : solution1.string != null) return false;
        if (date != null ? !date.equals(solution1.date) : solution1.date != null) return false;
        return solution != null ? solution.equals(solution1.solution) : solution1.solution == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = anInt;
        result = 31 * result + (string != null ? string.hashCode() : 0);
        temp = Double.doubleToLongBits(aDouble);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "anInt=" + anInt +
                ", string='" + string + '\'' +
                ", aDouble=" + aDouble +
                ", date=" + date +
                ", solution=" + solution +
                '}';
    }

    public static void main(String[] args) {
        Set<Solution> s1 = new HashSet<>();
        Set<Solution> s2 = new HashSet<>();
        Solution sse2 =  new Solution();
        Date date = new Date();
        s1.add(new Solution(12,"Mickey",12.23, date,sse2));
        s2.add(new Solution(12,"Mickey",12.23, date ,sse2));
        System.out.println(s1.containsAll(s2));
    }
}
