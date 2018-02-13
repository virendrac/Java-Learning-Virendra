//package com.learning.pramati.annotations.impl;
//
//import com.learning.pramati.annotations.DocType;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//import java.lang.reflect.Field;
//
//public class MyFieldValidator implements ConstraintValidator<DocType, Object> {
//
//    private String type;
//    @Override
//    public void initialize(DocType constraintAnnotation) {
//
//       this.type=constraintAnnotation.type();
//
//    }
//
//    @Override
//    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
//        return true;
//    }
//
////    @Override
////    public void initialize(Field annotation) {
////
////        this.order = annotation.order();
////
////        if (this.order < 0) {
////          // blow up
////        }
////    }
////
////    @Override
////    public boolean isValid(Object object, ConstraintValidatorContext constraintContext) {
////
////        return true;
////    }
//}