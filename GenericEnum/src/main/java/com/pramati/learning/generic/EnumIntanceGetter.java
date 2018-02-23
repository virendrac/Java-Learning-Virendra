package com.pramati.learning.generic;

import java.util.Arrays;

/*
@author Virendra
This class will provide the instance of the proper enum with given value and class type.
*/
public class EnumIntanceGetter {

    public static <T, R extends SuperEnum> R getEnumInstance(Class<R> r, T t) {

            SuperEnum[] obj = r.getEnumConstants();
            for (Object e : obj) {
                if(Arrays.asList(e.getClass().getInterfaces()).contains(SuperEnum.class)) {
                    if (((SuperEnum)e).getValue().equals(t)) {
                        return (R) e;
                    }
                }
            }
        return null;
    }
}
