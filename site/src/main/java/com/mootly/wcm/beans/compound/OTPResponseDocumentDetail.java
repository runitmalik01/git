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

import java.util.Calendar;
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
@Node(jcrType="mootlywcm:otpResponseDocumentDetail")
public class OTPResponseDocumentDetail extends FlexibleDocument implements FormMapFiller {
	
	static final private Logger log = LoggerFactory.getLogger(OTPResponseDocumentDetail.class);
	
	String refId;
	String token;
	String mobileNumber;
	Calendar expiryTime;
	Calendar verificationTime;
	Calendar userEntryTime;
	boolean isVerified;
	
	private boolean markedForDeletion;
	
	final String REF_ID_FIELD = "mootlywcm:refId";
	final String TOKEN_FIELD = "mootlywcm:token";
	final String MOBILE_NUMBER_FIELD = "mootlywcm:mobileNumber";
	final String EXPIRY_TIME_FIELD = "mootlywcm:expiryTime";
	final String VERIFICATION_TIME_FIELD = "mootlywcm:verificationTime";
	final String USER_ENTRY_TIME_FIELD = "mootlywcm:userEntryTime";
	
	@FormField(name="refId")
	public String getRefId() {
		if (refId == null) refId = getProperty(REF_ID_FIELD);
		return refId;
	}

	@FormField(name="token")
	public String getToken() {
		if (token == null) token = getProperty(TOKEN_FIELD);
		return token;
	}

	@FormField(name="mobileNumber")
	public String getMobileNumber() {
		if (mobileNumber == null) mobileNumber = getProperty(MOBILE_NUMBER_FIELD);
		return mobileNumber;
	}
	
	@FormField(name="expiryTime")
	public Calendar getExpiryTime() {
		if (expiryTime == null) expiryTime = getProperty(EXPIRY_TIME_FIELD);
		return expiryTime;
	}

	
	public Calendar getVerificationTime() {
		if (verificationTime == null) verificationTime = getProperty(VERIFICATION_TIME_FIELD);
		return verificationTime;
	}
	
	public Calendar getUserEntryTime() {
		if (userEntryTime == null) userEntryTime = getProperty(USER_ENTRY_TIME_FIELD);
		return userEntryTime;
	}
	
	public boolean isMarkedForDeletion() {
		return markedForDeletion;
	}

	
	@BeanClone
	public void setUserEntryTime(Calendar userEntryTime) {
		this.userEntryTime = userEntryTime;
	}

	@BeanClone
	public void setRefId(String refId) {
		this.refId = refId;
	}

	@BeanClone
	public void setOtp(String token) {
		this.token = token;
	}
	
	@BeanClone
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@BeanClone
	public void setExpiryTime(Calendar expiryTime) {
		this.expiryTime = expiryTime;
	}

	@BeanClone
	public void setVerificationTime(Calendar verificationTime) {
		this.verificationTime = verificationTime;
	}

	public void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}


	@Override
	public boolean bindToNode(javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		super.bindToNode(node);
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
		OTPResponseDocumentDetail ditResponseDocumentDetail = (OTPResponseDocumentDetail) sourceBean;
		super.cloneBean(sourceBean);
		BeanCloneHelper beanCloneHelper = new BeanCloneHelper();
		beanCloneHelper.cloneTheBean(sourceBean,this);
	}
}