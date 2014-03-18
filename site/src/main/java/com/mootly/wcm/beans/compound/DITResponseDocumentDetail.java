/**
 * Copyright (C) 2010 Hippo B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mootly.wcm.beans.compound;

import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.version.VersionException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.BeanClone;
import com.mootly.wcm.annotations.FormField;
import com.mootly.wcm.beans.FormMapFiller;
import com.mootly.wcm.beans.standard.FlexibleDocument;
import com.mootly.wcm.model.DITSOAPOperation;
import com.mootly.wcm.services.FormMapHelper;
import com.mootly.wcm.utils.BeanCloneHelper;
import com.mootly.wcm.utils.CalculatedFieldHelper;

/**
 * User: vivek
 * Date: Jun 29, 2010
 * Time: 11:26:35 AM
 */

@SuppressWarnings("unused")
@Node(jcrType="mootlywcm:ditResponseDocumentDetail")
public class DITResponseDocumentDetail extends FlexibleDocument implements FormMapFiller {
	
	static final private Logger log = LoggerFactory.getLogger(DITResponseDocumentDetail.class);
	
	String soapOperation;
	String soapRequest;
	String soapResponse;
	String verificationStatus;
	String ditSubmissionStatus;
	String eFileDateTime;
	String ackResponse;
	String result;
	Boolean isFault;
	
	FormMap soapOutputMap = null;
	
	DITSOAPOperation ditSOperation;
	
	private boolean markedForDeletion;
	
	static final String SOAP_OPERATION = "mootlywcm:soapOperation";
	static final String SOAP_REQUEST_NAMESPACE = "mootlywcm:soapRequest";
	static final String SOAP_RESPONSE_NAMESPACE = "mootlywcm:soapResponse";
	static final String SOAP_IS_FAULT = "mootlywcm:isFault";
	static final String SOAP_DIT_SUBMISSION_STATUS = "mootlywcm:ditSubmissionStatus";
	static final String SOAP_EFILE_DATETIME= "mootlywcm:eFileDateTime";
	
	static final String SOAP_ACK_RESPONSE = "mootlywcm:ackResponse";
	static final String SOAP_RESULT = "mootlywcm:result";
	
	
	@FormField(name="soapOperation")
	public final String getSoapOperation() {
		if (soapOperation == null) soapOperation = getProperty(SOAP_OPERATION);
		return soapOperation;
	}
	
	public String getVerificationStatus() {
		if (verificationStatus == null) verificationStatus = getProperty("mootlywcm:verificationStatus");
		return verificationStatus;
	}
	
	@FormField(name="soapRequest")
	public final String getSoapRequest() {
		if (soapRequest == null) soapRequest = getProperty(SOAP_REQUEST_NAMESPACE);
		return soapRequest;
	}
	
	@FormField(name="soapResponse")
	public final String getSoapResponse() {
		if (soapResponse == null) soapResponse = getProperty(SOAP_RESPONSE_NAMESPACE);
		return soapResponse;
	}
	
	@FormField(name="isFault")
	public final Boolean getIsFault() {
		if (isFault == null) isFault = getProperty(SOAP_IS_FAULT);
		return isFault;
	}
	
	public DITSOAPOperation getDitSOperation() {
		getSoapOperation();
		if (soapOperation != null && !"".equals(soapOperation.trim()) ) {
			ditSOperation = DITSOAPOperation.valueOf(soapOperation);
		}
		return ditSOperation;
	}
	
	public String getDitSubmissionStatus() {
		if (ditSubmissionStatus == null) ditSubmissionStatus = getProperty(SOAP_DIT_SUBMISSION_STATUS);
		return ditSubmissionStatus;
	}
	
	public String geteFileDateTime() {
		if (eFileDateTime == null) eFileDateTime = getProperty(SOAP_EFILE_DATETIME);
		return eFileDateTime;
	}
	
	public String getAckResponse() {
		if (ackResponse == null) ackResponse = getProperty(SOAP_ACK_RESPONSE);
		return ackResponse;
	}

