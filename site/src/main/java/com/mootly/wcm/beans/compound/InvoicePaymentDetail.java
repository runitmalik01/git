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
/**
 * 
 * User: megha
 * Date: march 04, 2013
 * Time: 11:26:35 AM
 * 
 */

package com.mootly.wcm.beans.compound;
import static com.mootly.wcm.utils.Constants.NT_PERSONAL_INFO_LINK;

import java.math.BigInteger;
import java.util.Calendar;

import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.version.VersionException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoItem;
import org.hippoecm.hst.content.beans.standard.HippoMirror;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.BeanClone;
import com.mootly.wcm.annotations.CalculatedField;
import com.mootly.wcm.annotations.FormField;
import com.mootly.wcm.annotations.NodeBinder;
import com.mootly.wcm.annotations.TagAsTaxDataProvider;
import com.mootly.wcm.annotations.TagAsTaxDataProvider.TaxDataProviderType;
import com.mootly.wcm.annotations.prop.FormMapKey;
import com.mootly.wcm.beans.BaseDocument;
import com.mootly.wcm.beans.FormMapFiller;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.standard.FlexibleDocument;
import com.mootly.wcm.model.PaymentType;
import com.mootly.wcm.model.PaymentVerificationStatus;
import com.mootly.wcm.services.FormMapHelper;
import com.mootly.wcm.utils.BeanCloneHelper;
import com.mootly.wcm.utils.CalculatedFieldHelper;
import com.mootly.wcm.utils.NodeBinderHelper;


@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:invoicepaymentdetail")
@TagAsTaxDataProvider(type=TaxDataProviderType.INCOME)
public class InvoicePaymentDetail extends FlexibleDocument implements FormMapFiller {
	static final public String NODE_NAME = InvoicePaymentDetail.class.getName().toLowerCase();
	private final static Logger log = LoggerFactory.getLogger(InvoicePaymentDetail.class); 

	private Calendar paymentDate;
	private PaymentType paymentType;
	private Double paymentAmount;
	private String paymentTransactionId;
	private String paymentNotes;
	private String paymentInternalNotes;
	
	//if by BANK
	private String checkNo;
	private String checkDate;
	private String checkBank;
	private String checkBranch;
	private String checkLocation;
	
	//cash fields
	private String cashAddress;
	private String cashContactNumber;
	private String cashBestTime;
	
	//RTGS
	private String rtgsDate;
	private Double rtgsAmount;
	private String rtgsTime;
	private String rtgsTransNumber;
		
	
	PaymentVerificationStatus paymentVerificationStatus; 
	
	final String PROP_PAYMENT_VERIFICATION_STATUS = "mootlywcm:paymentVerificationStatus";
	
	private boolean markedForDeletion;
	
	final String PROP_CHECK_NO = "mootlywcm:checkNo";
	final String PROP_CHECK_DATE = "mootlywcm:checkDate";
	final String PROP_CHECK_BANK = "mootlywcm:checkBank";
	final String PROP_CHECK_BRANCH = "mootlywcm:checkBranch";
	final String PROP_CHECK_LOCATION = "mootlywcm:checkLocation";
	
	final String PROP_CASH_ADDRESS = "mootlywcm:cashAddress";
	final String PROP_CASH_CONTACT_NUMBER = "mootlywcm:cashContactNumber";
	final String PROP_CASH_BEST_TIME = "mootlywcm:cashBestTime";
	
	final String PROP_RTGS_TRANSNUMBER = "mootlywcm:rtgsTransNumber";
	final String PROP_RTGS_DATE = "mootlywcm:rtgsDate";
	final String PROP_RTGS_AMOUNT = "mootlywcm:rtgsAmount";
	final String PROP_RTGS_TIME = "mootlywcm:crtgsTime";
	
	public final boolean isMarkedForDeletion() {
		return markedForDeletion;
	}
	
	@FormField(name="paymentDate",propertyName="paymentDate",dataTypeValidationTypes={})
	@NodeBinder(nodePropertyName="mootlywcm:paymentDate",propertyName="paymentDate")	
	public Calendar getPaymentDate() {
		if (paymentDate == null) NodeBinderHelper.setObjectProperty("paymentDate", this, null);
		return paymentDate;
	}


	@FormField(name="paymentAmount",propertyName="paymentAmount",dataTypeValidationTypes={})
	@NodeBinder(nodePropertyName="mootlywcm:paymentAmount",propertyName="paymentAmount")
	public Double getPaymentAmount() {
		if (paymentAmount == null) NodeBinderHelper.setObjectProperty("paymentAmount", this, 0D);
		return paymentAmount;
	}
	
