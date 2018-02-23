package com.learning.pramati.annotations.impl;

import com.learning.pramati.annotations.DocType;
import com.learning.pramati.annotations.doc.Aadhar;

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
		Field[] fields = obj.getClass().getDeclaredFields();
		DocType annotation=obj.getClass().getAnnotation(DocType.class);
		if(annotation.type().equalsIgnoreCase("aadhaar")) {
			for (int i = 0; i < fields.length; i++) {
				DocType custAnnotation = (DocType) fields[i].getAnnotation(DocType.class);

				if (custAnnotation != null) {
					validateData(custAnnotation,fields[i], obj);
				}
			}
		}
		return errorMessages;
	}

	private static void validateData(DocType custAnnotation, Field field, Object obj) throws IllegalAccessException {
		switch (custAnnotation.type())
		{
			case ("aadhaar"):
				field.setAccessible(true);
				validateNotNull(field.get(obj),field);
			case ("aadhaarNumber"):
				field.setAccessible(true);
				validateLengthConstraint(field.get(obj),field);
		}
	}

	private static void validateNotNull(Object o, Field field) {
		if (null == o) {
			errorMessages.add(field.getName() + " can't be null");
		}
	}
	private static void validateLengthConstraint(Object o, Field field) {
		String objString=o.toString().replaceAll(" ","");
		if (objString.length() != 12) {
			if(!objString.matches("[0-9]+")){
				errorMessages.add(field.getName() + " is invalid! Contains non numeric characters");
			}

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