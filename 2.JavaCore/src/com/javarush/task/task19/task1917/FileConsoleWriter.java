package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.*;

public class FileConsoleWriter {

    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        fileWriter = new FileWriter(fd);
    }

    public static void main(String[] args) throws IOException {

    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        this.fileWriter.write(cbuf,off,len);
        System.out.println(String.valueOf(cbuf).substring(off,off+len));
    }
    public void write(int c) throws IOException {
        this.fileWriter.write(c);
        System.out.println(c);
    }
    public void write(String str) throws IOException {
        this.fileWriter.write(str);
        System.out.println(str);
    }
    public void write(String str, int off, int len) throws IOException {
        this.fileWriter.write(str,off,len);
        System.out.println(str.substring(off,off+len));
    }

    public void flush() throws IOException {
        this.fileWriter.flush();
    }
    public void write(char[] cbuf) throws IOException {
        this.fileWriter.write(cbuf);
        System.out.println(cbuf);
    }
    public void close() throws IOException {
        this.fileWriter.close();
    }
}