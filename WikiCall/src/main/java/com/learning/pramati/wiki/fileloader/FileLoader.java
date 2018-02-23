package com.learning.pramati.wiki.fileloader;

import com.learning.pramati.wiki.filereader.MyFileReader;
import com.learning.pramati.wiki.filereader.factory.MyFileReaderFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileLoader {
    private static final Logger LOGGER = Logger.getLogger(FileLoader.class.getName());

    private List<String> keywords;
    private String path;
    Stream<String> lines;

    public FileLoader(String path) {
        try{
            this.path = path;
            keywords=new ArrayList<String>((int) (Files.lines(Paths.get(path)).count()*1.75));

        } catch (IOException e) {
            LOGGER.info("EXCEPTION:: "+e.getMessage());
        }

    }

    public List<String> read() throws Exception {
        try {
            MyFileReader reader=MyFileReaderFactory.getReader(Files.lines(Paths.get(path)).limit(1).collect(Collectors.toList()));
            if(reader!=null){
                return this.keywords= reader.read(path);
            }else {
                throw new Exception("No reader found for the given file format!");
            }

        } catch (IOException e) {
            LOGGER.info("EXCEPTION:: "+e.getMessage());
        }
        return null;
    }
}
