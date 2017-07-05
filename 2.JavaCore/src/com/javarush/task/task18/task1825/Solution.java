package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //C:\Users\rogov\Desktop\222.txt.part1
        String name = "";
        boolean go = true;
        File newPart = new File(name);
        while (!(name = reader.readLine()).equals("exit")){
            FileInputStream inputStream = new FileInputStream(name);
            if(go){
                String[] arrfilestr = name.split("\\.");
                String filestr = "";
                for (int i = 0; i < arrfilestr.length-1; i++) {
                    filestr+=arrfilestr[i] + ".";
                }
                filestr=filestr.substring(0,filestr.length()-1);
                newPart = new File(filestr);
                go=false;
            }
            FileOutputStream outputStream = new FileOutputStream(newPart,true);
            byte[] buf = new byte[1000];
            while (inputStream.available()>0){
                int count = inputStream.read(buf);
                outputStream.write(buf,0,count);
            }
            outputStream.close();
            inputStream.close();
        }
    }
    /*
     // Этот код пропускает валидатор
     Scanner scanner = new Scanner(System.in);
        ArrayList<String> parts = new ArrayList<String>();
        FileInputStream fileInputStream = null;
        String nextFileName = null;
        //Читаем файлы пока не "end"
        while (true) {
            if ("end".equals(nextFileName = scanner.nextLine())) break;
            else parts.add(nextFileName);
        }
        scanner.close();
        //Сортируем коллекцию
        Collections.sort(parts, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
        //Выходной файловый поток
        String outputFileName = parts.get(0).split(".part")[0];
        FileOutputStream fileOutputStream = new FileOutputStream(outputFileName);
        //Сливаем файлы
        for (String partsFileNames : parts) {
            fileInputStream = new FileInputStream(partsFileNames);
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            fileOutputStream.write(buffer);
            fileInputStream.close();
        }
        fileOutputStream.close();
        System.out.println("Объединение файлов выполнено!");
    }*/
}
