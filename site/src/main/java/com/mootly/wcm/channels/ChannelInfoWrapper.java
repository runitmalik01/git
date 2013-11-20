package com.mootly.wcm.channels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mootly.wcm.model.PaymentType;

/**
 * 
 * @author admin
 *
 */
public final class ChannelInfoWrapper {
	
	final WebsiteInfo webSiteInfo; 
	
	public ChannelInfoWrapper(WebsiteInfo webSiteInfo) {
		this.webSiteInfo = webSiteInfo;
	}
	
	public WebsiteInfo getWebSiteInfo() {
		return webSiteInfo;
	}
	
	public boolean getIsEriEnabled() {
		String strEriEnabled = webSiteInfo.getEriEnabled();
		return Boolean.valueOf(strEriEnabled);
	}
	
	public final List<PaymentType> availablePaymentTypes() {
		//List<PaymentType> listOfPaymentTypes = Arrays.asList(PaymentType.values());
		List<PaymentType> minimumPaymentTypes = new ArrayList<PaymentType>();
		
		List<PaymentType> avaiablePaymentTypes = new ArrayList<PaymentType>();
		minimumPaymentTypes.add(PaymentType.CASH);
		minimumPaymentTypes.add(PaymentType.CHECK);
		minimumPaymentTypes.add(PaymentType.RTGS);
		
		String str = webSiteInfo.getPaymentAvailableTypes();
		if (str == null || "".equals(str.trim())) {
			return minimumPaymentTypes;			
		}
		else {
			String[] parts = str.split("[,]");
			for (String aPart:parts) {
				try {
					PaymentType pt = PaymentType.valueOf(aPart);
					avaiablePaymentTypes.add(pt);
				}catch (IllegalArgumentException e) {
					
				}
			}
			return avaiablePaymentTypes;
		}
	}	
}
