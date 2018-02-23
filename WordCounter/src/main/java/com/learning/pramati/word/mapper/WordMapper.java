package com.learning.pramati.word.mapper;


import com.learning.pramati.word.MappingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;


public class WordMapper {

    private static final Logger LOGGER = Logger.getLogger(WordMapper.class.getName());

    private Map<String, Integer> wordMap;
    private Set<String> wordSet;

    public WordMapper() {
        this.wordMap = new HashMap<String,Integer>();
    }

    public Map<String, Integer> getWordMap() {
        return wordMap;
    }

    public String generateMap() {
        MappingService service=new MappingService();
        service.executeMapping();
        wordMap=service.getMappedData();

        LOGGER.info(wordMap.toString()); // printing the word counts.
        wordSet=wordMap.keySet();
        return "Successfully map generated!";
    }


    public List<String> getFuzzySuggestions(String word) {

        List<String >l=new ArrayList<>();
        for (String key : wordSet) {
            if (key.contains(word)) {
                l.add(key);
            }
        }
        return l;
    }

    public List<String> getPrefixSuggestions( String word) {

        List<String >l=new ArrayList<>();
        for (String key : wordSet) {
            if (key.startsWith(word)) {
                l.add(key);
            }
        }
        return l;
    }
}
