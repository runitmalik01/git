/**
 * 
 */
package com.mootly.wcm.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author admin
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface NodeBinder {
	String nodePropertyName();
	String propertyName() default "";
}
