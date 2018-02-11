package com.learning.pramati.word.counter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;
/*
*
@author Virendra
*
*/
public class WordCounter  implements Runnable{

    public static Map<String,Integer> retMap=new ConcurrentHashMap<>();
    private String path;

    public WordCounter(String path ) {
        this.path = path;
    }


    @Override
    public void run() {

        try {
            Stream<String> lines = Files.lines(Paths.get(path));
            lines.forEach(line-> {
                String[] arr=line.split(" ");
                for(String str: arr){
                    str=str.replaceAll("[-+.^:,\"]","");
                    retMap.computeIfPresent(str, (k,v) -> v+1);
                    retMap.putIfAbsent(str,1);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
