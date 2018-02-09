package com.learning.pramati.wiki.filereader.factory;

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



    public static MyFileReader getReader(List<String> collect) {
        MyFileReader reader=null;
        if (collect.get(0).contains("1")){

            reader = new FortuneCompReader();
        }else if(collect.get(0).contains("Keywords")){
            reader = new JavaKeywordReader();
        }else if(collect.get(0).startsWith("A")){

            reader = new LanguageNameReader();
        }

        return reader;
    }
}
