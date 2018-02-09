package com.pramati.learning.generic;

/*
@author Virendra
This is an enum type.
*/
public enum Color implements SuperEnum{
    RED(1),GREEN(2),BLUE(3);

    int value;

    Color(int i) {
        value=i;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
