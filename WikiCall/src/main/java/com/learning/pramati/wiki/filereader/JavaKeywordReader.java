package com.learning.pramati.wiki.filereader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;
/*
*
@author Virendra
*
*/

public class JavaKeywordReader implements MyFileReader {
    private static final Logger LOGGER = Logger.getLogger(JavaKeywordReader.class.getName());
    @Override
    public List<String> read(String path) {

        try {

            List<String> list=new ArrayList<String>((int)(Files.lines(Paths.get(path)).count()*1.75));
            Files.lines(Paths.get(path)).skip(1).forEach(line->{
                String [] arr=line.split(",");
                for (String str: arr) {
                    if(!str.isEmpty())
                    {
                        list.add(str);
                    }
                }

            });
            return list;
        } catch (IOException e) {
            LOGGER.info("EXCEPTION:: "+e.getMessage());
        }
        return null;

    }
}
