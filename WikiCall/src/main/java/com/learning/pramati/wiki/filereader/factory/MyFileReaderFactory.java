package com.learning.pramati.wiki.filereader.factory;

import com.learning.pramati.property.PropertyReader;
import com.learning.pramati.wiki.FileNames;
import com.learning.pramati.wiki.filereader.FortuneCompReader;
import com.learning.pramati.wiki.filereader.JavaKeywordReader;
import com.learning.pramati.wiki.filereader.LanguageNameReader;
import com.learning.pramati.wiki.filereader.MyFileReader;


import java.util.List;
/*
*
@author Virendra
*
*/
public class MyFileReaderFactory {



    public static MyFileReader getReader(String path) {
        MyFileReader reader=null;
        if(path!=null && !path.isEmpty()) {
            if (path.equalsIgnoreCase(PropertyReader.getInstance().getProperty(FileNames.FORTUNE_FILE))) {

                reader = new FortuneCompReader();
            } else if (path.equalsIgnoreCase(PropertyReader.getInstance().getProperty(FileNames.JAVA_KEYWORDS_FILE))) {
                reader = new JavaKeywordReader();
            } else if (path.equalsIgnoreCase(PropertyReader.getInstance().getProperty(FileNames.PROGRAMMING_LANGUAGE_FILE))) {

                reader = new LanguageNameReader();
            }
        }

        return reader;
    }
}
