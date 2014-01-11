/**
 * 
 */
package com.mootly.wcm.components.cms;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AutoCreateFormField;
import com.mootly.wcm.beans.ValueListDocument;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.components.cms.view.AbstractFormField;
import com.mootly.wcm.services.CustomContentNodeBinderImpl;

/**
 * @author BEN-10
 *
 */
public class DocumentUpdateComponent extends ITReturnComponent {

	public static final Logger log = LoggerFactory.getLogger(DocumentUpdateComponent.class);

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		HippoBean siteContentBaseBean = getITRInitData(request).getSiteContentBaseBeanForReseller(request);
		if(siteContentBaseBean == null){
			if(log.isInfoEnabled()){
				log.info("Site content Bean is { } null.Not able to proceed.");
			}
			return;
		}	
		Map<String,AbstractFormField> mapOfAbstractFormFields = new HashMap<String, AbstractFormField>();
		String documentCanonicalPath = request.getRequestContext().getResolvedSiteMapItem().getParameter("documentCanonicalPath");
		if(StringUtils.isNotBlank(documentCanonicalPath)){
			if(!documentCanonicalPath.startsWith("/")){
				documentCanonicalPath = "/"+documentCanonicalPath;
			}
			if(log.isInfoEnabled()){
				log.info("Lets see Path of Document::"+documentCanonicalPath);
			}
			Session persistableSession = null;
			WorkflowPersistenceManager wpm = null;
			try {
				persistableSession = getPersistableSession(request);
				wpm = getWorkflowPersistenceManager(persistableSession);
				wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
				Object object = wpm.getObject(documentCanonicalPath);
				if(log.isInfoEnabled()){
					log.info("have the object and Name of object"+object.toString());
				}
				if(object instanceof HippoBean){
					HippoBean hippoBeanDocument = (HippoBean) object;
					Method[] hippoBeanDocumentMethods = hippoBeanDocument.getClass().getMethods();//getAnnotation(AutoCreateFormField.class);
					for(Method beanDocumentMethod:hippoBeanDocumentMethods){
						if(beanDocumentMethod.isAnnotationPresent(AutoCreateFormField.class)){
							AutoCreateFormField createFormField = beanDocumentMethod.getAnnotation(AutoCreateFormField.class);
							ValueListDocument valueListDocument = null;
							if(StringUtils.isNotBlank(createFormField.valueListName())){
								//HippoBean scopeBaseBean = getSiteContentBaseBean(request);
								if(log.isInfoEnabled()){
									log.info("Value List Document"+createFormField.valueListName());
								}
								String baseValueListContentPath = request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath()+"/common/valuelists/";
								valueListDocument = (ValueListDocument) getObjectBeanManager(request).getObject(baseValueListContentPath+createFormField.valueListName());
							}
							if(log.isInfoEnabled()){
								log.info("Lets check this property in Document Bean");
							}
							Object objectProperty = beanDocumentMethod.invoke(hippoBeanDocument,new Object[]{});//hippoBeanDocument.getProperty("mootlywcm:"+beanDocumentMethod.getName());
							AbstractFormField abstractFormField = new AbstractFormField(createFormField, valueListDocument, objectProperty);
							mapOfAbstractFormFields.put(createFormField.name(), abstractFormField);
						}
					}
					request.setAttribute("hippoBeanDocument", hippoBeanDocument);
					request.setAttribute("mapOfAbstractFormFields", mapOfAbstractFormFields);
				}
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ObjectBeanManagerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
	}

	@SuppressWarnings("deprecation")
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		//super.doAction(request, response);
		String documentCanonicalPath = request.getRequestContext().getResolvedSiteMapItem().getParameter("documentCanonicalPath");
		if(StringUtils.isNotBlank(documentCanonicalPath)){
			if(!documentCanonicalPath.startsWith("/")){
				documentCanonicalPath = "/"+documentCanonicalPath;
			}
			if(log.isInfoEnabled()){
				log.info("Lets see Path of Document::"+documentCanonicalPath);
			}
			Session persistableSession = null;
			WorkflowPersistenceManager wpm = null;
			try {
				persistableSession = getPersistableSession(request);
				wpm = getWorkflowPersistenceManager(persistableSession);
				wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
				Object object = wpm.getObject(documentCanonicalPath);
				if(log.isInfoEnabled()){
					log.info("have the object and Name of object"+object.toString());
				}
				if(object instanceof HippoBean){
					HippoBean hippoBeanDocument = (HippoBean) object;
					FormMap formMap = getFormMap(object, request);
					for(String fieldName:formMap.getFieldNames()){
						if(log.isInfoEnabled()){
							log.info("Lets see field name :::"+fieldName+"::Value::"+formMap.getField(fieldName).getValue());
						}	
					}
					Node documentNode = hippoBeanDocument.getNode();
					if(!documentNode.isCheckedOut()){
						log.info("Yes it is :::");
						documentNode.checkout();
					}
					CustomContentNodeBinderImpl binderImpl = new CustomContentNodeBinderImpl(object, formMap);
					wpm.update(object, binderImpl);
					wpm.save();
				}
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ObjectBeanManagerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public FormMap getFormMap(Object object, HstRequest request){
		FormMap formMap = null;
		if(object !=null){
			List<String> fieldNames = new ArrayList<String>();
			Method[] objectMehtods = object.getClass().getMethods();
			for(Method objectMethod:objectMehtods){
				if(objectMethod.isAnnotationPresent(AutoCreateFormField.class)){
					AutoCreateFormField autoCreateFormField = objectMethod.getAnnotation(AutoCreateFormField.class);
					fieldNames.add(autoCreateFormField.name());
				}
			}
			formMap = new FormMap(request, fieldNames);
		}
		return formMap;
	}
}
