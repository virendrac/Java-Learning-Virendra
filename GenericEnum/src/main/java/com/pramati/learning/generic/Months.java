package com.pramati.learning.generic;

/*
@author Virendra
This is an enum type.
*/
public enum Months implements SuperEnum{

    JANUARY(1), FEBRUARY(2), MARCH(3), APRIL(4), MAY(5), JUNE(6), JULY(7), AUGUST(8), SEPTEMBER(9), OCTOBER(10), NOVEMBER(11), DECEMBER(12);

    int value;

    Months(int i) {
        value=i;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
