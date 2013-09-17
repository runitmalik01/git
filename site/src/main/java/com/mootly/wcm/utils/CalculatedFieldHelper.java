package com.mootly.wcm.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.DirectFieldAccessor;

import com.mootly.wcm.annotations.CalculatedField;
import com.mootly.wcm.services.ditws.helper.SpringExpressionParser;

public class CalculatedFieldHelper {
	private final Logger log = LoggerFactory.getLogger(CalculatedFieldHelper.class);
	
	public void processCalculatedFields(Object anObject) {
		if ( anObject == null ) {
			return;
		}
		BeanInfo bi;
		try {
			bi = Introspector.getBeanInfo(anObject.getClass());
			PropertyDescriptor[] properties = bi.getPropertyDescriptors();
			DirectFieldAccessor directFieldAccessor = new DirectFieldAccessor(anObject);
			Map<String,Object> variables = new HashMap<String, Object>();
		    for(PropertyDescriptor property : properties) {
		    	try {
			    	if ( property.getReadMethod() != null ) {
				    	Object propertyValue = directFieldAccessor.getPropertyValue(property.getName());
				    	if (propertyValue != null && property != null && property.getName() != null) {
				    		variables.put(property.getName(), propertyValue);
				    	}
			    	}
		    	}catch (Exception ex) {
		    		
		    	}
		    }
		    for(PropertyDescriptor property : properties) {
		        //One way
		    	Method theWriteMethod = property.getWriteMethod();
		    	if (theWriteMethod == null) continue;
		    	CalculatedField calculatedField = theWriteMethod.getAnnotation(CalculatedField.class);		    	
		    	if (calculatedField != null) {
		    		String springExpression = calculatedField.springExpression();
		    		Map<String, Object> contextRootObject = new HashMap<String, Object>();
		    		//Map<String,Object> variables = new HashMap<String, Object>();
		    		variables.put("theObject", anObject);
		    		try {
		    			Object theReturnValue = SpringExpressionParser.parseExpression(contextRootObject, springExpression, variables, property.getPropertyType());
		    			log.info("The return value is " + theReturnValue);
		    			directFieldAccessor.setPropertyValue(property.getName(), theReturnValue);
		    			//theWriteMethod.invoke(anObject, theReturnValue);
		    		}catch (Exception ex) {
		    			log.error("Error parsing expression " + springExpression,ex);
		    		}		    		
		    	}
		    }	
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			log.error("There was an error converting object to FormMap instance",e);
		}
		catch (Exception e) {
			log.error("There was an error converting object to FormMap instance",e);
		}
	}
	
}
