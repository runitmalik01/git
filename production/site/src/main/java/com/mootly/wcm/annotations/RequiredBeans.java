package com.mootly.wcm.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.hippoecm.hst.content.beans.standard.HippoBean;

/*
 * These must be present in the request attribute otherwise the system will throw EXCPETION
 * for now lets send the user back to home page
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RequiredBeans {
	Class<? extends HippoBean>[] requiredBeans();
	String[] whereToRedirect() default "[undefined]";
}
