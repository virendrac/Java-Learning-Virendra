package com.learning.pramati.annotations.impl;

import com.learning.pramati.annotations.DocType;
import com.learning.pramati.annotations.doc.Aadhar;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Virendra
 *
 */

public class DocTypeValidator {

	public static List validate(Object obj){
		List errorMessages = new ArrayList();
		Field[] fields = obj.getClass().getDeclaredFields();
		DocType annotation=obj.getClass().getAnnotation(DocType.class);
		if(annotation.type().equalsIgnoreCase("aadhaar")) {
			for (int i = 0; i < fields.length; i++) {
				DocType custAnnotation = (DocType) fields[i].getAnnotation(DocType.class);

				if (custAnnotation != null) {
					if (custAnnotation.type().equalsIgnoreCase("aadhaar"))
						try {
							fields[i].setAccessible(true);
							Object o = fields[i].get(obj);
							if (null == o) {
								errorMessages.add(fields[i].getName() + " can't be null");
							} else if (custAnnotation.type().equalsIgnoreCase("aadhaarNumber")) {
								if (o.toString().length() != 12) {
									errorMessages.add(fields[i].getName() + " is invalid!");
								}
							}

						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
				}
			}
		}
		return errorMessages;
	}
}