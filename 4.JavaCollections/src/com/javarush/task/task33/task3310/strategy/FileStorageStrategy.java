package com.javarush.task.task33.task3310.strategy;

import java.io.IOException;

public class FileStorageStrategy implements StorageStrategy{

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000L;
    FileBucket[] table =  new FileBucket[DEFAULT_INITIAL_CAPACITY];
    int size;
    long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    long maxBucketSize;

    public FileStorageStrategy(){
        for (int i = 0; i < DEFAULT_INITIAL_CAPACITY; i++) {
            table[i] = new FileBucket();
        }
    }

    public FileBucket[] getTable() {
        return table;
    }

    public void setTable(FileBucket[] table) {
        this.table = table;
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    @Override
    public boolean containsKey(Long key) throws IOException, ClassNotFoundException {
        return getEntry(key)!= null;
    }

    @Override
    public boolean containsValue(String value) throws IOException, ClassNotFoundException {
        if (value == null)
            return false;
        for (FileBucket table : table) {
            for (Entry e = table.getEntry(); e != null; e = e.next)
                if (value.equals(e.value))
                    return true;
        }
        return false;
    }

    @Override
    public void put(Long key, String value) throws IOException, ClassNotFoundException {
        addEntry(hash(key),key,value,indexFor(hash(key),table.length));
    }

    @Override
    public Long getKey(String value) throws IOException, ClassNotFoundException {
        if (value == null)
            return 0L;

        for (FileBucket table : table) {
            for (Entry e = table.getEntry(); e != null; e = e.next)
                if (value.equals(e.value))
                    return e.getKey();
        }
        return null;
    }

    @Override
    public String getValue(Long key) throws IOException, ClassNotFoundException {
        return getEntry(key) == null ? null : getEntry(key).getValue();
    }

    public int hash(Long k) {
        return k.hashCode();
    }

    public int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    public Entry getEntry(Long key) throws IOException, ClassNotFoundException {
        int hash = (key == null) ? 0 : hash((long) key.hashCode());
        for (Entry e = table[indexFor(hash, table.length)].getEntry();
             e != null;
             e = e.next) {
            Object k;
            if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                return e;
        }
        return null;
    }

    public void resize(int newCapacity) {
        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        table = newTable;
    }

    public void transfer(FileBucket[] newTable) {
        FileBucket[] src = table;
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            Entry e = src[j].getEntry();
            if (e != null) {
                src[j] = null;
                do {
                    Entry next = e.next;
                    int i = indexFor(e.hash, newCapacity);
                    e.next = newTable[i].getEntry();
                    newTable[i].putEntry(e);
                    e = next;
                } while (e != null);
            }
        }
    }

    public void addEntry(int hash, Long key, String value, int bucketIndex) throws IOException, ClassNotFoundException {
        if(table[bucketIndex].getFileSize()>bucketSizeLimit){
            resize(2 * table.length);
            hash = hash(key);
            bucketIndex = indexFor(hash, table.length);
        }
        createEntry(hash,key,value,bucketIndex);
    }

    public void createEntry(int hash, Long key, String value, int bucketIndex) throws IOException, ClassNotFoundException {
        Entry e = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, e));
        size++;
    }
}
