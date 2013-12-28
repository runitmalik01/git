package com.mootly.wcm.services;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.apache.commons.beanutils.MethodUtils;
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
				if(formMap.getField(property.getName()) != null){
					log.info("have a founding");
					if (node != null) {						
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
						Object theValue = formMap.getField(property.getName()).getValue();//theReadMethod.invoke(anObject);
						Method theMethod = MethodUtils.getAccessibleMethod( node.getClass() , "setProperty", new Class[]{String.class,  theTypeClass});
						if ( theMethod != null ) {
							theMethod.invoke(node, "mootlywcm:"+property.getName(),theValue);
						} else {
							if(node.hasNode("mootlywcm:"+property.getName())){
								Node htmlNode = node.getNode("mootlywcm:"+property.getName());
								if(theValue != null){
									htmlNode.setProperty("hippostd:content", theValue.toString());
								}
							}
						}
					}
				}
				//}
			}
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}
