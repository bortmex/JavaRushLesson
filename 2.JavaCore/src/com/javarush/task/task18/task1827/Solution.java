package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException, IOException {

        System.out.println((args.length < 4) +" "+ !args[0].equals("-c"));

        if (args.length < 4 || !args[0].equals("-c")) return;
        float price;
        int qty;
        try {
            price = Float.parseFloat(args[args.length - 2]);
            qty = Integer.parseInt(args[args.length - 1]);
        } catch (NumberFormatException e) {
            return;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));  //C:\Users\alexa\Desktop\231.txt  //-c ГальваническийЭлементаль 345.56 666
        String name = reader.readLine();
        FileInputStream inputStream = new FileInputStream(name);
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(inputStream));
        ArrayList<String> listAllStr = new ArrayList<>();
        String statsinfo = null;
        while (((statsinfo=reader1.readLine())!=null)){
            listAllStr.add(statsinfo);
        }
        int maxID = 0;

        for(String str:listAllStr){
            int i = Integer.parseInt(str.substring(0,8).trim());
            if(i>maxID) maxID = i;
        }
        if(++maxID == 99999999) return;
        if(args[0].equals("-c")){
            String productName;
            if (args.length > 4) {
                StringBuffer buf = new StringBuffer();
                for (int i = 1; i < args.length - 2; i++)
                    buf.append(args[i]).append(" ");
                productName = buf.substring(0, buf.length() - 1);
            } else
                productName = args[1];
            String text = String.format("%-8s%-30.30s%-8s%-4s", Integer.toString(maxID), productName, price, qty);
            listAllStr.add(text);
        }
        try (BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name)))) {
            for (String s: listAllStr)
                buf.write(s+"\r\n");
        }
        reader1.close();
        inputStream.close();
        reader.close();
    }
}
