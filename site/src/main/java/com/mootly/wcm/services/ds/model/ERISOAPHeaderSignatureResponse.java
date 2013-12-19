package com.mootly.wcm.services.ds.model;

public class ERISOAPHeaderSignatureResponse {
	String signature;
	String certChain;
	
	
	public final String getSignature() {
		return signature;
	}
	public final void setSignature(String signature) {
		this.signature = signature;
	}
	public final String getCertChain() {
		return certChain;
	}
	public final void setCertChain(String certChain) {
		this.certChain = certChain;
	}
	
	
}
