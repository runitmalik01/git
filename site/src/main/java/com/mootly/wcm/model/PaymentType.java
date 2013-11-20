package com.mootly.wcm.model;

import java.util.ArrayList;
import java.util.List;

import com.mootly.wcm.channels.WebsiteInfo;

public enum PaymentType {
	CHECK,CASH,RTGS,CREDIT_CARD,DEBIT_CARD,NET_BANKING;
	
	public static PaymentType[] getAvailablePaymentTypes(WebsiteInfo webSiteInfo) {
		List<PaymentType> listOfPaymentTypes = null;
		String paymentAvailableTypes = webSiteInfo.getPaymentAvailableTypes();
		if (paymentAvailableTypes == null || "".equals(paymentAvailableTypes)) {
			return PaymentType.values();
		}
		else {
			listOfPaymentTypes = new ArrayList<PaymentType>();
			String[] strParts = paymentAvailableTypes.split("[,]");
			for (String strPart:strParts) {
				try {
					PaymentType thePaymentType = PaymentType.valueOf(strPart);
					listOfPaymentTypes.add(thePaymentType);
				}catch (IllegalArgumentException e) {
					
				}
			}
			return listOfPaymentTypes.toArray(new PaymentType[listOfPaymentTypes.size()]);
		}
	}
	
	public static boolean requiresGateway(PaymentType paymentType) {
		if (paymentType == CREDIT_CARD || paymentType == DEBIT_CARD || paymentType == NET_BANKING) {
			return true;
		}
		else {
			return false;
		}
	}
}
