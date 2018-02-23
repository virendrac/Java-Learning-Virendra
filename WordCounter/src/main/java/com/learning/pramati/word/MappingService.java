package com.learning.pramati.word;


import com.learning.pramati.word.counter.WordCounter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.logging.Logger;

/*
*
@author Virendra
*
*/
public class MappingService {

    private static final Logger LOGGER = Logger.getLogger(MappingService.class.getName());
    public MappingService(){
    }

    public void  executeMapping(){
        List<String> files= FileFinder.filePathFinder();

        ScheduledThreadPoolExecutor executorService = new ScheduledThreadPoolExecutor(10);

        List<Future<Map<String,Integer>>> future=new ArrayList<>();

        files.forEach(file->
        {
            executorService.submit(new WordCounter(file));
        });

        while(!executorService.getQueue().isEmpty()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                LOGGER.info("EXCEPTION:: "+e.getMessage());
            }
        }
        executorService.shutdown();
    }

    public Map<String,Integer> getMappedData(){

        return WordCounter.retMap;
    }

}
