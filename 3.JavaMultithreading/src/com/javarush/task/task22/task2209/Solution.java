package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Составить цепочку слов
*/
//тут надо много всего рефакторить xDDD
public class Solution {

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileReader fileReader = new FileReader(reader.readLine());
             //FileReader fileReader = new FileReader("C:\\Users\\alexa\\Desktop\\231.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader);) {
            while (fileReader.ready()) {
                list.addAll(Arrays.asList(bufferedReader.readLine().split(" ")));
            }
        }
        Map<List<String>, String[][]> maps = new HashMap<>();
        String[][] arrState = getArrState(list);
        int length = list.size()-1;

        maps.put(list, arrState);
        while (length-->0) {
            maps = createMapsAllVersions(maps);
        }
        Set<String> set = showMapsMaps(maps, list.size());

        StringBuilder result = getLine(set.iterator().next().split(" "));
        System.out.println(result.toString());
    }
    //}

    public static StringBuilder getLine(String... words) throws IOException{
        StringBuilder str = new StringBuilder();
        if(words.length==0) return new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            str.append(words[i]).append(" ");
        }
        str.delete(str.length()-1,str.length());
        /*for (String text:set) {
            System.out.println(text);
        }*/
        return str;
    }

    public static boolean containRight(String name1, String name2) {
        return name1.substring(name1.length() - 1, name1.length()).toLowerCase().equals(name2.substring(0, 1).toLowerCase());
    }

    public static boolean containLeft(String name1, String name2) {
        return name1.toLowerCase().substring(0, 1).equals(name2.toLowerCase().substring(name2.length() - 1, name2.length()));
    }

    public static String[][] getArrState(List<String> list) {
        String[][] arrState = new String[list.size()][list.size()];

        for (int i = 0; i < arrState.length; i++) {
            for (int j = 0; j < arrState.length; j++) {
                arrState[i][j] = "";
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (containRight(list.get(i), list.get(j)) && i != j) {
                    arrState[i][j] += "R";
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (containLeft(list.get(i), list.get(j)) && i != j) {
                    arrState[i][j] += "L";
                }
            }
        }
        return arrState;
    }
    public static boolean matrixDetecterClear(String[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j]!="") return false;
            }
        }
        return true;
    }

    public static Set<String> showMapsMaps(Map<List<String>, String[][]> mapz, int length){
        Set<String> set = new TreeSet<String>();
        for (Map.Entry<List<String>, String[][]> mapa:mapz.entrySet()) {
            for (String mapza:mapa.getKey()) {
                if(mapza.split(" ").length==length)
                    set.add(mapza);
            }
        }
        return set;
    }

    public static Map<List<String>, String[][]> createMapsAllVersions(Map<List<String>, String[][]> map) {
        List<List<String>> exitList = new ArrayList<>();
        List<String> list;
        List<String> editlist = new ArrayList<>();
        String[][] matrix;
        Pair pair;
        for (Map.Entry<List<String>, String[][]> entry : map.entrySet()) {
            while ((pair = returnLRON(entry.getValue())) != null) {
                list = entry.getKey();
                editlist.addAll(list);
                matrix = entry.getValue();
                List<String> listext = concactStr(editlist.get(pair.x), editlist.get(pair.y), matrix[pair.x][pair.y]);
                int smechenieY = 0;
                if (pair.x < pair.y) smechenieY = 1;
                editlist.remove(editlist.get(pair.x));
                editlist.remove(editlist.get(pair.y - smechenieY));
                editlist.addAll(listext);
                matrix[pair.x][pair.y] = "";
                exitList.add(new ArrayList<>(editlist));
                editlist.clear();
            }
        }

        Map<List<String>, String[][]> exitMap = new HashMap<>();

        for (List<String> lizt : exitList) {
            exitMap.put(lizt, getArrState(lizt));
        }

        return exitMap;
    }

    public static Pair returnLRON(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (!arr[i][j].equals("")) return new Pair(i, j);
            }
        }
        return null;
    }

    public static void showArr(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j].equals("")) {
                    System.out.print("  ");
                    continue;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static List<String> concactStr(String str1, String str2, String direction) {
        List<String> list = new ArrayList<>();
        StringBuilder sb1 = new StringBuilder(str1);
        StringBuilder sb2 = new StringBuilder(str2);
        if (direction.equals("R")) list.add(sb1.append(" ").append(sb2).toString());
        else if (direction.equals("L")) list.add(sb2.append(" ").append(sb1).toString());
        else if (direction.equals("RL") || direction.equals("LR")) {
            StringBuilder sb3 = new StringBuilder(sb1);
            list.add(sb1.append(" ").append(sb2).toString());
            list.add(sb2.append(" ").append(sb3).toString());

        }
        return list;
    }
}