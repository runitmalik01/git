package com.mootly.wcm.annotations;


//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE)
public class FormField {
	final String name;
	final String[] validators;
	public FormField(String name, String[] validators) {
		this.name = name;
		this.validators = validators;
	}
}
