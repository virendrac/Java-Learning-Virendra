package com.learning.pramati.wiki.filereader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/*
*
@author Virendra
*
*/
public class LanguageNameReader implements MyFileReader {
    private static final Logger LOGGER = Logger.getLogger(LanguageNameReader.class.getName());
    @Override
    public List<String> read(String path) {

        try {
            return Files.lines(Paths.get(path)).collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.info("EXCEPTION:: "+e.getMessage());
        }
        return null;
    }
}
