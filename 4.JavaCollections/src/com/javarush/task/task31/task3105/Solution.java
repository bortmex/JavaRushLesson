package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution{ //C:\Users\alexa\Desktop\Aku-Mu-rus1\qewqw.txt C:\Users\alexa\Desktop\Chap.zip
    public static void main(String[] args) throws IOException {
      /* мое решение
        File zipFile = new File(args[1]);
        File tempFile = File.createTempFile("zip", "tmp");
        File newFile = new File(args[0]);

        byte[] buffer = new byte[8192];
        int readed;

        ZipOutputStream zipOutputStream = new ZipOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(tempFile)));

        try (ZipInputStream zip = new ZipInputStream(new FileInputStream(args[1]))) {
            ZipEntry entry;
            while ((entry = zip.getNextEntry()) != null) {
                ZipEntry newEntry = new ZipEntry(entry);
                zipOutputStream.putNextEntry(newEntry);
                while ((readed = zip.read(buffer)) > 0) {
                    zipOutputStream.write(buffer, 0, readed);
                }
                zipOutputStream.closeEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream fileInputStream = new FileInputStream(newFile)) {
            ZipEntry newEntry1 = new ZipEntry("new\\" + newFile.getName());

            zipOutputStream.putNextEntry(newEntry1);

            while ((readed = fileInputStream.read(buffer)) > 0) {
                zipOutputStream.write(buffer, 0, readed);
            }
            zipOutputStream.closeEntry();
        }

        zipOutputStream.close();

        if (zipFile.exists()) {
            zipFile.delete();
        }

        tempFile.renameTo(zipFile);
*/

            String fileName = args[0];
            String zipFileName = args[1];
            File file = new File(fileName);

            Map<String, ByteArrayOutputStream> archivedFiles = new HashMap<>();
            try (ZipInputStream zipReader = new ZipInputStream(new FileInputStream(zipFileName))) {
                ZipEntry entry;
                while ((entry = zipReader.getNextEntry()) != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int count = 0;
                    while ((count = zipReader.read(buffer)) != -1)
                        byteArrayOutputStream.write(buffer, 0, count);

                    archivedFiles.put(entry.getName(), byteArrayOutputStream);
                }
            }

            try (ZipOutputStream zipWriter = new ZipOutputStream(new FileOutputStream(zipFileName))) {
                for (Map.Entry<String, ByteArrayOutputStream> pair : archivedFiles.entrySet()) {
                    if (pair.getKey().substring(pair.getKey().lastIndexOf("/") + 1).equals(file.getName())) continue;
                    zipWriter.putNextEntry(new ZipEntry(pair.getKey()));
                    zipWriter.write(pair.getValue().toByteArray());
                }

                ZipEntry zipEntry = new ZipEntry("new/" + file.getName());
                zipWriter.putNextEntry(zipEntry);
                Files.copy(file.toPath(), zipWriter);

        }
    }
}