	@FormField(name="paymentTransactionId",propertyName="paymentTransactionId",dataTypeValidationTypes={})
	@NodeBinder(nodePropertyName="mootlywcm:paymentTransactionId",propertyName="paymentTransactionId")
	public String getPaymentTransactionId() {
		if (paymentTransactionId == null) NodeBinderHelper.setObjectProperty("paymentTransactionId", this, "");
		return paymentTransactionId;
	}

	@FormField(name="paymentNotes",propertyName="paymentNotes",dataTypeValidationTypes={})
	@NodeBinder(nodePropertyName="mootlywcm:paymentNotes",propertyName="paymentNotes")
	public String getPaymentNotes() {
		if (paymentNotes == null) NodeBinderHelper.setObjectProperty("paymentNotes", this, "");
		return paymentNotes;
	}

	@FormField(name="paymentInternalNotes",propertyName="paymentInternalNotes",dataTypeValidationTypes={})
	@NodeBinder(nodePropertyName="mootlywcm:paymentInternalNotes",propertyName="paymentInternalNotes")
	public String getPaymentInternalNotes() {
		if (paymentInternalNotes == null) NodeBinderHelper.setObjectProperty("paymentInternalNotes", this, "");
		return paymentInternalNotes;
	}
	

	//@FormField(name="paymentType",propertyName="paymentType",dataTypeValidationTypes={})
	@NodeBinder(nodePropertyName="mootlywcm:paymentType",propertyName="paymentType")
	public PaymentType getPaymentType() {
		if (paymentType == null) {
    		String strPaymentType = getProperty("mootlywcm:paymentType");
    		if (strPaymentType != null) {
    			try { paymentType =  PaymentType.valueOf(strPaymentType); }catch (IllegalArgumentException e) {}
    		}
    	}
		return paymentType;
	}
	//"checkNo","checkDate","checkBank","checkBranch","checkLocation"
	@FormField(name="checkNo",propertyName="checkNo")
	@NodeBinder(nodePropertyName=PROP_CHECK_NO)
	public String getCheckNo() {
		if (checkNo == null) checkNo = getProperty(PROP_CHECK_NO);
		return checkNo;
	}
	
	@FormField(name="checkDate",propertyName="checkDate")
	@NodeBinder(nodePropertyName=PROP_CHECK_DATE)	
	public String getCheckDate() {
		if (checkDate == null) checkDate = getProperty(PROP_CHECK_DATE);
		return checkDate;
	}
	
	@FormField(name="checkBank",propertyName="checkBank")
	@NodeBinder(nodePropertyName=PROP_CHECK_BANK)	
	public String getCheckBank() {
		if (checkBank == null) checkBank = getProperty(PROP_CHECK_BANK);
		return checkBank;
	}
	
	@FormField(name="checkBranch",propertyName="checkBranch")
	@NodeBinder(nodePropertyName=PROP_CHECK_BRANCH)	
	public String getCheckBranch() {
		if (checkBranch == null) checkBranch = getProperty(PROP_CHECK_BRANCH);
		return checkBranch;
	}
	
	@FormField(name="checkLocation",propertyName="checkLocation")
	@NodeBinder(nodePropertyName=PROP_CHECK_LOCATION)	
	public String getCheckLocation() {
		if (checkLocation == null) checkLocation = getProperty(PROP_CHECK_LOCATION);
		return checkLocation;
	}

	//"cashAddress","cashContactNumber","cashBestTime"
	@FormField(name="cashAddress",propertyName="cashAddress")
	@NodeBinder(nodePropertyName=PROP_CASH_ADDRESS)	
	public String getCashAddress() {
		if (cashAddress == null) cashAddress = getProperty(PROP_CASH_ADDRESS);
		return cashAddress;
	}

	@FormField(name="cashContactNumber",propertyName="cashContactNumber")
	@NodeBinder(nodePropertyName=PROP_CASH_CONTACT_NUMBER)	
	public String getCashContactNumber() {
		if (cashContactNumber == null) cashContactNumber = getProperty(PROP_CASH_CONTACT_NUMBER);
		return cashContactNumber;
	}

	@FormField(name="cashBestTime",propertyName="cashBestTime")
	@NodeBinder(nodePropertyName=PROP_CASH_BEST_TIME)	
	public String getCashBestTime() {
		if (cashBestTime == null) cashBestTime = getProperty(PROP_CASH_BEST_TIME);
		return cashBestTime;
	}
	
	//"rtgsTransNumber","rtgsDate","rtgsAmount","rtgsTime"
	@FormField(name="rtgsDate",propertyName="rtgsDate")
	@NodeBinder(nodePropertyName=PROP_RTGS_DATE)
	public String getRtgsDate() {
		if (rtgsDate == null) rtgsDate = getProperty(PROP_RTGS_DATE);
		return rtgsDate;
	}

