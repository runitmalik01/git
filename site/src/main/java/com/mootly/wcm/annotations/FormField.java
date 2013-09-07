package com.mootly.wcm.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface FormField {
	String name();
	String propertyName() default "";
	DataTypeValidationType[] dataTypeValidationTypes() default {};
	String format() default "";
	Class<? extends Object> convert() default String.class;
}
