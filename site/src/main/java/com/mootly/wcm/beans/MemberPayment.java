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

package com.mootly.wcm.beans;

import static com.mootly.wcm.utils.Constants.PROP_PI_PERSONALINFO_LINK;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoMirror;

import com.mootly.wcm.beans.standard.FlexibleDocument;
import com.mootly.wcm.model.PaymentType;
import com.mootly.wcm.model.PaymentVerificationStatus;

/**
 * User: vivek
 * Date: Jun 29, 2010
 * Time: 11:26:35 AM
 */


@Node(jcrType = "mootlywcm:payment")
public class MemberPayment extends FlexibleDocument implements ContentNodeBinder, FormMapFiller {
	
	private PaymentType paymentType;
	private String paymentMemo;
	private Double paymentAmount;
	
	private String authCode;
	private String preAuthCode;
	
	//if by BANK
	private String checkNo;
	private Calendar checkDate;
	private String checkBank;
	private String checkBranch;
	
	//cash fields
	private String cashAddress;
	private String cashContactNumber;
	private String cashBestTime;
	
	//RTGS
	private Calendar rtgsDate;
	private Double rtgsAmount;
	private String rtgsTime;
	
	Calendar paymentDate;
	
	PaymentVerificationStatus paymentVerificationStatus; 
	
	final String PROP_PAYMENT_MEMO = "mootlywcm:paymentMemo";
	final String PROP_PAYMENT_TYPE = "mootlywcm:paymentType";
	final String PROP_PAYMENT_AMOUNT = "mootlywcm:paymentAmount";
	
	
	final String PROP_AUTH_CODE = "mootlywcm:authCode";
	final String PROP_PRE_AUTH_CODE = "mootlywcm:preAuthCode";
	
	final String PROP_CHECK_NO = "mootlywcm:checkNo";
	final String PROP_CHECK_DATE = "mootlywcm:checkDate";
	final String PROP_CHECK_BANK = "mootlywcm:checkBank";
	final String PROP_CHECK_BRANCH = "mootlywcm:checkBranch";
	final String PROP_CASH_ADDRESS = "mootlywcm:cashAddress";
	final String PROP_CASH_CONTACT_NUMBER = "mootlywcm:cashContactNumber";
	final String PROP_CASH_BEST_TIME = "mootlywcm:cashBestTime";
	
	final String PROP_RTGS_DATE = "mootlywcm:rtgsDete";
	final String PROP_RTGS_AMOUNT = "mootlywcm:rtgsAmount";
	final String PROP_RTGS_TIME = "mootlywcm:crtgsTime";
	
	final String PROP_PAYMENT_DATE = "mootlywcm:paymentDate";
	final String PROP_PAYMENT_VERIFICATION_STATUS = "mootlywcm:paymentVerificationStatus";
	
    public PaymentType getPaymentType() {
    	if (paymentType == null) {
    		String strPaymentType = getProperty(PROP_PAYMENT_TYPE);
    		try { paymentType =  PaymentType.valueOf(strPaymentType); }catch (IllegalArgumentException e) {}
    	}
		return paymentType;
	}
	public String getAuthCode() {
		if (authCode == null) authCode = getProperty(PROP_AUTH_CODE);
		return authCode;
	}
	public String getPreAuthCode() {
		if (preAuthCode == null) preAuthCode = getProperty(PROP_PRE_AUTH_CODE);
		return preAuthCode;
	}
	public String getCheckNo() {
		if (checkNo == null) checkNo = getProperty(PROP_CHECK_NO);
		return checkNo;
	}
	public Calendar getCheckDate() {
		if (checkDate == null) checkDate = getProperty(PROP_CHECK_DATE);
		return checkDate;
	}
	
	public String getCheckDateStr() {
		Calendar theDate = getCheckDate();
		return ConvCalendarToDateString(theDate);
	}
	
	public String getCheckBank() {
		if (checkBank == null) checkBank = getProperty(PROP_CHECK_BANK);
		return checkBank;
	}
	
	public Calendar getPaymentDate() {
		if (paymentDate == null) paymentDate = getProperty(PROP_PAYMENT_DATE);
		return paymentDate;
	}
	
	public String getPaymentDateStr() {
		Calendar theDate = getPaymentDate();
		return ConvCalendarToDateString(theDate);
	}
	
