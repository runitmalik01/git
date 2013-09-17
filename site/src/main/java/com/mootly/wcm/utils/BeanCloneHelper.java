package com.mootly.wcm.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.DirectFieldAccessor;
import org.springframework.beans.PropertyValue;

import com.mootly.wcm.annotations.BeanClone;

public class BeanCloneHelper {
	private final Logger log = LoggerFactory.getLogger(BeanCloneHelper.class);
	public void cloneTheBean(Object src,Object dest) {
		if ( src == null || dest == null) {
			if (log.isInfoEnabled()) {
				log.info("Object is null, will return null");
			}
			return;
		}
		else {
			if (log.isInfoEnabled()) {
				log.info("Will attempt to create a Form Map instance from object of class " + src.getClass().getName());
			}
		}
	    BeanInfo bi;
		try {
			bi = Introspector.getBeanInfo(src.getClass());
			PropertyDescriptor[] properties = bi.getPropertyDescriptors();
			DirectFieldAccessor directFieldAccessorSrc = new DirectFieldAccessor(src);
			DirectFieldAccessor directFieldAccessorDest = new DirectFieldAccessor(dest);
		    for(PropertyDescriptor property : properties) {
		        //One way
		    	Method aSrcMethod = property.getWriteMethod();
		    	if (aSrcMethod == null) continue;
		    	BeanClone beanClone = aSrcMethod.getAnnotation(BeanClone.class);
		    	if (beanClone == null) continue;
		    	try {
		    		Object theValue = directFieldAccessorSrc.getPropertyValue(property.getName());
					aSrcMethod.invoke(dest,theValue);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		    	
		    }	
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			log.error("There was an error converting object to FormMap instance",e);
		}
		catch (Exception ex) {
			log.error("There was an error converting object to FormMap instance",ex);
		}
	}	
}
