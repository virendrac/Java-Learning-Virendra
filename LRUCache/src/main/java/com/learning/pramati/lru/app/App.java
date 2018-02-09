package com.learning.pramati.lru.app;

import com.learning.pramati.property.PropertyReader;
import com.learning.pramati.lru.data.cache.LRUCache;

/*
@author Virendra

This class is for imlementing an example of LRU cache

 */
public class App {

    public static void main(String [] args){

        LRUCache<Character> cache=new LRUCache<Character>(Integer.parseInt(PropertyReader.getProperty("lruCacheSize")));

        cache.add(new Character('A'));
        cache.add(new Character('B'));
        cache.add(new Character('C'));

        cache.printCache();

        cache.add(new Character('D'));

        cache.printCache();
        cache.add(new Character('C'));
        cache.printCache();
    }
}
