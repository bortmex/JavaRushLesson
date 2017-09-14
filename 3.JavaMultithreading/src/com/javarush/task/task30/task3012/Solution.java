package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        class ConvertThree extends RecursiveTask<String> {
            private int x;

            public ConvertThree(int x) {
                this.x = x;
            }

            @Override
            protected String compute() {

                int a = x / 3;
                int b = x % 3;

                String result = String.valueOf(b);

                if (a > 0) {
                    ConvertThree convertThree;
                    if (b == 2) convertThree = new ConvertThree(a + 1);
                    else convertThree = new ConvertThree(a);
                    convertThree.fork();
                    return convertThree.join() + result;
                }

                return result;
            }
        }

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        String result2 = forkJoinPool.invoke(new ConvertThree(number));
        System.out.println(number + " = "+chisloThreeConverStringDesimal(Integer.parseInt(result2)));

    }

    public String chisloThreeConverStringDesimal(int chislo) {
        int[] arr = new int[(int) Math.log10(chislo)+1];
        int index = arr.length;
        while (chislo > 0) {
            int d = chislo % 10;
            arr[--index] = d;
            chislo = chislo / 10;
        }

        List<String> list = new ArrayList<>();

        int a = 0;
        if(arr[0]==2){
            list.add("+-");
            a= 1;
        }

        for (int i = a; i < arr.length; i++) {
            if (arr[i] == 2) {
                list.add("-");
            } else if (arr[i] == 1)
                list.add("+");
            else if (arr[i] == 0) {
                list.add("0");
            }
        }

        String result = "";
        for (String text : list) {
            result += text;
        }

        //System.out.println(chisloConverArr(Integer.parseInt(result2)));

        result = new StringBuffer(result).reverse().toString();

        return stringToArray(result);
    }

    public String stringToArray(String text){

        List<Integer> listThree = new ArrayList<>();
        Integer[] array = {1, 3, 9, 27, 81, 243, 729, 2187};
        listThree.addAll(Arrays.asList(array));

        String finalResult = "";
        String localOperatios;

        for (int i = 0; i < text.length(); i++) {
            String textl = text.substring(i,i+1);
            if(textl.equals("-")){
                localOperatios = "-";
            }else if(textl.equals("+")){
                localOperatios = "+";
            }else continue;
            finalResult += " " + localOperatios + " " +listThree.get(i);
        }
        return finalResult;
    }

}