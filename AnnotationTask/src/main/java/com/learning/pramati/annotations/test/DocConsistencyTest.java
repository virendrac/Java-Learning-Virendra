package com.learning.pramati.annotations.test;

import com.learning.pramati.annotations.DocType;
import com.learning.pramati.annotations.doc.*;
import com.learning.pramati.annotations.impl.DocConsistencyValidator;
import com.learning.pramati.annotations.impl.DocTypeValidator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
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


        Aadhar aadhar = new Aadhar();
        aadhar.setFullname("John Doe");
        aadhar.setAddress("J. Hills");
        aadhar.setGender("Male");
        aadhar.setDob(new Date("01/01/1900"));
        aadhar.setAadhaarNumber(123456789012L);
        PanCard pan=new PanCard();
        pan.setFullname("John Doe");
        pan.setDob(new Date("01/01/1900"));
        pan.setFatherName("John Doe Sr");
        pan.setIssuedBy("Govt of India");
        pan.setPanNumber("AWBBC6055Q");
        BankStatement bankStatement= new BankStatement();
        bankStatement.setAccountNumber("1234567890");
        bankStatement.setAddress("J. Hills");
        bankStatement.setCustomerName("John Doe");
        bankStatement.setEmail("johndoe@hotmail.com");
        bankStatement.setTransactions(new ArrayList<Transaction>());

        try {
            List errors = null;
            if(testDoctype(aadhar) && testDoctype(pan) && testDoctype(bankStatement)){
                DocumentSet docSet = new DocumentSet();
                docSet.setAadhar(aadhar);
                docSet.setPanCard(pan);
                docSet.setBankStatement(bankStatement);
                DocConsistencyValidator consistencyValidator=new DocConsistencyValidator();
                errors=consistencyValidator.validateDocConsistency(docSet);
                Assert.assertEquals("Error(s): " +errors.toString(),0,errors.size());
            }

        }
        catch (IllegalAccessException e) {
            Assert.assertTrue("IllegalAccessException: "+e.getMessage(),false);
        }


    }

    public boolean testDoctype(Document doc) {

        try {
            if(doc.getClass().isAnnotationPresent(DocType.class)) {
                List errors = null;
                DocTypeValidator validator=new DocTypeValidator();
                errors = validator.validate(doc);


                if(errors.size()==0){
                    return true;
                }else{
                    return false;
                }
            }
            else{
                return false;
            }
        } catch (IllegalAccessException e) {
            Assert.assertTrue("IllegalAccessException: "+e.getMessage(),false);
            return false;
        }
    }
}