	public Double getPaymentAmount() {
		if (paymentAmount == null) paymentAmount = getProperty(PROP_PAYMENT_AMOUNT);
		return paymentAmount;
	}
	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getCheckBranch() {
		if (checkBranch == null) checkBranch = getProperty(PROP_CHECK_BRANCH);
		return checkBranch;
	}
	public void setCheckBranch(String checkBranch) {
		this.checkBranch = checkBranch;
	}
	public String getCashAddress() {
		if (cashAddress == null) cashAddress = getProperty(PROP_CASH_ADDRESS);
		return cashAddress;
	}
	public void setCashAddress(String cashAddress) {
		this.cashAddress = cashAddress;
	}
	public String getCashContactNumber() {
		if (cashContactNumber == null) cashContactNumber = getProperty(PROP_CASH_CONTACT_NUMBER);
		return cashContactNumber;
	}
	public void setCashContactNumber(String cashContactNumber) {
		this.cashContactNumber = cashContactNumber;
	}
	public String getCashBestTime() {
		if (cashBestTime == null) cashBestTime = getProperty(PROP_CASH_BEST_TIME);
		return cashBestTime;
	}
	public void setCashBestTime(String cashBestTime) {
		this.cashBestTime = cashBestTime;
	}
	public Calendar getRtgsDate() {
		if (rtgsDate == null) rtgsDate = getProperty(PROP_RTGS_DATE);
		return rtgsDate;
	}
	
	public String getRtgsDateStr() {
		Calendar theDate = getRtgsDate();
		return ConvCalendarToDateString(theDate);
	}
	
	public void setRtgsDate(Calendar rtgsDate) {
		this.rtgsDate = rtgsDate;
	}
	public Double getRtgsAmount() {
		if (rtgsAmount == null) rtgsAmount = getProperty(PROP_RTGS_AMOUNT);
		return rtgsAmount;
	}
	public void setRtgsAmount(Double rtgsAmount) {
		this.rtgsAmount = rtgsAmount;
	}
	public String getRtgsTime() {
		if (rtgsTime == null) rtgsTime = getProperty(PROP_RTGS_TIME);
		return rtgsTime;
	}
	public void setRtgsTime(String rtgsTime) {
		this.rtgsTime = rtgsTime;
	}
	public PaymentVerificationStatus getPaymentVerificationStatus() {
		if (paymentVerificationStatus == null) {
    		String strPaymentVerificationStatus = getProperty(PROP_PAYMENT_VERIFICATION_STATUS);
    		if (strPaymentVerificationStatus != null) try { paymentVerificationStatus =  PaymentVerificationStatus.valueOf( strPaymentVerificationStatus); }catch (Exception ex) {}
    	}
		return paymentVerificationStatus;
	}
	
	public String getPaymentMemo() {
		if (paymentMemo == null) paymentMemo = getProperty(PROP_PAYMENT_MEMO);
		return paymentMemo;
	}
	
    public List<MemberPersonalInformation> getMemberPersonalInfoLinks() {
    	HippoBean[] beans = getBean(PROP_PI_PERSONALINFO_LINK);
    	if (!(beans instanceof HippoMirror[])) {
    		return null;
    	}
    	List<MemberPersonalInformation> listOfMemberPersonalInformation = new ArrayList<MemberPersonalInformation>();
    	if (beans != null && beans.length > 0) {
    		for (HippoBean anMirror: beans) {
    			MemberPersonalInformation prdBean = (MemberPersonalInformation) ((HippoMirror) anMirror).getReferencedBean();
    			listOfMemberPersonalInformation.add(prdBean);
    		}
    	}
    	if (listOfMemberPersonalInformation == null || listOfMemberPersonalInformation.size() == 0) {
    		return null;
    	}
    	return listOfMemberPersonalInformation;
    }
    
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			MemberPayment memberPayment = (MemberPayment) content;
			
			node.setProperty(PROP_PAYMENT_MEMO, memberPayment.getPaymentMemo());
	    	node.setProperty(PROP_PAYMENT_TYPE, memberPayment.getPaymentType().name());
	    	node.setProperty(PROP_AUTH_CODE, memberPayment.getAuthCode());
	    	node.setProperty(PROP_PRE_AUTH_CODE, memberPayment.getPreAuthCode());
	    	
	    	node.setProperty(PROP_CHECK_NO, memberPayment.getCheckNo());
	    	node.setProperty(PROP_CHECK_DATE, memberPayment.getCheckDate());
	    	node.setProperty(PROP_CHECK_BANK, memberPayment.getCheckBank());
	    	node.setProperty(PROP_CHECK_BRANCH, memberPayment.getCheckBranch());
	    	
