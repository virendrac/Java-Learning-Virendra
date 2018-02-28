package com.learning.pramati.csv;

import com.learning.pramati.property.PropertyReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.io.File;


/*
@author Virendra

This class is to write the lines provided by the reader class  on physical location.

 */
public class CSVSplitter implements  Runnable {

    private static final Logger LOGGER = Logger.getLogger(CSVReader.class.getName());

    static int index=0;
    List< String> lines;
    static File baseDir=new File(PropertyReader.getInstance().getProperty(CommonProperties.WRITELOCATION));

    public CSVSplitter(List< String>  lines) {
        this.lines=lines;
    }


    public void run()  {

        LOGGER.info(Thread.currentThread().getName() +" Enter run() :: " +new Date());

        int i = index;
        synchronized ((Object) index) {
            index++;
        }

        if(baseDir !=null && baseDir.exists() && baseDir.canWrite()){
            try {

                BufferedWriter writer = null;
                File f=new File(baseDir.getAbsolutePath()+"/File" + i + ".txt");

                if(!f.exists())
                    f.createNewFile();

                if(f.canWrite()) {
                    Path file = Paths.get(f.getAbsolutePath());

                    writer = Files.newBufferedWriter(file);

                    writer.write(lines.toString());
                    writer.flush();
                }else{
                    LOGGER.info("Permission to write the file doesn't exist. File : "+f.getAbsolutePath());
                }
            } catch (IOException e) {
                LOGGER.info(" Exception:: " + e.getStackTrace());
            }
        }else{
            LOGGER.info(" Given path is not a valid write location. Path:  " + baseDir.getAbsolutePath() + "\n");
        }
        LOGGER.info(Thread.currentThread().getName() +" Exit run() :: " +new Date());


    }

}
