package com.mootly.wcm.services;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.jcr.Node;

import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.DirectFieldAccessor;

public class CustomContentNodeBinderImpl implements ContentNodeBinder{
	public static final Logger log = LoggerFactory.getLogger(CustomContentNodeBinderImpl.class);
	Object object;
	FormMap formMap;

	public CustomContentNodeBinderImpl(Object object,FormMap formMap) {
		// TODO Auto-generated constructor stub
		this.object = object;
		this.formMap = formMap;
	}

	@Override
	public boolean bind(Object content, Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		log.info("Let's update the document by binder");
		BeanInfo bi;
		try {
			bi = Introspector.getBeanInfo(content.getClass());
			PropertyDescriptor[] properties = bi.getPropertyDescriptors();
			DirectFieldAccessor directFieldAccessor = new DirectFieldAccessor(content);
			for(PropertyDescriptor property:properties){
				if(property.getName().contains("mootlywcm:")){
					log.info("propertynama:::"+property.getName());
					if(formMap.getField(StringUtils.substringAfter(property.getName(), "mootlywcm:")) != null){
						if (node != null) {
							try {							
								Class<?> theTypeClass = directFieldAccessor.getPropertyType(property.getName());
								if ( !theTypeClass.isPrimitive() ) {
									try {
										Class<?> thePrimitiveClass = (Class<?>) theTypeClass.getDeclaredField("TYPE").get(node);
										if (thePrimitiveClass != null) {
											theTypeClass = thePrimitiveClass;
										}
									} catch (NoSuchFieldException e) {
										// TODO Auto-generated catch block
										//e.printStackTrace();
									}
								}
								Object theValue = formMap.getField(StringUtils.substringAfter(property.getName(), "mootlywcm:")).getValue();//theReadMethod.invoke(anObject);
								Method theMethod = MethodUtils.getAccessibleMethod( node.getClass() , "setProperty", new Class[]{String.class,  theTypeClass});
								if (!"class java.lang.String".equals(theTypeClass.toString()) ) {
									log.info("STOP" + theTypeClass.toString() + ":" +  theValue + " : method: " + theMethod.toString());
								}
								//Method apacheMethod = org.apache.commons.lang.reflect.MethodUtils.getAccessibleMethod(node.getClass() , "setProperty", new Class[]{String.class,  theTypeClass});
								//Method theMethod2 = node.getClass().getMethod("setProperty", String.class, theTypeClass);
								if ( theMethod != null ) {
									theMethod.invoke(node, property.getName(),theValue);
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
			}
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}
