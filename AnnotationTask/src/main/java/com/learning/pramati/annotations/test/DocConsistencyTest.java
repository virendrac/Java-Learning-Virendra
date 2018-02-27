package com.learning.pramati.annotations.test;

import com.learning.pramati.annotations.DocType;
import com.learning.pramati.annotations.doc.Aadhar;
import com.learning.pramati.annotations.doc.PanCard;
import com.learning.pramati.annotations.impl.DocTypeValidator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Virendra
 *
 */

public class DocConsistencyTest {

    @Test
    public void testDocConsistency() {

        Aadhar a = new Aadhar();
        a.setFullname("Virendra Chouhan");
        a.setAddress("J. Hills");
        a.setGender("Male");
        a.setDob(new Date("01/01/1900"));
        a.setAadhaarNumber(123456789012L);
        PanCard pan=new PanCard();
//        pan.set
        try {
            if(a.getClass().isAnnotationPresent(DocType.class)) {
                List errors = null;

                    errors = DocTypeValidator.validate(a);

                Assert.assertEquals("Error(s): " + errors.toString(), 0, errors.size());
            }
        } catch (IllegalAccessException e) {
            Assert.assertTrue("IllegalAccessException: "+e.getMessage(),false);
        }
    }

}
