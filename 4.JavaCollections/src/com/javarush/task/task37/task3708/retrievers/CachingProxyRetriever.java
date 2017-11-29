package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever{
    private OriginalRetriever originalRetriever;
    private LRUCache<Long, Object>  lruCache;

    public CachingProxyRetriever(Storage storage) {
        this.originalRetriever = new OriginalRetriever(storage);
        this.lruCache = new LRUCache<>(16);
    }

    @Override
    public Object retrieve(long id) {
        Object o = lruCache.find(id);
        if( o == null){
            o = originalRetriever.retrieve(id);
            lruCache.set(id, o);
        }
        return o;
    }
}
