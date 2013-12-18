package com.mootly.wcm.services.ds.model;

import java.security.cert.X509Certificate;

public class DigitalSignatureWrapper {
	
	final byte[] digitalSignature;
	final String privateKey;
	X509Certificate certificate;
	
	public DigitalSignatureWrapper(byte[] digitalSignature,String privateKey) {
		this.digitalSignature = digitalSignature;
		this.privateKey = privateKey;
	}

	public final byte[] getDigitalSignature() {
		return digitalSignature;
	}

	public final String getPrivateKey() {
		return privateKey;
	}

	public final X509Certificate getCertificate() {
		return certificate;
	}

	public final void setCertificate(X509Certificate certificate) {
		this.certificate = certificate;
	}
	
}
