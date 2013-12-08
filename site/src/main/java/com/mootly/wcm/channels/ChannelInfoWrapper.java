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
	
	public Boolean getAllowSignup() {
		Boolean allowSignup = false;
		String strNumberOfLicensedUsers = webSiteInfo.getNumberOfLicensedUsers();
		if (strNumberOfLicensedUsers != null) {
			try {
				Integer numberOfLicensedUsers = Integer.parseInt(strNumberOfLicensedUsers);
				if (numberOfLicensedUsers != null && numberOfLicensedUsers > 0) {
					allowSignup = true;
				}
			}catch (Exception ex) {
				
			}
		}
		return allowSignup;
	}
	
	public Integer getTotalNumberOfLicensedUsers() {
		String strNumberOfLicensedUsers = webSiteInfo.getNumberOfLicensedUsers();
		if (strNumberOfLicensedUsers != null) {
			try {
				Integer numberOfLicensedUsers = Integer.parseInt(strNumberOfLicensedUsers);
				return numberOfLicensedUsers;
			}catch (Exception ex) {
				
			}
		}
		return 0;
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
