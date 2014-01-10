package com.mootly.wcm.services.ditws.impl;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.Session;

import org.hippoecm.hst.component.support.forms.FormField;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.DITResponseDocument;
import com.mootly.wcm.beans.compound.DITResponseDocumentDetail;
import com.mootly.wcm.beans.events.BeanLifecycle;
import com.mootly.wcm.components.ITReturnComponentHelper;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.ditws.DITSOAPService;
import com.mootly.wcm.services.ditws.soap.SOAPService;

public abstract class DITSOAPServiceImpl implements DITSOAPService{
	Logger logger = LoggerFactory.getLogger(DITSOAPService.class);
	
	public void updateInputParamValues(Map<String,String> inputParamValues) {
		if (inputParamValues == null) inputParamValues = new HashMap<String, String>();
		
		inputParamValues. put(PARAM_USER_NAME, getUserName());
		inputParamValues.put(PARAM_PASSWORD, getPassword());
		
		inputParamValues.put(PARAM_CERT_CHAIN, getCertChain());
		inputParamValues.put(PARAM_SIGNATURE, getSignature());
		
	}
	
	public String getPANFromAbsoluteReturnPath(String absoluteBasePathToReturnDocuments) {
		if (absoluteBasePathToReturnDocuments != null) {
			String[] parts = absoluteBasePathToReturnDocuments.split("[/]");
			if (parts.length >= 3) {
				return parts[parts.length - 3];
			}
			else {
				return null;
			}
		}
		return null;
	}
	
	public String getPathSuffixOfReturnDocuments(String absoluteBasePathToReturnDocuments) {
		if (absoluteBasePathToReturnDocuments != null) {
			String[] parts = absoluteBasePathToReturnDocuments.split("[/]");
			if (parts.length >= 3) {
				return parts[parts.length - 3] + "/" + parts[parts.length - 2] + "/" + parts[parts.length - 1];
			}
			else {
				return null;
			}
		}
		return null;
	}
	
	//final ITReturnComponentHelper itReturnComponentHelper;
	//final boolean saveAllSOAPReuqestToFileSystem;
	//final boolean soapRequestSavaLocation;
	//final boolean saveAllSOAPRequestToRepository;
	public DITSOAPServiceImpl(String userName,String password,String certChain,String signature,SOAPService soapService
			,ITReturnComponentHelper itReturnComponentHelper,boolean saveAllSOAPReuqestToFileSystem,  String soapRequestSaveLocation,  boolean saveAllSOAPRequestToRepository) {
		this.userName = userName;
		this.password = password;
		this.certChain = certChain;
		this.signature = signature;
		this.soapService = soapService;
		
		this.itReturnComponentHelper = itReturnComponentHelper;
		
		this.saveAllSOAPReuqestToFileSystem = saveAllSOAPReuqestToFileSystem;
		this.saveAllSOAPRequestToRepository = saveAllSOAPRequestToRepository;
		this.soapRequestSaveLocation = soapRequestSaveLocation;
	}
	
	public ITReturnComponentHelper getItReturnComponentHelper() {
		return itReturnComponentHelper;
	}


	public boolean isSaveAllSOAPReuqestToFileSystem() {
		return saveAllSOAPReuqestToFileSystem;
	}

	public boolean isSaveAllSOAPRequestToRepository() {
		return saveAllSOAPRequestToRepository;
	}
	
	public String getSoapRequestSaveLocation() {
		return soapRequestSaveLocation;
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return userName;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	@Override
	public SOAPService getSoapService() {
		return soapService;
	}


	@Override
	public String getCertChain() {
		// TODO Auto-generated method stub
		return certChain;
	}


	@Override
	public String getSignature() {
		// TODO Auto-generated method stub
		return signature;
	}

	public final void setUserName(String userName) {
		this.userName = userName;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	public final void setCertChain(String certChain) {
		this.certChain = certChain;
	}

	public final void setSignature(String signature) {
		this.signature = signature;
	}
	
	public void saveSOAPRequestToRepository(String soapOperation,String absoluteBasePathToReturnDocuments , WorkflowPersistenceManager wpm,Map<String,Object> outputMapSOAPResponse) {
		if (getItReturnComponentHelper() == null) {
			logger.warn("ITReturnComponentHelper is null. Please check Spring Dependency Injection");
			return;
		}
		Session persistableSession = null;
		try {
			if (absoluteBasePathToReturnDocuments == null) {
				logger.warn("absoluteBasePathToReturnDocuments is null");
				return;
			}
			if (outputMapSOAPResponse == null || outputMapSOAPResponse.size() == 0) {
				return;
			}
			FormMap theMapForSOAPResponse = new FormMap();
			for (String key:outputMapSOAPResponse.keySet()) {
				Object theObj = outputMapSOAPResponse.get(key);
				if (theObj instanceof String) {
					FormField formField = new FormField(key);
					formField.addValue((String) theObj);
					theMapForSOAPResponse.addFormField(formField);
				}
			}
			FormField theSOAPOperation = new FormField("soapOperation");
			theSOAPOperation.addValue(soapOperation);
			theMapForSOAPResponse.addFormField(theSOAPOperation);
			
			persistableSession = wpm.getSession();
			BeanLifecycle<HippoBean> childBeanLifeCycleHandler = null;
			BeanLifecycle<HippoBean> parentBeanLifeCycleHandler = null;
			String parentBeanAbsolutePath = absoluteBasePathToReturnDocuments + "/" + DITResponseDocument.class.getSimpleName().toLowerCase();
			String parentBeanNameSpace = "mootlywcm:ditResponseDocument";
			String parentBeanNodeName = DITResponseDocument.class.getSimpleName().toLowerCase();
			getItReturnComponentHelper().saveAddNewChild(theMapForSOAPResponse, null, null, null, absoluteBasePathToReturnDocuments, parentBeanAbsolutePath, parentBeanNameSpace, parentBeanNodeName, DITResponseDocumentDetail.class, wpm.getSession(), wpm);
			
		}catch (Exception e) {
			logger.error("Error saving SOAP Requests to Repository",e);
		}
		finally {
			if (persistableSession != null) try {persistableSession.logout();}catch (Exception e) {}
		}
		
	}

	String userName;
	String password;
	String certChain;
	String signature;
	final SOAPService soapService;
	
	final ITReturnComponentHelper itReturnComponentHelper;
	final boolean saveAllSOAPReuqestToFileSystem;
	final String soapRequestSaveLocation;
	final boolean saveAllSOAPRequestToRepository;
	
}
