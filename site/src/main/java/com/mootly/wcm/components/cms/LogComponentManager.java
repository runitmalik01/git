/**
 * 
 */
package com.mootly.wcm.components.cms;

import javax.jcr.Session;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormField;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ObjectBeanManagerException;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.request.ResolvedSiteMapItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.cms.EventLogDocument;
import com.mootly.wcm.beans.cms.compound.EventLogDetail;
import com.mootly.wcm.beans.events.BeanLifecycle;
import com.mootly.wcm.beans.events.GenericLifeCycleHandler;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.components.ITReturnComponentHelper;
import com.mootly.wcm.services.MasterConfigService;

/**
 * @author admin
 *
 */
public class LogComponentManager{

	public static final Logger log = LoggerFactory.getLogger(LogComponentManager.class);

	HstRequest request;
	String resellerID;
	boolean isReseller;
	boolean isVendor;
	boolean isLoggedIn;
	String normalisedUserName;
	String parentBeanNodeName;
	String parentBeanNameSpace;
	Class<? extends HippoBean> childBeanClass;
	ResolvedSiteMapItem siteMapItem;
	ITReturnComponentHelper componentHelper;
	boolean doSaveMemberLogs;
	boolean doSaveVendorLogs;
	boolean saveLogs;
	int sizeOfLogs;

	public LogComponentManager(HstRequest request) {
		this.request = request;
		this.componentHelper = new ITReturnComponentHelper();
		this.resellerID = componentHelper.getResellerId(request);
		this.isReseller = componentHelper.isReSeller(request);
		BaseComponent baseComponent = new BaseComponent();
		this.isVendor = baseComponent.isVendor(request);
		this.isLoggedIn = baseComponent.isLoggedIn(request);
		this.normalisedUserName = baseComponent.getNormalizedUserName(request);
		this.parentBeanNodeName = EventLogDocument.NODE_NAME;
		this.parentBeanNameSpace = EventLogDocument.NAMESPACE;
		this.childBeanClass = EventLogDetail.class;
		this.siteMapItem = request.getRequestContext().getResolvedSiteMapItem();
		MasterConfigService configService = MasterConfigService.getInstance();
		this.doSaveMemberLogs = configService.shouldSaveMemberLogInformation();
		this.doSaveVendorLogs = configService.shouldSaveVendorLogInformation();
		this.sizeOfLogs = configService.sizeOfLogInfoToSave();
		if(isVendor){
			this.saveLogs = doSaveVendorLogs;
		} else {
			this.saveLogs = doSaveMemberLogs;
		}
	}

	public void SaveAdminActionLogInfo(HippoBean resellerBeanScope,Class<? extends BaseComponent> currentClass,Session persistableSession,WorkflowPersistenceManager wpm) {
		String absolutepathToSaveLog = AbsolutePathHandler(resellerBeanScope);
		//String reAbsolutepathToSaveLog = absolutepathToSaveLog + "/admin/" + "log";
		if(log.isInfoEnabled()){
			log.info("Lets see path to save Log Information:::"+absolutepathToSaveLog);
		}
		String parentBeanAbsolutePath = absolutepathToSaveLog + "/" + EventLogDocument.class.getSimpleName().toLowerCase();
		ParentBeanLifeCycleHandler parentBeanLifeCycleHandler = new ParentBeanLifeCycleHandler();
		ChildBeanLifeCycleHandler childBeanLifeCycleHandler = new ChildBeanLifeCycleHandler();
		FormMap formMap = createEventLogFormMap(currentClass);
		if(log.isInfoEnabled()){
			log.info("Lets see the current Class to save Log:::"+currentClass.getSimpleName());
		}
		if(isReseller){
			if(saveLogs){				
				try {
					EventLogDocument eventLogDocument = (EventLogDocument)wpm.getObject(parentBeanAbsolutePath);
					if(eventLogDocument != null) {
						if(eventLogDocument.getEventLogDetail().size() < sizeOfLogs){
							componentHelper.saveAddNewChild(formMap, null, childBeanLifeCycleHandler, parentBeanLifeCycleHandler, 
									absolutepathToSaveLog, parentBeanAbsolutePath, parentBeanNameSpace, parentBeanNodeName, childBeanClass, persistableSession, wpm);
						} else {
							//Lets update the existing first child document to save log.
							String childBeanCanonicalUUID = eventLogDocument.getEventLogDetail().get(0).getCanonicalUUID();
							componentHelper.saveUpdateExistingChild(formMap, null, childBeanLifeCycleHandler, parentBeanLifeCycleHandler, 
									absolutepathToSaveLog, parentBeanAbsolutePath, parentBeanNameSpace, parentBeanNodeName, childBeanClass, persistableSession, wpm, 
									childBeanCanonicalUUID);
						}
					} else {
						componentHelper.saveAddNewChild(formMap, null, childBeanLifeCycleHandler, parentBeanLifeCycleHandler, 
								absolutepathToSaveLog, parentBeanAbsolutePath, parentBeanNameSpace, parentBeanNodeName, childBeanClass, persistableSession, wpm);
					}					
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ObjectBeanManagerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
	}

	public String AbsolutePathHandler(HippoBean resellerBeanScope){
		StringBuilder pathBuilder = new StringBuilder();
		if(resellerBeanScope != null) {
			pathBuilder.append(resellerBeanScope.getCanonicalPath());
		} else {
			pathBuilder.append(request.getRequestContext().getResolvedMount().getMount().getCanonicalContentPath());
			if(isReseller){
				pathBuilder.append('/').append("resellers").append('/').append(resellerID);
			}
		}
		if(isVendor) {
			pathBuilder.append('/').append("admin");
		} else {
			pathBuilder.append('/').append("members").append('/').append(normalisedUserName);
		}
		pathBuilder.append('/').append("log");
		
		return pathBuilder.toString();
	}


	public FormMap createEventLogFormMap(Class<? extends BaseComponent> currentClass){
		FormMap formMap = new FormMap();
		FormField eventLogName = new FormField("eventLogName");
		eventLogName.addValue(currentClass.getSimpleName());//siteMapItem.getHstComponentConfiguration().getLabel();
		
		FormField eventLogUrl = new FormField("eventLogUrl");
		eventLogUrl.addValue(siteMapItem.getPathInfo());
		
		FormField eventLogAction = new FormField("eventLogAction");
		if(StringUtils.isNotBlank(siteMapItem.getParameter("action"))){
			eventLogAction.addValue(siteMapItem.getParameter("action"));  
		}else{
			eventLogAction.addValue("DEFAULT");
		}
		
		FormField eventLogDocument = new FormField("eventLogDocument");
		String documentName = null;
		if(currentClass.isAnnotationPresent(com.mootly.wcm.annotations.PrimaryBean.class)){
			documentName = currentClass.getAnnotation(com.mootly.wcm.annotations.PrimaryBean.class).primaryBeanClass().getSimpleName();
		}else{
			documentName = "DEFAULT";
		}
		
		eventLogDocument.addValue(documentName);
		formMap.addFormField(eventLogDocument);
		formMap.addFormField(eventLogUrl);
		formMap.addFormField(eventLogAction);
		formMap.addFormField(eventLogName);
		return formMap;
	}

	class ParentBeanLifeCycleHandler extends GenericLifeCycleHandler implements BeanLifecycle<HippoBean> {

	}

	class ChildBeanLifeCycleHandler extends GenericLifeCycleHandler implements BeanLifecycle<HippoBean> {

	}
}
