package com.learning.pramati.csv;

import com.learning.pramati.property.PropertyReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.stream.Stream;


public class CSVReader {

    public static void main(String[] args){
        try {

            ExecutorService executorService = new ScheduledThreadPoolExecutor(1);

            Stream<String> lines = Files.lines(Paths.get(PropertyReader.getProperty("csvFile")));
            final int n=Integer.parseInt(PropertyReader.getProperty("numberOfLinesPerFile"));
            final int countLine = 0;

            List< String> list = new ArrayList<String>((int) (n*1.75));

            lines.forEach(line-> {

                if(list.size()<n){
                    list.add(line);
                }else{
                    CSVSplitter splitter=new CSVSplitter(new ArrayList<>(list));
                    executorService.submit(splitter);
                    list.clear();
                }


            });

            executorService.shutdown();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
