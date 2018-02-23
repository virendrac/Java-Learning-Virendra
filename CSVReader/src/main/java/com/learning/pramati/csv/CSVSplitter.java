package com.learning.pramati.csv;

import com.learning.pramati.property.PropertyReader;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;


/*
@author Virendra

This class is to write the lines provided by the reader class  on physical location.

 */
public class CSVSplitter implements  Runnable {

    private static final Logger LOGGER = Logger.getLogger(CSVReader.class.getName());

    static int index=0;
    List< String> lines;
    static String writeLocation= PropertyReader.getInstance().getProperty(CommonProperties.WRITELOCATION);

    public CSVSplitter(List< String>  lines) {
        this.lines=lines;
    }


    public void run()  {

        LOGGER.info(Thread.currentThread().getName() +" Enter run() :: " +new Date());

        int i = index;
        synchronized ((Object) index) {
            index++;
        }
        try {

            BufferedWriter writer = null;

            writer = Files.newBufferedWriter(Paths.get(writeLocation+"File" + i + ".txt"));

            writer.write(lines.toString());
            writer.flush();

        } catch (IOException e) {
            LOGGER.info(" Exception:: " + e.getStackTrace());
        }
        LOGGER.info(Thread.currentThread().getName() +" Exit run() :: " +new Date());

    }

}
