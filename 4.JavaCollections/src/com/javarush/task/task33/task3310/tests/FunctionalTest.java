package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {

    public void testStorage(Shortener shortener){
        String text1 = "текс1";
        String text2 = "текс2";
        String text3 = "текс1";

        Long ident1 = shortener.getId(text1);
        Long ident2 = shortener.getId(text2);
        Long ident3 = shortener.getId(text3);

        Assert.assertNotEquals(ident1,ident2);
        Assert.assertNotEquals(ident3,ident2);

        Assert.assertEquals(ident1,ident3);

        String identStr1 = shortener.getString(ident1);
        String identStr2 = shortener.getString(ident2);
        String identStr3 = shortener.getString(ident3);

        Assert.assertEquals(identStr1,text1);
        Assert.assertEquals(identStr2,text2);
        Assert.assertEquals(identStr3,text3);


    }

    @Test
    public void testHashMapStorageStrategy(){
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(hashMapStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy(){
        OurHashMapStorageStrategy ourHashMapStorageStrategy = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(ourHashMapStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy(){
        FileStorageStrategy fileStorageStrategy = new FileStorageStrategy();
        Shortener shortener = new Shortener(fileStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy(){
        HashBiMapStorageStrategy hashBiMapStorageStrategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(hashBiMapStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy(){
        DualHashBidiMapStorageStrategy dualHashBidiMapStorageStrategy = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(dualHashBidiMapStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy(){
        OurHashBiMapStorageStrategy ourHashBiMapStorageStrategy = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(ourHashBiMapStorageStrategy);
        testStorage(shortener);
    }

}
