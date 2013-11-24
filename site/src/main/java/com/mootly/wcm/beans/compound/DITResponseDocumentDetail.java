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

import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.version.VersionException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.annotations.BeanClone;
import com.mootly.wcm.annotations.FormField;
import com.mootly.wcm.beans.FormMapFiller;
import com.mootly.wcm.beans.standard.FlexibleDocument;
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
	
	public static enum DITSOAPOperation { getTDSDetails };
	
	String soapOperation;
	String soapRequest;
	String soapResponse;
	
	DITSOAPOperation ditSOperation;
	
	private boolean markedForDeletion;
	
	static final String SOAP_OPERATION = "mootlywcm:soapOperation";
	static final String SOAP_REQUEST_NAMESPACE = "mootlywcm:soapRequest";
	static final String SOAP_RESPONSE_NAMESPACE = "mootlywcm:soapResponse";
	
	
	@FormField(name="soapOperation")
	public final String getSoapOperation() {
		if (soapOperation == null) soapOperation = getProperty(SOAP_OPERATION);
		return soapOperation;
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
	
	public DITSOAPOperation getDitSOperation() {
		return ditSOperation;
	}
	
	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
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
	
	@Override
	public boolean bindToNode(javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		super.bindToNode(node);
		try {
			if (getSoapRequest() != null) node.setProperty(SOAP_REQUEST_NAMESPACE, getSoapRequest());
			if (getSoapResponse() != null) node.setProperty(SOAP_REQUEST_NAMESPACE,getSoapRequest());
			if (getSoapOperation() != null) node.setProperty(SOAP_OPERATION,getSoapOperation());
		} catch (ValueFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (VersionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LockException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ConstraintViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	}

	
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		DITResponseDocumentDetail objinvoiceDetail = (DITResponseDocumentDetail) sourceBean;
		super.cloneBean(sourceBean);
		BeanCloneHelper beanCloneHelper = new BeanCloneHelper();
		beanCloneHelper.cloneTheBean(sourceBean,this);
		
		if (log.isInfoEnabled()) {
			log.info("The cloning is done");
		}
	}
	
}