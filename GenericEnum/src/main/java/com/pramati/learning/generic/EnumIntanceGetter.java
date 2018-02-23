package com.pramati.learning.generic;

import java.util.Arrays;

/*
@author Virendra
This class will provide the instance of the proper enum with given value and class type.
*/
public class EnumIntanceGetter {

    public static <T, R extends SuperEnum> R getEnumInstance(Class<R> r, T t) {
        if(Arrays.asList(r.getInterfaces()).contains(SuperEnum.class)) {
            SuperEnum[] obj = r.getEnumConstants();
            for (SuperEnum e : obj) {
                if (e.getValue().equals(t)) {
                    return (R) e;
                }
            }
        }
        return null;
    }
}
