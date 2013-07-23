package com.mootly.wcm.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.hippoecm.hst.content.beans.standard.HippoBean;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AdditionalBeans {
	Class<? extends HippoBean>[] additionalBeansToLoad();
}
