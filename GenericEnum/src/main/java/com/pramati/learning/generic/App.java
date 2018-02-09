package com.pramati.learning.generic;

/*
@author Virendra
This class is to run and generate the instance of proper enum.
*/
public class App {

    public static void main(String[] args){
        SuperEnum e= EnumIntanceGetter.getEnumInstance(DocType.class,"AADHAAR");


        System.out.println(e);

        e= EnumIntanceGetter.getEnumInstance(Color.class,1);

        System.out.println(e);

        e= EnumIntanceGetter.getEnumInstance(Months.class,10);

        System.out.println(e);

    }
}
