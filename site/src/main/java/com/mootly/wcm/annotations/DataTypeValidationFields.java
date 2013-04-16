package com.mootly.wcm.annotations;


import java.lang.annotation.ElementType;
import com.mootly.wcm.annotations.DataTypeValidationHelper.DataTypeValidationType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DataTypeValidationFields {
	String[] fieldNames();
	DataTypeValidationType[] dataTypes();
}
