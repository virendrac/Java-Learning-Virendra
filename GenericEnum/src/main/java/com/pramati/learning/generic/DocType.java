package com.pramati.learning.generic;
/*
@author Virendra
This is an enum type.
*/
public enum DocType implements SuperEnum{
    
    AADHAAR("AADHAAR"),PANCARD("PAN"),BANKSTMT("BS");

    String value;
    DocType(String aadhaar) {
        value=aadhaar;
    }

    @Override
    public  String getValue() {
        return value;
    }
}