	    	//CASH
	    	node.setProperty(PROP_CASH_ADDRESS, memberPayment.getCashAddress());
	    	node.setProperty(PROP_CASH_BEST_TIME, memberPayment.getCashBestTime());
	    	node.setProperty(PROP_CASH_CONTACT_NUMBER, memberPayment.getCashContactNumber());
	    	
	    	//RTGS
	    	node.setProperty(PROP_RTGS_AMOUNT, memberPayment.getRtgsAmount());
	    	node.setProperty(PROP_RTGS_DATE, memberPayment.getRtgsDate());
	    	node.setProperty(PROP_RTGS_TIME, memberPayment.getRtgsTime());
	    	
	    	node.setProperty(PROP_PAYMENT_DATE, memberPayment.getCheckDate());
	    	if (memberPayment.getPaymentVerificationStatus() != null && memberPayment.getPaymentVerificationStatus().name() != null)
	    		node.setProperty(PROP_PAYMENT_VERIFICATION_STATUS, memberPayment.getPaymentVerificationStatus().name() );
	    	else 
	    		node.setProperty(PROP_PAYMENT_VERIFICATION_STATUS, "");
	    	/**  javax.jcr.Node prdLinkNode;

              if (node.hasNode(PROP_PI_PERSONALINFO_LINK)) {
                  prdLinkNode = node.getNode(PROP_PI_PERSONALINFO_LINK);
              } else {
                  prdLinkNode = node.addNode(PROP_PI_PERSONALINFO_LINK, "hippo:mirror");
              }
              prdLinkNode.setProperty("hippo:docbase", contact_info.getPersonalInfoUuid());
	       */
    	}catch (RepositoryException re) {
    		log.error("Binding Node Error",re);
    		
    	}
		return true;
	}
	
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	
	public void setPaymentMemo(String paymentMemo) {
		this.paymentMemo = paymentMemo;
	}
	
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	
	public void setPreAuthCode(String preAuthCode) {
		this.preAuthCode = preAuthCode;
	}
	
	public void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
	}
	
	public void setCheckDate(Calendar checkDate) {
		this.checkDate = checkDate;
	}
	
	public void setCheckBank(String checkBank) {
		this.checkBank = checkBank;
	}
	
	public void setPaymentDate(Calendar paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	public void setPaymentVerificationStatus(
			PaymentVerificationStatus paymentVerificationStatus) {
		this.paymentVerificationStatus = paymentVerificationStatus;
	}
	
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (formMap == null) return;
		if (formMap.getField("paymentMemo") != null) setPaymentMemo( formMap.getField("paymentMemo").getValue());
		if (formMap.getField("paymentType") != null) setPaymentType( PaymentType.valueOf( formMap.getField("paymentType").getValue()) );
		if (formMap.getField("authCode") != null) setAuthCode(formMap.getField("authCode").getValue());
		if (formMap.getField("preAuthCode") != null) setPreAuthCode(formMap.getField("preAuthCode").getValue());
		
		if (formMap.getField("checkNo") != null) setCheckNo(formMap.getField("checkNo").getValue());
		if (formMap.getField("checkDate") != null) setCheckDate( ConvDateStringToCalendar ( formMap.getField("checkDate").getValue() ) ) ;
		if (formMap.getField("checkBank") != null) setCheckBank(formMap.getField("checkBank").getValue());
		if (formMap.getField("checkBranch") != null) setCheckBranch(formMap.getField("checkBranch").getValue());
		
		//CASH
		if (formMap.getField("cashAddress") != null) setCashAddress( formMap.getField("cashAddress").getValue() ) ;
		if (formMap.getField("cashContactNumber") != null) setCashContactNumber(formMap.getField("cashContactNumber").getValue());
		if (formMap.getField("cashBestTime") != null) setCashBestTime(formMap.getField("cashBestTime").getValue());
		
		//RTGS
		if (formMap.getField("rtgsDate") != null) setRtgsDate( ConvDateStringToCalendar( formMap.getField("cashAddress").getValue() ) ) ;
		if (formMap.getField("rtgsAmount") != null) setRtgsAmount( ConvStringToDouble ( formMap.getField("rtgsAmount").getValue() ));
		if (formMap.getField("rtgsTime") != null) setRtgsTime( formMap.getField("rtgsTime").getValue());
		
		if (formMap.getField("paymentDate") != null) setPaymentDate( ConvDateStringToCalendar ( formMap.getField("paymentDate").getValue()) );
		//if (formMap.getField("paymentVerificationStatus") != null) setPaymentVerificationStatus( PaymentVerificationStatus.valueOf( formMap.getField("paymentVerificationStatus").getValue() ));
	}
	
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub
		
	}
}
