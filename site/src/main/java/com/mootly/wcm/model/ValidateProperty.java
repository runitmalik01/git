package com.mootly.wcm.model;

import com.mootly.wcm.beans.ProfitAndLossDocument;

public enum ValidateProperty {

	PROP_1("net_Profit","2500000",ProfitAndLossDocument.class.getSimpleName(),ValidateType.MAX_ALLOWED),
	PROP_2("profitBefore_InterestTaxes","2500000",ProfitAndLossDocument.class.getSimpleName(),ValidateType.MAX_ALLOWED);

	String propertyName;
	String valueToValidate;
	ValidateType validateType;
	String documentName;

	private ValidateProperty() {
		// TODO Auto-generated constructor stub
	}

	private ValidateProperty(String propertyName, String valueToValidate, String documentName, ValidateType validateType) {
		// TODO Auto-generated constructor stub
		this.propertyName = propertyName;
		this.valueToValidate = valueToValidate;
		this.documentName = documentName;
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

	public String getDocumentName() {
		return documentName;
	}
}
