package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {

        switch (args[0]){
            case "-c":
                if(args[2].equals("м")){
                    allPeople.add(Person.createMale(args[1], formatter.parse(args[3])));
                } else  if(args[2].equals("ж")){
                    allPeople.add(Person.createFemale(args[1], formatter.parse(args[3])));
                }
                System.out.println(allPeople.size()-1);
                break;
            case "-u":
                Person person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(args[2]);
                person.setSex(args[3].equals("м") ? Sex.MALE : Sex.FEMALE);
                person.setBirthDay(formatter.parse(args[4]));
                break;
            case "-d":
                Person person2 = allPeople.get(Integer.parseInt(args[1]));
                person2.setName(null);
                person2.setSex(null);
                person2.setBirthDay(null);
                break;
            case "-i":
                Person person1 = allPeople.get(Integer.parseInt(args[1]));
                SimpleDateFormat newDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                String sex = "";
                if(person1.getSex()==Sex.MALE) sex = "м";
                else if(person1.getSex()==Sex.FEMALE) sex="ж";
                System.out.println(person1.getName() + " " + sex + " " + newDateFormat.format(person1.getBirthDay()));
                break;
            default:
                System.out.println("Ввод данных некорректен!");
        }

    }
}
