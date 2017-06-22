package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException, IOException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName) throws IOException;

        String getFileContent() throws InterruptedException;

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{

        String exitStr = "";
        String fullFileName = "";

        //C:\Users\alexa\Desktop\23.txt
        @Override
        public void setFileName(String fullFileName) throws IOException {
            this.fullFileName=fullFileName;
        }

        @Override
        public String getFileContent(){
            return exitStr.trim();
        }

        @Override
        public void run() {
            File f = new File(fullFileName);
            BufferedReader fin = null;
            try {
                fin = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String line;
            try {
                while ((line = fin.readLine()) != null) exitStr +=line + " ";
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
