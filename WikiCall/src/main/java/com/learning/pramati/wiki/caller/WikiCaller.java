package com.learning.pramati.wiki.caller;

import com.learning.pramati.property.PropertyReader;
import sun.net.www.protocol.https.HttpsURLConnectionImpl;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
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
    String wikiURL = PropertyReader.getInstance().getProperty("wikiURL");

    @Override
    public String call() throws Exception {


        String https_url = wikiURL+keyword;
        URL url;
        try {

            url = new URL(https_url);
            HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
            if (con.getResponseCode() == 200) {

                ObjectMapper mapper = new ObjectMapper();


                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String response = br.readLine();
                String[] arr = response.split("\\{");
                response = arr[arr.length - 1];
                response = "{" + response.substring(0, response.length() - 3);

                Map<String, Object> wikiMap = mapper.readValue(response, new TypeReference<Map<String, Object>>() {
                });

                BufferedWriter writer = Files.newBufferedWriter(Paths.get(basePath + keyword + ".txt"));
                response = wikiMap.get("extract").toString();
                writer.write(response);
                writer.flush();
                this.notifyAll();
            } else {
                return "Unsuccessful writing :: " + keyword + ".txt";
            }

        } catch (MalformedURLException e) {
            LOGGER.info("EXCEPTION:: "+e.getMessage());
        } catch (IOException e) {
            LOGGER.info("EXCEPTION:: "+e.getMessage());
        }
        return "success writing :: "+keyword+".txt";
    }
}
