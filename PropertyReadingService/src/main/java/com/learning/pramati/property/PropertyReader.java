package com.learning.pramati.property;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/*
*
@author Virendra
*
*/
public class PropertyReader {
//    public static InputStream input =PropertyReader.class.getResourceAsStream("config.properties");
    public static String getProperty(String propertyName){

        String retVal="";
        Properties prop = new Properties();
        InputStream input=null;

        try {
            input=new FileInputStream("./PropertyReadingService/src/main/resources/config.properties");

            // load a properties file
            prop.load(input);

            retVal=prop.getProperty(propertyName);



        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return retVal;
    }
}
