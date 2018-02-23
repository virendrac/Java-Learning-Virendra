package com.learning.pramati.csv;


import com.learning.pramati.property.PropertyReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.stream.Stream;

import java.util.logging.Logger;
/*
@author Virendra

This class is for reading the CSV file and creating splitter threads on it.

 */

public class CSVReader {

    private static final Logger LOGGER = Logger.getLogger(CSVReader.class.getName());

    public void read(String csvFile, int numberOfLinesPerFile){

        try{
            if(csvFile!=null && !csvFile.isEmpty() && Paths.get(csvFile) !=null && numberOfLinesPerFile >0) {
                LOGGER.info("CSVReader.read :: start time " + new Date());
                ExecutorService executorService = new ScheduledThreadPoolExecutor(1);

                Stream<String> lines = Files.lines(Paths.get(csvFile));

                List<String> list = new ArrayList<String>((int) (numberOfLinesPerFile * 1.75));

                lines.forEach(line -> {

                    if (list.size() < numberOfLinesPerFile) {
                        list.add(line);
                    } else {
                        CSVSplitter splitter = new CSVSplitter(new ArrayList<>(list));
                        executorService.submit(splitter);
                        list.clear();
                    }


                });

                executorService.shutdown();
            }
        }catch (FileNotFoundException e){
            LOGGER.info(" Exception:: " + e.getStackTrace());
        } catch (IOException e) {
            LOGGER.info(" Exception:: " + e.getStackTrace());
        }catch (Exception e) {
            LOGGER.info(" Exception:: " + e.getStackTrace());
        }
    }
}
