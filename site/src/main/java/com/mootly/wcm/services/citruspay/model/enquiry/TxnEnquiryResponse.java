package com.mootly.wcm.services.citruspay.model.enquiry;



import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.mootly.wcm.services.citruspay.model.XMLObject;

/*
 * //create transaction or chanrge
//sample xml request for net banking: 
 * <createTransactionRequest><merchantTxnId>t12345t1</merchantTxnId><amount>1.0</amount><firstName>Test</firstName><lastName>Test</lastName><address>Test</address>
//<addressCity>Pune</addressCity><addressState>Goa</addressState><addressZip>123456</addressZip><email>test@test.com</email><mobile>1234567890</mobile><paymentMode>NET_BANKING</paymentMode>
//<issuerCode>CID009</issuerCode><returnUrl>http://127.0.0.1:8080/Kit-Test/jsp/TestMotoResponse.jsp</returnUrl><notifyUrl>http://127.0.0.1:8080/Kit-Test/jsp/TestNotifyResponse.jsp</notifyUrl></createTransactionRequest>
//signature text for above request: merchantAccessKey=HS6Q0E1N40OUSYCJXMX5&transactionId=t12345t1&amount=1.0
// sample response:
//<?xml version="1.0" encoding="UTF-8" standalone="yes"?><createTransactionResponse><redirectUrl>https://14.140.42.101/mpi/PaymentMoto.jsp?txnId=0ED2C23B210DF56A9F69C92426F32EB2245575E72B94C8E8</redirectUrl>
//</createTransactionResponse> 
//Note: For Moto Integration redirect to the redirectUrl
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "enquiryResponse"
})
@XmlRootElement( name = "txnEnquiryResponse" )
public class TxnEnquiryResponse extends XMLObject {
	  @XmlElement(name = "enquiryResponse")
	  protected List<EnquiryResponse> enquiryResponse;
	  
	  public List<EnquiryResponse> getEnquiryResponse() {
	        if (enquiryResponse == null) {
	        	enquiryResponse = new ArrayList<EnquiryResponse>();
	        }
	        return this.enquiryResponse;
	    }
	  
	  @Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		if (getEnquiryResponse() != null) {
			for (EnquiryResponse anE : getEnquiryResponse() ) {
				sb.append("respCode:" + anE.getRespCode());
				sb.append("respMsg:" + anE.getRespMsg());
				sb.append("Amount:" + anE.getAmount());
				sb.append("paymentMode:" + anE.getPaymentType());
			}
		}
		return sb.toString();
	}
}
