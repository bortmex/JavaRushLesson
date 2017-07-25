package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Кроссворд
*/
/*public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        *//*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         *//*
    }*/
public class Solution {

    public static Map<Kompos, OffSet> maps = new HashMap<>();

    static {
        maps.put(Kompos.N, new OffSet(1, 0));
        maps.put(Kompos.NE, new OffSet(1, 1));
        maps.put(Kompos.E, new OffSet(0, 1));
        maps.put(Kompos.SE, new OffSet(-1, 1));
        maps.put(Kompos.S, new OffSet(-1, 0));
        maps.put(Kompos.SW, new OffSet(-1, -1));
        maps.put(Kompos.W, new OffSet(0, -1));
        maps.put(Kompos.NW, new OffSet(1, -1));
    }

    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {
        int[][] crossword = new int[][]{
                {'a', 'd', 'e', 'r', 'l', 'k'},
                {'u', 'p', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'u', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'l', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'a', 'j'},
                {'p', 'o', 'e', 'e', 'j', 'z'}
        };
        System.out.println(detectAllWords(crossword, "home", "same", "zalupa"));
        //System.out.println(detectAllWords(crossword, "daro", "dsnl","du","lred","mgsf","olns","oerek","poeejj"));
/*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
*/
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) throws InterruptedException, CloneNotSupportedException {
        List<Word> list = new ArrayList<>();
        crossword = strategArr(crossword);
        for (int i = 0; i < words.length; i++) {
            char firstLetter = words[i].charAt(0);
            char secondLetter = words[i].charAt(1);
            for (int j = 1; j < crossword.length-1; j++) {
                for (int k = 1; k < crossword[0].length-1; k++) {
                    OffSet startWord = new OffSet(j,k);
                    if(firstLetter==getLetterForWord(startWord,crossword)){
                        List<Kompos> listK = getDirection(startWord,secondLetter,crossword);
                        list.addAll(detectWordForDirection(startWord,listK,words[i],crossword));

                    }
                }
            }
        }

        return list;
    }

    public static char getLetterForWord(OffSet offSet, int[][] crossword) { //берем одну букву
        return (char) crossword[offSet.x][offSet.y];
    }

    public static List<Kompos> getDirection(OffSet offSet, char secondLetter, int[][] crossword) { //находим направление слова
        List<Kompos> list = new ArrayList<>();
        for (Map.Entry<Kompos, OffSet> mapa : maps.entrySet()) {
            char fg = (char) crossword[offSet.x + mapa.getValue().x][offSet.y + mapa.getValue().y];
            if (fg == secondLetter){
                list.add(mapa.getKey());}
        }
        return list;
    }

    public static List<Word> detectWordForDirection(OffSet offSet, List<Kompos> listK, String word, int[][] crossword) throws CloneNotSupportedException {
        List<Word> listWord = new ArrayList<>();
        int setX;
        int setY;
        for (Kompos list:listK) gogo:{
            setX = offSet.x;
            setY = offSet.y;
            for (int i = 0; i < word.length(); i++) {
/*char word1 = word.charAt(i);
char word2 = (char) crossword[setX][setY];
int x = maps.get(list).x;
int y = maps.get(list).y;*/
                if (!(word.charAt(i) == (char) crossword[setX][setY])) break gogo;
                setX += maps.get(list).x;
                setY += maps.get(list).y;
            }
            Word wordEnd = new Word(word);
            wordEnd.setStartPoint(offSet.y-1, offSet.x-1);
            wordEnd.setEndPoint(setY-1-maps.get(list).y,setX-1-maps.get(list).x);
            listWord.add(wordEnd);
        }
        return listWord;
    }

    public static class OffSet { //Смещение
        public int x;
        public int y;

        public OffSet(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void showArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(" " + (char) arr[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] strategArr(int[][] arr) { //по границам нашего поля дополняем нули
        int[][] arrNew = new int[arr.length + 2][arr[0].length + 2];
        for (int i = 0; i < arrNew.length; i++) {
            for (int j = 0; j < arrNew[0].length; j++) {
                if (i == 0 || j == 0 || i == arrNew.length - 1 || j == arrNew[0].length - 1) arrNew[i][j] = 32;
                else arrNew[i][j] = arr[i - 1][j - 1];
            }
        }
        return arrNew;
    }

    public static class Word implements Comparable{
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int
                j) {
            endX = i;
            endY = j;
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Word word = (Word) o;

            if (startX != word.startX) return false;
            if (startY != word.startY) return false;
            if (endX != word.endX) return false;
            if (endY != word.endY) return false;
            return text != null ? text.equals(word.text) : word.text == null;

        }

        @Override
        public int hashCode() {
            int result = text != null ? text.hashCode() : 0;
            result = 31 * result + startX;
            result = 31 * result + startY;
            result = 31 * result + endX;
            result = 31 * result + endY;
            return result;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }

        @Override
        public int compareTo(Object o) {
            return getIntForcomparetor((Word) o);
        }

        public int getIntForcomparetor(Word word){
            return getTextForID(word.toString());
        }

        public int getTextForID(String text){
            int exit = 0;
            for (int i = 0; i < text.length(); i++) {
                exit+=text.charAt(i);
            }
            System.out.println(exit);
            return exit;
        }
    }
}