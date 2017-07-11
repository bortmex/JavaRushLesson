package com.javarush.task.task19.task1908;

import java.io.*;

/**
 * Created by rogov on 06.07.2017.
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader conReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = conReader.readLine();
        String fileName2 = conReader.readLine();
        conReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));

        while (fileReader.ready()) {
            String s = fileReader.readLine();
            String[] digital = s.split("\\s"); //("\\D+") ;

            for (String str : digital)
                try {
                    System.out.println(Integer.parseInt(str));
                    fileWriter.write(str + " ");
                } catch (NumberFormatException e) {
                    continue;
                }
        }
        fileWriter.close();
        fileReader.close();

//"C:\Users\alexa\Desktop\\231.txt"
        //мой код не принял
        /*try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));FileReader fileReader = new FileReader(reader.readLine());BufferedReader readerstr = new BufferedReader(fileReader);) {
                FileWriter fileWriter = new FileWriter(reader.readLine());
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                    String str = "";
                    String sumallnumber = "";
                    while (readerstr.ready()) {
                        sumallnumber += count(readerstr.readLine());
                    }

                    bufferedWriter.write(sumallnumber);

                    bufferedWriter.close();
                    fileWriter.close();
                }

    }
    public static String count(String text) {
        String str = "";
        Pattern p = Pattern.compile("\\D+");
        Matcher m = p.matcher(text);
        while (m.find()) {
            str += text.substring(m.start(), m.end()) + " ";
        }
        return str;*/
    }
}