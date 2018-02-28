package com.learning.pramati.annotations.impl;

import com.learning.pramati.annotations.DocType;
import com.learning.pramati.annotations.common.DocumentFields;
import com.learning.pramati.annotations.common.Gender;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidator;
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
	private List errorMessages = new ArrayList();

	public  List validate(Object obj) throws IllegalAccessException {
		List errorMessages = new ArrayList();
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

	private  void validateData(DocType custAnnotation, Field field, Object obj) throws IllegalAccessException {
		List errorMessages = new ArrayList();
		switch (custAnnotation.type())
		{
			case (DocumentFields.AADHAARNUMBER):
				field.setAccessible(true);
				validateNotNull(field.get(obj),field);
				validateLengthConstraint(field.get(obj),field, 12);
				validateRegexConstraint(field.get(obj),field, "[0-9]+");
				break;
			case(DocumentFields.FULLNAME):
				field.setAccessible(true);
				validateNotNull(field.get(obj),field);
				break;
			case(DocumentFields.DOB):
				field.setAccessible(true);
				validateNotNull(field.get(obj),field);
				break;
			case(DocumentFields.GENDER):
				field.setAccessible(true);
				validateNotNull(field.get(obj),field);
				validateGender(field.get(obj),field);
				break;
			case(DocumentFields.FATHERNAME):
				field.setAccessible(true);
				validateNotNull(field.get(obj),field);
				break;
			case(DocumentFields.PANNUMBER):
				field.setAccessible(true);
				validateNotNull(field.get(obj),field);
				validateLengthConstraint(field.get(obj),field, 10);
				validateRegexConstraint(field.get(obj),field, "[A-Za-z]{5}\\d{4}[A-Za-z]{1}");
				break;
			case(DocumentFields.ISSUEDBY):
				field.setAccessible(true);
				validateNotNull(field.get(obj),field);
				break;
			case(DocumentFields.ACCOUNTNUMBER):
				field.setAccessible(true);
				validateNotNull(field.get(obj),field);
				break;
			case(DocumentFields.MOBILENUMBER):
				field.setAccessible(true);
				validateNotNull(field.get(obj),field);
				break;
			case(DocumentFields.EMAIL):
				field.setAccessible(true);
				validateNotNull(field.get(obj),field);
				break;
		}
	}

	private  void validateGender(Object o, Field field) {
		String objString=o.toString().replaceAll(" ","");
		if(objString.equalsIgnoreCase(Gender.FEMALE )||objString.equalsIgnoreCase(Gender.MALE )|| objString.equalsIgnoreCase(Gender.THIRD) ){
			return;
		}
		errorMessages.add(field.getName() + " Invalid");
	}

	private  void validateNotNull(Object o, Field field) {
		if (null == o) {
			errorMessages.add(field.getName() + " can't be null");
		}
	}

	private  void validateRegexConstraint(Object o, Field field, String regex ) {
		String objString=o.toString().replaceAll(" ","");
		if(!objString.matches(regex)){
			errorMessages.add(field.getName() + " is invalid! Not in the required format!");
		}
	}

	private  void validateLengthConstraint(Object o, Field field, int len) {
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