package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
/**
 * Created by rogov on 08.09.2017.
 */
/* мой код
public class Solution {
    private static List<File> listFiles = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        File filez = new File(args[0]);
        getListAllFile(filez);

        for (File f : listFiles) {
            if (f.length() > 50) {
                FileUtils.deleteFile(f);
            }
        }

        Comparator<File> comparator = new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Collections.sort(listFiles, comparator);

        File source = new File(args[1]);
        File resuilFile = new File(source.getParent() + "\\allFilesContent.txt"); //resultFileAbsolutePath
        FileUtils.renameFile(source, resuilFile);
        try (FileOutputStream fos = new FileOutputStream(resuilFile)) {

            for (File file : listFiles) {
                FileInputStream fileInputStream = new FileInputStream(file);
                while (fileInputStream.available() > 0) {
                    fos.write(fileInputStream.read());
                }
                fos.write(System.lineSeparator().getBytes());
                fos.flush();

                fileInputStream.close();
            }
        }
    }


    public static void getListAllFile(File path) {

        File[] folderEntries = path.listFiles();
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                getListAllFile(entry);
                continue;
            } else {
                listFiles.add(entry);
            }
        }
    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }
}*/
public class Solution {
    private static ArrayList<File> fileList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
        try (FileOutputStream fileOutputStream = new FileOutputStream(allFilesContent)) {

            fillFileList(path.getPath());
            fileList.sort(new FileNameComparator());

            for (File file : fileList) {
                FileInputStream fileInputStream = new FileInputStream(file);
                while (fileInputStream.available() > 0) {
                    fileOutputStream.write(fileInputStream.read());
                }
                fileOutputStream.write(System.lineSeparator().getBytes());
                fileOutputStream.flush();

                fileInputStream.close();
            }
        }
    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }


    //Рекурсивно пробегаем поддиректории и заполняем список файлов
    private static void fillFileList(String path) {
        File[] files = new File(path).listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                fillFileList(file.getAbsolutePath());
                continue;
            }
            if (file.length() > 50)
                FileUtils.deleteFile(file);
            else
                fileList.add(file);
        }
    }
}

//Компаратор для сравнения
class FileNameComparator implements Comparator<File> {
    public int compare(File first, File second) {
        return first.getName().compareTo(second.getName());
    }
}