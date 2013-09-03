package com.mootly.wcm.services;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.DirectFieldAccessor;

import com.mootly.wcm.annotations.FormField;

public class FormMapHelper {
	private final Logger log = LoggerFactory.getLogger(FormMapHelper.class);
	public FormMap convertToFormMap(Object anObject) {
		if ( anObject == null ) {
			if (log.isInfoEnabled()) {
				log.info("Object is null, will return null");
			}
			return null;
		}
		else {
			if (log.isInfoEnabled()) {
				log.info("Will attempt to create a Form Map instance from object of class " + anObject.getClass().getName());
			}
		}
		FormMap retFormMap = null;//new FormMap();
	    BeanInfo bi;
	    Map<String,org.hippoecm.hst.component.support.forms.FormField> theMapForForm = new HashMap<String,org.hippoecm.hst.component.support.forms.FormField>();
		try {
			bi = Introspector.getBeanInfo(anObject.getClass());
			PropertyDescriptor[] properties = bi.getPropertyDescriptors();
			DirectFieldAccessor directFieldAccessor = new DirectFieldAccessor(anObject);
		    for(PropertyDescriptor property : properties) {
		        //One way
		    	FormField formField = property.getReadMethod().getAnnotation(FormField.class);
		    	if (log.isInfoEnabled()) {
		    		if (formField == null) {
		    			log.info("Could not find FormField annotation on the readMethod " + property.getReadMethod().getName());
		    		}
		    		else {
		    			log.info("Annotation found on the readMethod " + property.getReadMethod().getName());
		    		}
		    	}
		    	if (formField != null) {
			        String fieldName = formField.name();
			        String propertyName = formField.propertyName();		
			        String theValue = (String) directFieldAccessor.getPropertyValue(propertyName);	
			        org.hippoecm.hst.component.support.forms.FormField theFormField = new org.hippoecm.hst.component.support.forms.FormField(fieldName);
			        theFormField.addValue(theValue);
			        theMapForForm.put(fieldName, theFormField);
		    	}
		    }	
		    if ( theMapForForm != null && theMapForForm.size() > 0 ) {
		    	retFormMap = new FormMap(theMapForForm);
		    }
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			log.error("There was an error converting object to FormMap instance",e);
		}
		return retFormMap;
	}	
}