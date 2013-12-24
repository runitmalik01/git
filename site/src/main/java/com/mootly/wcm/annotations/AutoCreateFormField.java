package com.mootly.wcm.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.mootly.wcm.components.cms.view.AbstractFormField.FORM_FILED_TYPE;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface AutoCreateFormField {
	FORM_FILED_TYPE fieldType();
	String name();
	String label();
	String valueListName();
	String title();
	String placeHolder();
	boolean isMultiple();
}
