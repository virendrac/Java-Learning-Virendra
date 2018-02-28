package com.learning.pramati.wiki.caller;

import com.learning.pramati.property.PropertyReader;


import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
/*
*
@author Virendra
*
*/
public class WikiCaller  implements Callable<String>{
    private static final Logger LOGGER = Logger.getLogger(WikiCaller.class.getName());
    String keyword;
    public WikiCaller(String str) {
        keyword=str;
    }

    public static String basePath=PropertyReader.getInstance().getProperty("baseFolder");
    private static File baseDir=new File(basePath);
    String wikiURL = PropertyReader.getInstance().getProperty("wikiURL");

    @Override
    public String call() throws Exception {


        String https_url = wikiURL+keyword;
        URL url;
        try {
            if(! new File(basePath+keyword+".txt").exists()) {
                url = new URL(https_url);
                HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
                if (con.getResponseCode() == 200) {

                    ObjectMapper mapper = new ObjectMapper();


                    try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                        String response = br.readLine();
                        String[] arr = response.split("\\{");
                        response = arr[arr.length - 1];
                        response = "{" + response.substring(0, response.length() - 3);

                        Map<String, Object> wikiMap = mapper.readValue(response, new TypeReference<Map<String, Object>>() {
                        });

                        if (wikiMap.get("extract") != null && !wikiMap.get("extract").toString().isEmpty()) {
                            if(baseDir !=null && baseDir.exists() && baseDir.canWrite()) {
                                File f=new File(baseDir.getAbsolutePath()+"/"+  keyword + ".txt");

                                if(!f.exists())
                                    f.createNewFile();
                                if(f.canWrite()) {
                                    BufferedWriter writer = Files.newBufferedWriter(Paths.get(f.getAbsolutePath()));
                                    response = wikiMap.get("extract").toString();
                                    writer.write(response);
                                    writer.flush();
                                    this.notifyAll();
                                }else{
                                    LOGGER.info("Permission to write the file doesn't exist. File : "+f.getAbsolutePath());
                                }
                            }
                            else{
                                LOGGER.info(" Given path is not a valid write location. Path:  " + baseDir.getAbsolutePath() + "\n");
                            }
                        }
                    }
                } else {
                    LOGGER.log(Level.WARNING,"ResponseCode :: "+con.getResponseCode() +" ResponseMessage:: " +con.getResponseMessage());
                    return "Unsuccessful writing :: " + keyword + ".txt";
                }
            }
        } catch (MalformedURLException e) {
            LOGGER.info("EXCEPTION:: "+e.getMessage());
        }
        return "success writing :: "+keyword+".txt";
    }
}
