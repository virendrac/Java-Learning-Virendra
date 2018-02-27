package com.learning.pramati.annotations.impl;

import com.learning.pramati.annotations.DocConsistency;
import com.learning.pramati.annotations.DocType;
import com.learning.pramati.annotations.common.DocumentFields;
import com.learning.pramati.annotations.common.Documents;
import com.learning.pramati.annotations.doc.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;


/**
 *
 * @author Virendra
 *
 */

public class DocConsistencyValidator implements ConstraintValidator<DocConsistency,Object> {
	private static final Logger LOGGER = Logger.getLogger(DocConsistencyValidator.class.getName());
	String type;

	private static List errorMessages = new ArrayList();
	public static List validateDocConsistency(Object obj) throws IllegalAccessException {
		if (obj != null){
			DocConsistency annotation = obj.getClass().getAnnotation(DocConsistency.class);
			if(annotation!=null) {
				Field[] fields=obj.getClass().getFields();
				Aadhar aadhar=null;
				PanCard panCard=null;
				BankStatement bankStatement=null;
				if(fields!=null){
					for(Field f :fields){
						DocConsistency docConsistency=f.getAnnotation(DocConsistency.class);
						if(docConsistency!=null){
							switch (docConsistency.type()){
								case (Documents.AADHAAR):
									f.setAccessible(true);
									aadhar= (Aadhar) f.get(obj);
								case (Documents.PAN):
									f.setAccessible(true);
									panCard= (PanCard) f.get(obj);
								case (Documents.BANKSTMT):
									f.setAccessible(true);
									bankStatement= (BankStatement) f.get(obj);
							}
						}
					}
				}
				if(aadhar!=null && panCard!=null && bankStatement!=null){
					if (!panCard.getFullname().equalsIgnoreCase(aadhar.getFullname())
							|| !panCard.getFullname().equalsIgnoreCase(bankStatement.getCustomerName())) {
						errorMessages.add("Name consistency broken.");
					}
					if (!aadhar.getAddress().equalsIgnoreCase(bankStatement.getAddress())) {
						errorMessages.add("Address consistency broken.");
					}
					if (!aadhar.getDob().equals(panCard.getDob())) {
						errorMessages.add("DOB consistency broken.");
					}
				}else if(aadhar!=null && panCard!=null ){
					if (!panCard.getFullname().equalsIgnoreCase(aadhar.getFullname())) {
						errorMessages.add("Name consistency broken between Aadhaar and Pancard");
					}
					if (!aadhar.getDob().equals(panCard.getDob())) {
						errorMessages.add("DOB consistency broken between Aadhaar and Pancard");
					}

				}else if(panCard!=null && bankStatement!=null){
					if (!panCard.getFullname().equalsIgnoreCase(bankStatement.getCustomerName())) {
						errorMessages.add("Name consistency broken between BankStatement and Pancard");
					}
				}else if(aadhar!=null &&  bankStatement!=null){
					if ( !panCard.getFullname().equalsIgnoreCase(bankStatement.getCustomerName())) {
						errorMessages.add("Name consistency broken between BankStatement and Aadhaar");
					}
					if (!aadhar.getAddress().equalsIgnoreCase(bankStatement.getAddress())) {
						errorMessages.add("Address consistency broken between BankStatement and Aadhaar");
					}
				}else{
					errorMessages.add("Not a valid set of documents to verify consistency.");
				}
			}else
			{
				errorMessages.add("DocConsistency annotation not found in the object.");
			}
		}else {
			errorMessages.add("A Document set should not be null.");
		}
		return errorMessages;
	}
	

	@Override
	public void initialize(DocConsistency constraintAnnotation) {
		type=constraintAnnotation.type();
	}

	@Override
	public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
		constraintValidatorContext.buildConstraintViolationWithTemplate("");
		return false;
	}

}