package com.mootly.wcm.services.citruspay;

import java.util.Map;

public interface Enquiry extends PaymentService {
	
	Map<String,Object> doEnquiry(String transactionId);
}
