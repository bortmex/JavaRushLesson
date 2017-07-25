package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable{
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);
            System.out.println(solution.users);
            System.out.println(clone.users);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }
    protected Map<String, User> users = new LinkedHashMap();
    public static class User implements Cloneable{
        int age;
        String name;
        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
        @Override
        protected User clone() throws CloneNotSupportedException {
            User user = new User(this.age,this.name);
            return user;
        }
        @Override
        public String toString() {
            return "User{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    @Override
    protected Solution clone() throws CloneNotSupportedException {
        Solution solution = new Solution();
        for(Map.Entry<String, User> mapa:this.users.entrySet()){
            solution.users.put(mapa.getKey(),mapa.getValue());
        }
        return solution;
    }
    @Override
    public String toString() {
        return "Solution{" +
                "users=" + users +
                '}';
    }
}
