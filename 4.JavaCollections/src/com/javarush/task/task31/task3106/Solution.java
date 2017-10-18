package com.javarush.task.task31.task3106;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.*;
import java.util.zip.ZipInputStream;
/* 
Разархивируем файл
*/
public class Solution {
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {

     /*   String fileName = args[0];

        List<File> zipFile = new ArrayList<>();

        for (int i = 1; i < args.length; i++) {
            zipFile.add(new File(args[i]));
        }

        Collections.sort(zipFile);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[BUFFER_SIZE];

        for (int j = 0; j < zipFile.size(); j++) {
            FileInputStream fls = new FileInputStream(zipFile.get(j));
            System.out.println(zipFile.get(j));
            int countt;
            while ((countt = fls.read(buffer))>-1){
                bos.write(buffer, 0 , countt);
                bos.flush();
            }
        }

        ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(bos.toByteArray()));
//bos.close();
        FileOutputStream fosLoc = new FileOutputStream(fileName);

        ZipEntry ze = zis.getNextEntry();
        while(ze!=null){
            int count;
            while((count=zis.read(buffer))>-1){
                fosLoc.write(buffer,0,count);
                fosLoc.flush();
            }ze = zis.getNextEntry();
        }
        zis.close();
        fosLoc.close();*/

        String resultFileName = args[0];
        int filePartCount = args.length - 1;
        String[] fileNamePart = new String[filePartCount];
        for (int i = 0; i < filePartCount; i++) {
            fileNamePart[i] = args[i + 1];
        }
        Arrays.sort(fileNamePart);

        List<FileInputStream> fisList = new ArrayList<>();
        for (int i = 0; i < filePartCount; i++) {
            fisList.add(new FileInputStream(fileNamePart[i]));
        }
        SequenceInputStream seqInStream = new SequenceInputStream(Collections.enumeration(fisList));
        ZipInputStream zipInStream = new ZipInputStream(seqInStream);
        FileOutputStream fileOutStream = new FileOutputStream(resultFileName);
        byte[] buf = new byte[1024 * 1024];
        while (zipInStream.getNextEntry() != null) {
            int count;
            while ((count = zipInStream.read(buf)) != -1) {
                fileOutStream.write(buf, 0, count);
            }
        }
        seqInStream.close();
        zipInStream.close();
        fileOutStream.close();
    }

    class Sort implements Comparator<String> {
        public int compare(String a, String b) {
            int a1 = Integer.parseInt(a.substring(a.lastIndexOf(".") + 1));
            int b1 = Integer.parseInt(b.substring(b.lastIndexOf(".") + 1));
            return a.compareTo(b);
        }
    }
}