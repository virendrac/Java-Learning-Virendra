package com.learning.pramati.wiki;

import com.learning.pramati.property.PropertyReader;
import com.learning.pramati.wiki.caller.WikiCaller;
import com.learning.pramati.wiki.fileloader.FileLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Application {
    public static void main(String[] args) throws Exception {

        FileLoader f1=new FileLoader(PropertyReader.getInstance().getProperty(FileNames.PROGRAMMING_LANGUAGE_FILE));
        FileLoader f2=new FileLoader(PropertyReader.getInstance().getProperty(FileNames.FORTUNE_FILE));
        FileLoader f3=new FileLoader(PropertyReader.getInstance().getProperty(FileNames.JAVA_KEYWORDS_FILE));

        ExecutorService executorService = new ScheduledThreadPoolExecutor(1);
        CompletionService completionService = new ExecutorCompletionService(executorService);
        List<Future<String>> future= new ArrayList<>();

        for(String str: f1.read()) {
            WikiCaller caller = new WikiCaller(str);
            future.add(completionService.submit(caller));
        }
        for(String str: f2.read()) {
            WikiCaller caller = new WikiCaller(str);
            future.add(completionService.submit(caller));
        }
        for(String str: f3.read()) {
            WikiCaller caller = new WikiCaller(str);
            future.add(completionService.submit(caller));
        }

        executorService.shutdown();

    }
}
