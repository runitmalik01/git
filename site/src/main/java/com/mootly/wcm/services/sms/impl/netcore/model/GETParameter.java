package com.mootly.wcm.services.sms.impl.netcore.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface GETParameter {
	String name();
	boolean isRequired() default false;
	boolean allowEmpty() default true;
	String regEx() default "";
}
