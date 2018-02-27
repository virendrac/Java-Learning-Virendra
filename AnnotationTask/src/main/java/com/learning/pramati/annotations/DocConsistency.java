package com.learning.pramati.annotations;


import com.learning.pramati.annotations.common.Documents;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DocConsistency {

    String type() default Documents.DEFAULT;


}
