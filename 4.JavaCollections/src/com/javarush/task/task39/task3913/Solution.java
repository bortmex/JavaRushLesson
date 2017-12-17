package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        Date date = new Date();
        MyLogParser logParser = new MyLogParser(Paths.get("D:\\JAVAPROJECT\\JavaRushTasksReiteration\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task39\\task3913\\logs"));
        System.out.println(logParser.getNumberOfUniqueIPs(null, null));
        System.out.println(logParser.getIPsForUser("Amigo",null, null));
    }
}