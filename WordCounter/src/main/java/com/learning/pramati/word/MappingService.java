package com.learning.pramati.word;


import com.learning.pramati.word.counter.WordCounter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
/*
*
@author Virendra
*
*/
public class MappingService {

    public MappingService(){
    }

    public void  executeMapping(){
        List<String> files= FileFinder.filePathFinder();

        ExecutorService executorService = new ScheduledThreadPoolExecutor(10);

        List<Future<Map<String,Integer>>> future=new ArrayList<>();

        files.forEach(file->
        {
            executorService.submit(new WordCounter(file));
        });
    }

    public Map<String,Integer> getMappedData(){
        while(true){
            if(Thread.activeCount()>2){
                try {
                    this.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                return WordCounter.retMap;
            }
        }
    }

}
