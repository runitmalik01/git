package com.mootly.wcm.model;

import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.beans.ProfitAndLossDocument;
import com.mootly.wcm.beans.ResellerSignupDocument;
import com.mootly.wcm.beans.compound.InvoicePaymentDetail;

public enum ValidateProperty {

	PROP_1("net_Profit","2500000",ProfitAndLossDocument.class,ValidateType.MAX_ALLOWED),
	PROP_2("profitBefore_InterestTaxes","2500000",ProfitAndLossDocument.class,ValidateType.MAX_ALLOWED),
	PROP_3("hippostd:state","unpublish",null,ValidateType.EQUALITY),
	PROP_4("mootlywcm:paymentVerificationStatus","VERIFIED",InvoicePaymentDetail.class,ValidateType.EQUALITY),
	PROP_5("mootlywcm:paymentVerificationStatus","",InvoicePaymentDetail.class,ValidateType.EQUALITY),
	PROP_6("mootlywcm:resellerPackage","trialPeriod",ResellerSignupDocument.class,ValidateType.EQUALITY);

	String propertyName;
	String valueToValidate;
	ValidateType validateType;
	Class<? extends HippoBean> documentBean;

	private ValidateProperty() {
		// TODO Auto-generated constructor stub
	}

	private ValidateProperty(String propertyName, String valueToValidate, Class<? extends HippoBean> documentBean, ValidateType validateType) {
		// TODO Auto-generated constructor stub
		this.propertyName = propertyName;
		this.valueToValidate = valueToValidate;
		this.documentBean = documentBean;
		this.validateType = validateType;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public String getValueToValidate() {
		return valueToValidate;
	}

	public ValidateType getValidateType() {
		return validateType;
	}

	public Class<? extends HippoBean> getDocumentBean() {
		return documentBean;
	}
}
