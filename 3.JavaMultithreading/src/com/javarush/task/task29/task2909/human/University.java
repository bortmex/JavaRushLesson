package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class University{

    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student st: students) {
            if(st.getAverageGrade()==averageGrade) return st;
        }

        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        List<Student> str = new ArrayList<>();
        str.addAll(students);
        Comparator<Student> cmp = Comparator.comparingDouble(Student::getAverageGrade);
        return Collections.max(str, cmp);
    }

    public Student getStudentWithMinAverageGrade(){
        List<Student> str = new ArrayList<>();
        str.addAll(students);
        Comparator<Student> cmp = Comparator.comparingDouble(Student::getAverageGrade);
        return Collections.min(str, cmp);
    }
    public void expel(Student student){
        students.remove(student);
    }
}