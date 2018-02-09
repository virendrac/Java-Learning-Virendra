package com.learning.pramati.csv;

import com.learning.pramati.property.PropertyReader;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVSplitter implements  Runnable {

    static int index=0;
    List< String> lines;
    static String writeLocation= PropertyReader.getProperty("writeLocation");

    public CSVSplitter(List< String>  lines) {
        this.lines=lines;
    }


    public void run()  {

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
            e.printStackTrace();
        }

    }

}
