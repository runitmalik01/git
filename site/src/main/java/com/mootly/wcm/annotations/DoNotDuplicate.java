package com.mootly.wcm.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Tag a class with this Annotation if you want it to be ignored by the COPY action defined in ITReturnCopyOrMove
 * @author Amit
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DoNotDuplicate {
}
