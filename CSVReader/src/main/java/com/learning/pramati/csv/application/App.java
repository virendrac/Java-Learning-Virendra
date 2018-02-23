package com.learning.pramati.csv.application;

import com.learning.pramati.csv.CSVReader;
import com.learning.pramati.csv.CommonProperties;
import com.learning.pramati.property.PropertyReader;


public class App {
    public static void main(String[] args){

        CSVReader reader = new CSVReader();
        reader.read(PropertyReader.getInstance().getProperty(CommonProperties.CSVFILE),Integer.parseInt(PropertyReader.getInstance().getProperty(CommonProperties.NUMBEROFLINESINFILE)));

    }
}
