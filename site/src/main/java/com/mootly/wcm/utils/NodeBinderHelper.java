package com.mootly.wcm.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.MethodUtils;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.DirectFieldAccessor;

import com.mootly.wcm.annotations.NodeBinder;

public class NodeBinderHelper {
	private final Logger log = LoggerFactory.getLogger(NodeBinderHelper.class);
	
	public static <T> void setObjectProperty(String propertyName,Object anObject,T defaultValue) {
		BeanInfo bi;
		String nodePropertyName = null;
		try {
			bi = Introspector.getBeanInfo(anObject.getClass());
			PropertyDescriptor[] properties = bi.getPropertyDescriptors();
			for(PropertyDescriptor property : properties) {
				if (property.getName().equals(propertyName)) {
					NodeBinder nodeBinder = property.getReadMethod().getAnnotation(NodeBinder.class);
					if (nodeBinder != null) {
						nodePropertyName = nodeBinder.nodePropertyName();
					}
					break;
				}
			}
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (nodePropertyName != null) {
			DirectFieldAccessor directFieldAccessor = new DirectFieldAccessor(anObject);
			Object theValue =  directFieldAccessor.getPropertyValue(propertyName);		
			if (theValue == null){
				if (anObject instanceof HippoItem) {
					HippoItem anItem = (HippoItem) anObject;
					T theReturnValue = anItem.getProperty(nodePropertyName,defaultValue);
					directFieldAccessor.setPropertyValue(propertyName, theReturnValue);
				}
			}		
		}
	}
	
	public void bindObjectToNode(javax.jcr.Node node,Object anObject) {
		if ( anObject == null ) {
			return;
		}
		BeanInfo bi;
		try {
			bi = Introspector.getBeanInfo(anObject.getClass());
			PropertyDescriptor[] properties = bi.getPropertyDescriptors();
			DirectFieldAccessor directFieldAccessor = new DirectFieldAccessor(anObject);
		    for(PropertyDescriptor property : properties) {
		        //One way
		    	NodeBinder nodeBinder = property.getReadMethod().getAnnotation(NodeBinder.class);
		    	if (log.isInfoEnabled()) {
		    		if (nodeBinder == null) {
		    			log.info("Could not find FormField annotation on the readMethod " + property.getReadMethod().getName());
		    		}
		    		else {
		    			log.info("Annotation found on the readMethod " + property.getReadMethod().getName());
		    		}
		    	}
		    	if (nodeBinder != null) {
		    		String nodePropertyName = nodeBinder.nodePropertyName();
			        String propertyName = nodeBinder.propertyName();		
			        Object theValue = directFieldAccessor.getPropertyValue(propertyName);
			        if (node != null) {
						try {							
							Class theTypeClass = directFieldAccessor.getPropertyType(propertyName);
							if ( !theTypeClass.isPrimitive() ) {
								try {
									Class thePrimitiveClass = (Class) theTypeClass.getDeclaredField("TYPE").get(node);
									if (thePrimitiveClass != null) {
										theTypeClass = thePrimitiveClass;
									}
								} catch (NoSuchFieldException e) {
									// TODO Auto-generated catch block
									//e.printStackTrace();
								}
							}
							Method theMethod = MethodUtils.getAccessibleMethod( node.getClass() , "setProperty", new Class[]{String.class,  theTypeClass});
							//Method apacheMethod = org.apache.commons.lang.reflect.MethodUtils.getAccessibleMethod(node.getClass() , "setProperty", new Class[]{String.class,  theTypeClass});
							//Method theMethod2 = node.getClass().getMethod("setProperty", String.class, theTypeClass);
							if ( theMethod != null ) {
								theMethod.invoke(node, nodePropertyName,theValue);
							}
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							log.warn("No",e);
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							log.warn("No",e);
						}catch (SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        }
		    	}
		    }	
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			log.error("There was an error converting object to FormMap instance",e);
		}
	}
	
}
