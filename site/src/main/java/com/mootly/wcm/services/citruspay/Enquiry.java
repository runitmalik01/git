package com.mootly.wcm.services.citruspay;


import com.mootly.wcm.services.citruspay.model.enquiry.TxnEnquiryResponse;

public interface Enquiry extends PaymentService {
	TxnEnquiryResponse doEnquiry(String transactionId);
}
