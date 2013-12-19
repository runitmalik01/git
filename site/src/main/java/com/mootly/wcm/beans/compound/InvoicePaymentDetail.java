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
import com.mootly.wcm.services.citruspay.Transaction;
import com.mootly.wcm.services.citruspay.Transaction.ENQUIRY_RESP_CODE;
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
	private String paymentTypeStr;
	private Double paymentAmount;
	private String paymentTransactionId;
	private String paymentNotes;
	private String paymentInternalNotes;
	
	//if paid by gateway these are very important fields
	//remember the user can make a payment for 5000 but we must check what was actual transaction amount from the gateway
	private Transaction.ENQUIRY_RESP_CODE respCode;
	private String respCodeStr;
	private String respMsg;
	private String pgTxnId;
	private String authIdCode;
	private String rrn;
	private String txnType;
	private Double txnAmount;
	private String txnDateTime; 
	private String netBankingCode;
	
	//if by BANK
	private String checkNo;
	private String checkDate;
	private String checkBank;
	private String checkBranch;
	private String checkLocation;
	private Double checkAmount;
	
	//cash fields
	private String cashAddress;
	private String cashContactNumber;
	private String cashBestTime;
	private Double cashAmount;
	
	//RTGS
	private String rtgsDate;
	private Double rtgsAmount;
	private String rtgsTime;
	private String rtgsTransNumber;
		
	
	PaymentVerificationStatus paymentVerificationStatus; 
	String paymentVerificationStatusStr;
	
	final String PROP_PAYMENT_VERIFICATION_STATUS = "mootlywcm:paymentVerificationStatus";
	
	private boolean markedForDeletion;
	
	//citrus specific fields
	public static final String PROP_RESP_CODE = "mootlywcm:respCode";
	public static final String PROP_RESP_MSG = "mootlywcm:respMsg";
	public static final String PROP_PG_TXN_ID = "mootlywcm:pgTxnId";
	public static final String PROP_AUTH_ID_CODE = "mootlywcm:authIdCode";
	public static final String PROP_RRN = "mootlywcm:rrn";
	public static final String PROP_TXN_TYPE = "mootlywcm:txnType";
	public static final String PROP_TXN_AMOUNT = "mootlywcm:txnAmount";
	public static final String PROP_TXN_DATETIME = "mootlywcm:txnDateTime";
	public static final String PROP_NET_BANKING_CODE= "mootlywcm:netBankingCode";
	
	final String PROP_CHECK_NO = "mootlywcm:checkNo";
	final String PROP_CHECK_DATE = "mootlywcm:checkDate";
	final String PROP_CHECK_BANK = "mootlywcm:checkBank";
	final String PROP_CHECK_BRANCH = "mootlywcm:checkBranch";
	final String PROP_CHECK_LOCATION = "mootlywcm:checkLocation";
	final String PROP_CHECK_AMOUNT = "mootlywcm:checkAmount";
	
	final String PROP_CASH_ADDRESS = "mootlywcm:cashAddress";
	final String PROP_CASH_CONTACT_NUMBER = "mootlywcm:cashContactNumber";
	final String PROP_CASH_BEST_TIME = "mootlywcm:cashBestTime";
	final String PROP_CASH_AMOUNT = "mootlywcm:cashAmount";
	
	final String PROP_RTGS_TRANSNUMBER = "mootlywcm:rtgsTransNumber";
	final String PROP_RTGS_DATE = "mootlywcm:rtgsDate";
	final String PROP_RTGS_AMOUNT = "mootlywcm:rtgsAmount";
	final String PROP_RTGS_TIME = "mootlywcm:rtgsTime";
	
	/** 
	 * Is this a valid return
	 * @return
	 */
	public final boolean isValid() {
		if (getPaymentVerificationStatus() != null && getPaymentVerificationStatus() == PaymentVerificationStatus.VERIFIED && isSuccess()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public final boolean getRequiresGateway() {
		if (getPaymentType() != null && (getPaymentType() == PaymentType.NET_BANKING || getPaymentType() == PaymentType.DEBIT_CARD  || getPaymentType() == PaymentType.CREDIT_CARD ) ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * This is only useful for payment gateway transactions
	 * @return
	 */
	public final boolean isSuccess() {
		if (getRequiresGateway() ) {
			if (getRespCode() != null && getRespCode() == ENQUIRY_RESP_CODE.SUCCESS) {
				return true;
			}
			else {
				return false;
			}
		}
		return true; 
	}
	
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
	
	public PaymentType getPaymentType() {
		if (paymentType == null) {
    		String strPaymentType = getProperty("mootlywcm:paymentType");
    		if (strPaymentType != null) {
    			try { paymentType =  PaymentType.valueOf(strPaymentType); }catch (IllegalArgumentException e) {}
    		}
    	}
		return paymentType;
	}
	
	@NodeBinder(nodePropertyName="mootlywcm:paymentType",propertyName="paymentTypeStr")
	public final String getPaymentTypeStr() {
		if ( paymentTypeStr == null) {
			paymentTypeStr = getProperty("mootlywcm:paymentType");;
		}
		return paymentTypeStr;
	}

	//"checkNo","checkDate","checkBank","checkBranch","checkLocation","checkAmount"
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
	
	@FormField(name="checkAmount",propertyName="checkAmount")
	@NodeBinder(nodePropertyName=PROP_CHECK_AMOUNT)	
	public Double getCheckAmount() {
		if (checkAmount == null) checkAmount = getProperty(PROP_CHECK_AMOUNT);
		return checkAmount;
	}

	//"cashAddress","cashContactNumber","cashBestTime","cashAmount"
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
	
	@FormField(name="cashAmount",propertyName="cashAmount")
	@NodeBinder(nodePropertyName=PROP_CASH_AMOUNT)	
	public Double getCashAmount() {
		if (cashAmount == null) cashAmount = getProperty(PROP_CASH_AMOUNT);
		return cashAmount;
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
		if (rtgsAmount == null) {
			rtgsAmount = getProperty(PROP_RTGS_AMOUNT);
		}
		if (rtgsAmount == null) rtgsAmount = 0.0D;
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
	
	
	public PaymentVerificationStatus getPaymentVerificationStatus() {
		if (paymentVerificationStatus == null) {
    		String strPaymentVerificationStatus = getProperty(PROP_PAYMENT_VERIFICATION_STATUS);
    		if (strPaymentVerificationStatus != null) {
    			try { paymentVerificationStatus =  PaymentVerificationStatus.valueOf(strPaymentVerificationStatus); }catch (IllegalArgumentException e) {}
    		}
    	}
		return paymentVerificationStatus;
	}
	
	@NodeBinder(nodePropertyName=PROP_PAYMENT_VERIFICATION_STATUS)
	public final String getPaymentVerificationStatusStr() {
		if ( paymentVerificationStatusStr == null ) {
			paymentVerificationStatusStr = getProperty(PROP_PAYMENT_VERIFICATION_STATUS);
		}
		return paymentVerificationStatusStr;
	}
	
	//Citrus Specific Getters
	public final Transaction.ENQUIRY_RESP_CODE getRespCode() {
		if (respCode == null) {
    		String strRespCode = getProperty(PROP_RESP_CODE);
    		if (strRespCode != null) {
    			try { respCode =  ENQUIRY_RESP_CODE.valueOf(strRespCode); }catch (IllegalArgumentException e) {}
    		}
    	}
		return respCode;
	}
	
	@NodeBinder(nodePropertyName=PROP_RESP_CODE)
	public final String getRespCodeStr() {
		if ( respCodeStr == null ) {
			respCodeStr = getProperty(PROP_RESP_CODE);
		}
		return respCodeStr;
	}

	@NodeBinder(nodePropertyName=PROP_RESP_MSG)
	public final String getRespMsg() {
		if ( respMsg == null ) {
			respMsg = getProperty(PROP_RESP_MSG);
		}
		return respMsg;
	}

	@NodeBinder(nodePropertyName=PROP_PG_TXN_ID)
	public final String getPgTxnId() {
		if ( pgTxnId == null ) {
			pgTxnId = getProperty(PROP_PG_TXN_ID);
		}
		return pgTxnId;
	}

	@NodeBinder(nodePropertyName=PROP_AUTH_ID_CODE)
	public final String getAuthIdCode() {
		if ( authIdCode == null ) {
			authIdCode = getProperty(PROP_AUTH_ID_CODE);
		}
		return authIdCode;
	}

	@NodeBinder(nodePropertyName=PROP_RRN)
	public final String getRrn() {
		if ( rrn == null ) {
			rrn = getProperty(PROP_RRN);
		}
		return rrn;
	}

	@NodeBinder(nodePropertyName=PROP_TXN_TYPE)
	public final String getTxnType() {
		if ( txnType == null ) {
			txnType = getProperty(PROP_TXN_TYPE);
		}
		return txnType;
	}

	@NodeBinder(nodePropertyName=PROP_TXN_AMOUNT)
	public final Double getTxnAmount() {
		if (txnAmount == null) NodeBinderHelper.setObjectProperty("txnAmount", this, 0D);
		return txnAmount;
	}
	
	@NodeBinder(nodePropertyName=PROP_TXN_DATETIME)
	public final String getTxnDateTime() {
		return txnDateTime;
	}
	
	@NodeBinder(nodePropertyName=PROP_NET_BANKING_CODE)
	public final String getNetBankingCode() {
		return netBankingCode;
	}

	public final void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}

	@BeanClone
	public void setPaymentDate(Calendar paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	
	@BeanClone
	public final void setPaymentTypeStr(String paymentTypeStr) {
		this.paymentTypeStr = paymentTypeStr;
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
	public void setCashAmount(Double cashAmount) {
		this.cashAmount = cashAmount;
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
	
	public void setPaymentVerificationStatus(
			PaymentVerificationStatus paymentVerificationStatus) {
		this.paymentVerificationStatus = paymentVerificationStatus;
	}
	
	@BeanClone
	public final void setPaymentVerificationStatusStr(
			String paymentVerificationStatusStr) {
		this.paymentVerificationStatusStr = paymentVerificationStatusStr;
	}
	
	public final void setRespCode(Transaction.ENQUIRY_RESP_CODE respCode) {
		this.respCode = respCode;
	}
	
	@BeanClone
	public final void setRespCodeStr(String respCodeStr) {
		this.respCodeStr = respCodeStr;
	}

	@BeanClone
	public final void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	@BeanClone
	public final void setPgTxnId(String pgTxnId) {
		this.pgTxnId = pgTxnId;
	}

	@BeanClone
	public final void setAuthIdCode(String authIdCode) {
		this.authIdCode = authIdCode;
	}

	@BeanClone
	public final void setRrn(String rrn) {
		this.rrn = rrn;
	}

	@BeanClone
	public final void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	@BeanClone
	public final void setTxnAmount(Double txnAmount) {
		this.txnAmount = txnAmount;
	}
	
	@BeanClone
	public final void setTxnDateTime(String txnDateTime) {
		this.txnDateTime = txnDateTime;
	}
	
	@BeanClone
	public final void setNetBankingCode(String netBankingCode) {
		this.netBankingCode = netBankingCode;
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
