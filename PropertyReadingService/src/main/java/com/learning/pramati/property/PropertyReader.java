package com.learning.pramati.property;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

/*
*
@author Virendra
*
*/
public class PropertyReader {

    private static final Logger LOGGER = Logger.getLogger(PropertyReader.class.getName());
    private static PropertyReader object =null;
    private Properties prop = new Properties();

    private PropertyReader() {
        try (InputStream input=new FileInputStream("./PropertyReadingService/src/main/resources/config.properties")){
            prop.load(input);
        } catch (IOException e) {
            LOGGER.info("EXCEPTION:: "+e.getMessage());
        }
    }

    public static PropertyReader getInstance(){
        if(object==null){
            object=new PropertyReader();
        }
        return object;
    }

    public String getProperty(String propertyName){
            return prop.getProperty(propertyName);
    }
}