	@FormField(name="rtgsAmount",propertyName="rtgsAmount")
	@NodeBinder(nodePropertyName=PROP_RTGS_AMOUNT)
	public Double getRtgsAmount() {
		if (rtgsAmount == null) rtgsAmount = getProperty(PROP_RTGS_AMOUNT);
		return rtgsAmount;
	}

	@FormField(name="rtgsTime",propertyName="rtgsTime")
	@NodeBinder(nodePropertyName=PROP_RTGS_TIME)
	public String getRtgsTime() {
		if (rtgsTime == null) rtgsTime = getProperty(PROP_RTGS_TIME);
		return rtgsTime;
	}

	@FormField(name="rtgsTransNumber",propertyName="rtgsTransNumber")
	@NodeBinder(nodePropertyName=PROP_RTGS_TRANSNUMBER)
	public String getRtgsTransNumber() {
		if (rtgsTransNumber == null) rtgsTransNumber = getProperty(PROP_RTGS_TRANSNUMBER);
		return rtgsTransNumber;
	}
	
	@NodeBinder(nodePropertyName=PROP_PAYMENT_VERIFICATION_STATUS)
	public PaymentVerificationStatus getPaymentVerificationStatus() {
		if (paymentVerificationStatus == null) {
    		String strPaymentVerificationStatus = getProperty(PROP_PAYMENT_VERIFICATION_STATUS);
    		if (strPaymentVerificationStatus != null) {
    			try { paymentVerificationStatus =  PaymentVerificationStatus.valueOf(strPaymentVerificationStatus); }catch (IllegalArgumentException e) {}
    		}
    	}
		return paymentVerificationStatus;
	}

	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}

	@BeanClone
	public void setPaymentDate(Calendar paymentDate) {
		this.paymentDate = paymentDate;
	}

	@BeanClone
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	@BeanClone
	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	@BeanClone
	public void setPaymentTransactionId(String paymentTransactionId) {
		this.paymentTransactionId = paymentTransactionId;
	}

	@BeanClone
	public void setPaymentNotes(String paymentNotes) {
		this.paymentNotes = paymentNotes;
	}

	@BeanClone
	public void setPaymentInternalNotes(String paymentInternalNotes) {
		this.paymentInternalNotes = paymentInternalNotes;
	}
	
	@BeanClone
	public void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
	}

	@BeanClone
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	@BeanClone
	public void setCheckBank(String checkBank) {
		this.checkBank = checkBank;
	}

	@BeanClone
	public void setCheckBranch(String checkBranch) {
		this.checkBranch = checkBranch;
	}

	@BeanClone
	public void setCheckLocation(String checkLocation) {
		this.checkLocation = checkLocation;
	}
	
	@BeanClone
	public void setCashAddress(String cashAddress) {
		this.cashAddress = cashAddress;
	}

	@BeanClone
	public void setCashContactNumber(String cashContactNumber) {
		this.cashContactNumber = cashContactNumber;
	}

	@BeanClone
	public void setCashBestTime(String cashBestTime) {
		this.cashBestTime = cashBestTime;
	}
	
	@BeanClone
	public final void setRtgsDate(String rtgsDate) {
		this.rtgsDate = rtgsDate;
	}

	@BeanClone
	public final void setRtgsAmount(Double rtgsAmount) {
		this.rtgsAmount = rtgsAmount;
	}

	@BeanClone
	public final void setRtgsTime(String rtgsTime) {
		this.rtgsTime = rtgsTime;
	}

	@BeanClone
	public final void setRtgsTransNumber(String rtgsTransNumber) {
		this.rtgsTransNumber = rtgsTransNumber;
	}
	
	@BeanClone
	public void setPaymentVerificationStatus(
			PaymentVerificationStatus paymentVerificationStatus) {
		this.paymentVerificationStatus = paymentVerificationStatus;
	}

	public boolean bindToNode(javax.jcr.Node node) throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		//try {
		super.bindToNode(node);
		NodeBinderHelper nodeBinderHelper = new NodeBinderHelper();
		nodeBinderHelper.bindObjectToNode(node, this);
		try {
			
			if (getPaymentType() != null) node.setProperty("mootlywcm:paymentType", getPaymentType().name());
			if (getPaymentVerificationStatus() != null) node.setProperty(PROP_PAYMENT_VERIFICATION_STATUS, getPaymentVerificationStatus().name());
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
		InvoicePaymentDetail objinvoiceDetail = (InvoicePaymentDetail) sourceBean;
		super.cloneBean(sourceBean);
		BeanCloneHelper beanCloneHelper = new BeanCloneHelper();
		beanCloneHelper.cloneTheBean(sourceBean,this);
		
		if (log.isInfoEnabled()) {
			log.info("The cloning is done");
		}
	}
}
