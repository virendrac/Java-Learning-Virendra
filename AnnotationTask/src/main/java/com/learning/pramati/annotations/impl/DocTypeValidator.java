package com.learning.pramati.annotations.impl;

import com.learning.pramati.annotations.DocType;
import com.learning.pramati.annotations.common.DocumentFields;
import com.learning.pramati.annotations.common.Documents;
import com.learning.pramati.annotations.common.Gender;
import com.learning.pramati.annotations.doc.Aadhar;
import com.learning.pramati.annotations.doc.Document;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


/**
 *
 * @author Virendra
 *
 */

public class DocTypeValidator implements ConstraintValidator<DocType,Object> {
	private static final Logger LOGGER = Logger.getLogger(DocTypeValidator.class.getName());
	String type;

	private static List errorMessages = new ArrayList();
	public static List validate(Object obj) throws IllegalAccessException {
		if(obj!=null) {
			Field[] fields = obj.getClass().getDeclaredFields();
			DocType annotation = obj.getClass().getAnnotation(DocType.class);
			if (annotation!=null) {
				for (int i = 0; i < fields.length; i++) {
					DocType custAnnotation = (DocType) fields[i].getAnnotation(DocType.class);

					if (custAnnotation != null) {
						validateData(custAnnotation, fields[i], obj);
					}
				}
			}

		}else{
			errorMessages.add(" object itself is null");
		}
		return errorMessages;
	}

	private static void validateData(DocType custAnnotation, Field field, Object obj) throws IllegalAccessException {
		switch (custAnnotation.type())
		{
			case (DocumentFields.AADHAARNUMBER):
				field.setAccessible(true);
				validateNotNull(field.get(obj),field);
				validateLengthConstraint(field.get(obj),field, 12);
				validateRegexConstraint(field.get(obj),field, "[0-9]+");
			case(DocumentFields.FULLNAME):
				field.setAccessible(true);
				validateNotNull(field.get(obj),field);
			case(DocumentFields.DOB):
				field.setAccessible(true);
				validateNotNull(field.get(obj),field);
			case(DocumentFields.GENDER):
				field.setAccessible(true);
				validateNotNull(field.get(obj),field);
				validateGender(field.get(obj),field);
			case(DocumentFields.FATHERNAME):
				field.setAccessible(true);
				validateNotNull(field.get(obj),field);
			case(DocumentFields.PANNUMBER):
				field.setAccessible(true);
				validateNotNull(field.get(obj),field);
				validateLengthConstraint(field.get(obj),field, 10);
				validateRegexConstraint(field.get(obj),field, "[A-Za-z]{5}\\d{4}[A-Za-z]{1}");
			case(DocumentFields.ISSUEDBY):
				field.setAccessible(true);
				validateNotNull(field.get(obj),field);
			case(DocumentFields.ACCOUNTNUMBER):
				field.setAccessible(true);
				validateNotNull(field.get(obj),field);
			case(DocumentFields.MOBILENUMBER):
				field.setAccessible(true);
				validateNotNull(field.get(obj),field);
			case(DocumentFields.EMAIL):
				field.setAccessible(true);
				validateNotNull(field.get(obj),field);

		}
	}

	private static void validateGender(Object o, Field field) {
		String objString=o.toString().replaceAll(" ","");
		if(objString.equalsIgnoreCase(Gender.FEMALE )||objString.equalsIgnoreCase(Gender.MALE )|| objString.equalsIgnoreCase(Gender.THIRD) ){
			return;
		}
		errorMessages.add(field.getName() + " Invalid");
	}

	private static void validateNotNull(Object o, Field field) {
		if (null == o) {
			errorMessages.add(field.getName() + " can't be null");
		}
	}

	private static void validateRegexConstraint(Object o, Field field, String regex ) {
		String objString=o.toString().replaceAll(" ","");
		if(!objString.matches(regex)){
			errorMessages.add(field.getName() + " is invalid! Not in the required format!");
		}
	}

	private static void validateLengthConstraint(Object o, Field field, int len) {
		String objString=o.toString().replaceAll(" ","");
		if (objString.length() == len) {
			return;

		}else{
			errorMessages.add(field.getName() + " is of invalid length!");
		}
	}


	@Override
	public void initialize(DocType constraintAnnotation) {
		type=constraintAnnotation.type();
	}

	@Override
	public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
		constraintValidatorContext.buildConstraintViolationWithTemplate("");
		return false;
	}
}