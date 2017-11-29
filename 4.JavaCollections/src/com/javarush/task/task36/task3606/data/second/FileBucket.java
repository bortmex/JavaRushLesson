package com.javarush.task.task36.task3606.data.second;

import com.javarush.task.task33.task3310.strategy.Entry;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    Path path;

    public FileBucket() {
        try {
            this.path = Files.createTempFile(null,null);
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize(){
        return path.toFile().length();
    }

    public void putEntry(Entry entry){
        byte data[] = entry.getValue().getBytes();
        try (OutputStream outputStream = Files.newOutputStream(path)) {
            outputStream.write(data);
        } catch (IOException e) {
            System.err.println(e);
        }

    }
    public Entry getEntry(){
        Entry entry = null;

        if (getFileSize() <= 0)
            return entry;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path))) {
            entry = (Entry) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return entry;
    }
    public void remove(){
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
