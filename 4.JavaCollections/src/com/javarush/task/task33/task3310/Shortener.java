package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

public class Shortener {

    private Long lastId = 0L;
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    public synchronized Long getId(String string){

        try {
            if(storageStrategy.containsValue(string))return storageStrategy.getKey(string);
            else {
                lastId++;
                storageStrategy.put(lastId,string);
                return lastId;
            }
        } catch (Exception  e) {
            e.printStackTrace();
        }
        return 0L;
    }

    public synchronized String getString(Long id){
        try {
            return storageStrategy.getValue(id);
        } catch (Exception  e) {
            e.printStackTrace();
        }
        return null;
    }

}
