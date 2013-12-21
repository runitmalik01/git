package com.mootly.wcm.services.ds.model;

import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

public class DigitalSignatureWrapper {
	
	final byte[] digitalSignature;
	final String privateKeyPassword;
	X509Certificate certificate;
	Certificate[] certificationChain;
	String base64EncodedCertChain;
	PrivateKey privateKey;
	
	public DigitalSignatureWrapper(byte[] digitalSignature,String privateKeyPassword) {
		this.digitalSignature = digitalSignature;
		this.privateKeyPassword = privateKeyPassword;
	}

	public final byte[] getDigitalSignature() {
		return digitalSignature;
	}

	public final String getPrivateKeyPassword() {
		return privateKeyPassword;
	}

	public final X509Certificate getCertificate() {
		return certificate;
	}

	public final void setCertificate(X509Certificate certificate) {
		this.certificate = certificate;
	}

	public final Certificate[] getCertificationChain() {
		return certificationChain;
	}

	public final void setCertificationChain(Certificate[] certificationChain) {
		this.certificationChain = certificationChain;
	}

	public final PrivateKey getPrivateKey() {
		return privateKey;
	}

	public final void setPrivateKey(PrivateKey privateKey) {
		this.privateKey = privateKey;
	}

	public final String getBase64EncodedCertChain() {
		return base64EncodedCertChain;
	}

	public final void setBase64EncodedCertChain(String base64EncodedCertChain) {
		this.base64EncodedCertChain = base64EncodedCertChain;
	}
	
}
