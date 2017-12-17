package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        long allTime = 0;
        for (String str:strings) {
            long start = System.currentTimeMillis();
            ids.add(shortener.getId(str));
            allTime+=System.currentTimeMillis() - start;
        }

        return allTime;
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        long allTime = 0;
        for (Long lo:ids) {
            long start = System.currentTimeMillis();
            strings.add(shortener.getString(lo));
            allTime+=System.currentTimeMillis() - start;
        }

        return allTime;
    }

    @Test
    public void testHashMapStorage(){
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>();

        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        long time1 = getTimeForGettingIds(shortener1,origStrings,new HashSet<>());
        long time2 = getTimeForGettingIds(shortener2,origStrings,new HashSet<>());

        Assert.assertTrue(time1>time2);

        Set<Long> origLongs = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            origLongs.add((long) (Math.random()*10));
        }

        long time3 = getTimeForGettingStrings(shortener1,origLongs,new HashSet<>());
        long time4 = getTimeForGettingStrings(shortener2,origLongs,new HashSet<>());

        Assert.assertEquals(time3, time4, 30);
    }
}
