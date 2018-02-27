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

public class DocConsistencyValidator implements ConstraintValidator<DocConsistency,DocumentSet> {
	private static final Logger LOGGER = Logger.getLogger(DocConsistencyValidator.class.getName());
	String type;

	private static List errorMessages = new ArrayList();
	public static List validateDocConsistency(DocumentSet obj) throws IllegalAccessException {
		if (obj != null){
			if(validateNotNull(obj)){
				if(!obj.getPanCard().getFullname().equalsIgnoreCase(obj.getAadhar().getFullname())
						|| !obj.getPanCard().getFullname().equalsIgnoreCase(obj.getBankStatement().getCustomerName())){
					errorMessages.add("Name consistency broken.");
				}
				if(!obj.getAadhar().getAddress().equalsIgnoreCase(obj.getBankStatement().getAddress())){
					errorMessages.add("Address consistency broken.");
				}
				if(!obj.getAadhar().getDob().equals(obj.getPanCard().getDob())){
					errorMessages.add("DOB consistency broken.");
				}
			}
		}else {
			errorMessages.add("A Document set should not be null.");
		}
		return errorMessages;
	}


	private static boolean validateNotNull(DocumentSet o) {
		if (null == o.getAadhar()) {
			errorMessages.add("Aadhaar can't be null");
			return false;
		}else if (null == o.getBankStatement()) {
			errorMessages.add("BankStatement can't be null");
			return false;
		}else if (null == o.getPanCard()) {
			errorMessages.add("PanCard can't be null");
			return false;
		}
		return true;
	}

	@Override
	public void initialize(DocConsistency constraintAnnotation) {
		type=constraintAnnotation.type();
	}

	@Override
	public boolean isValid(DocumentSet documentSet, ConstraintValidatorContext constraintValidatorContext) {
		constraintValidatorContext.buildConstraintViolationWithTemplate("");
		return false;
	}
}