package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        String name3 = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(name1); ////C:\Users\alexa\Desktop\231.txt
        FileOutputStream fileOutputStream1 = new FileOutputStream(name2);
        FileOutputStream fileOutputStream2 = new FileOutputStream(name3);

        while (fileInputStream.available() > 0) {

            byte[] buf = new byte[1000];
            int count = fileInputStream.read(buf);
            if(count%2==0){
                fileOutputStream1.write(buf, 0, count / 2 );
                fileOutputStream2.write(buf, count / 2, count - count/2);
        }else {
                fileOutputStream1.write(buf, 0, count / 2 +1);
                fileOutputStream2.write(buf, count / 2+1, count - count/2 -1);
            }
        }
        fileInputStream.close();
        fileOutputStream1.close();
        fileOutputStream2.close();
    }
}