	public String getResult() {
		if (result == null) result = getProperty(SOAP_RESULT);
		return result;
	}

	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}

	@BeanClone
	public final void setIsFault(Boolean isFault) {
		this.isFault = isFault;
	}
	
	@BeanClone
	public final void setSoapRequest(String soapRequest) {
		this.soapRequest = soapRequest;
	}
	
	@BeanClone
	public final void setSoapResponse(String soapResponse) {
		this.soapResponse = soapResponse;
	}
	
	@BeanClone
	public final void setSoapOperation(String soapOperation) {
		this.soapOperation = soapOperation;
	}
	
	public void setDitSOperation(DITSOAPOperation ditSOperation) {
		this.ditSOperation = ditSOperation;
	}

	
	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
	
	public FormMap getSoapOutputMap() {
		return soapOutputMap;
	}

	public void setSoapOutputMap(FormMap soapOutputMap) {
		this.soapOutputMap = soapOutputMap;
	}

	@Override
	public boolean bindToNode(javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		super.bindToNode(node);
		try {
			if (getSoapRequest() != null) node.setProperty(SOAP_REQUEST_NAMESPACE, getSoapRequest());
			if (getSoapResponse() != null) node.setProperty(SOAP_RESPONSE_NAMESPACE,getSoapResponse());
			if (getSoapOperation() != null) node.setProperty(SOAP_OPERATION,getSoapOperation());
			if (getIsFault() != null) node.setProperty(SOAP_IS_FAULT,getIsFault().toString());
			if (soapOutputMap != null && soapOutputMap.getFormMap() != null && soapOutputMap.getFormMap().size() > 0 ){
				for (String fieldName:soapOutputMap.getFormMap().keySet()) {
					try {
						String theFieldName = fieldName;
						if (!fieldName.startsWith("mootlywcm:")) {
							theFieldName = "mootlywcm:" + theFieldName;
						}
						if (theFieldName.equals("mootlywcm:soapOperation") || theFieldName.equals("mootlywcm:soapRequest") || theFieldName.equals("mootlywcm:soapResponse") ||  theFieldName.equals("mootlywcm:isFault")  ) {
							continue;
						}
						node.setProperty(theFieldName, soapOutputMap.getField(fieldName).getValue());
					}catch (Exception e) {
						log.error("There was an error",e);
					}
				}
			}
		} catch (ValueFormatException e) {
			// TODO Auto-generated catch block
			log.error("Error in bindToNode",e);
		} catch (VersionException e) {
			// TODO Auto-generated catch block
			log.error("Error in bindToNode",e);
		} catch (LockException e) {
			// TODO Auto-generated catch block
			log.error("Error in bindToNode",e);
		} catch (ConstraintViolationException e) {
			// TODO Auto-generated catch block
			log.error("Error in bindToNode",e);
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			log.error("Error in bindToNode",e);
		}
		return true;
	}
	
	
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (formMap == null) return;
		super.fill(formMap);
		FormMapHelper formMapHelper = new FormMapHelper();
		formMapHelper.fillFromFormMap(this, formMap);
		CalculatedFieldHelper calculatedFieldHelper = new CalculatedFieldHelper();
		calculatedFieldHelper.processCalculatedFields(this);
		soapOutputMap = formMap;
	}

	
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		DITResponseDocumentDetail ditResponseDocumentDetail = (DITResponseDocumentDetail) sourceBean;
		super.cloneBean(sourceBean);
		BeanCloneHelper beanCloneHelper = new BeanCloneHelper();
		beanCloneHelper.cloneTheBean(sourceBean,this);
		
		if (ditResponseDocumentDetail.getProperties() != null){
			FormMap formMap = new FormMap();
			for (String key:ditResponseDocumentDetail.getProperties().keySet()) {
				if (key.equals("mootlywcm:soapOperation") || key.equals("mootlywcm:soapRequest") || key.equals("mootlywcm:soapResponse") ||  key.equals("mootlywcm:isFault")  ) {
					continue;
				}
				Object thePropValue = ditResponseDocumentDetail.getProperty(key);
				if ( thePropValue != null && thePropValue instanceof String) {
					String fieldName = key;
					if (fieldName.startsWith("mootlywcm:")) {
						fieldName = fieldName.substring("mootlywcm:".length());
					}
					org.hippoecm.hst.component.support.forms.FormField formField = new org.hippoecm.hst.component.support.forms.FormField(fieldName);
					formField.addValue((String) thePropValue);
					formMap.addFormField(formField);
				}
			}
			if (ditResponseDocumentDetail.getSoapOutputMap() != null && ditResponseDocumentDetail.getSoapOutputMap().getFormMap() != null) formMap.getFormMap().putAll(ditResponseDocumentDetail.getSoapOutputMap().getFormMap());
			setSoapOutputMap(formMap);
		}
		
		if (log.isInfoEnabled()) {
			log.info("The cloning is done");
		}
	}
	
}