package com.mootly.wcm.services.ds;

import java.io.File;
import java.security.cert.X509Certificate;

import javax.jcr.RepositoryException;

import com.mootly.wcm.services.ds.exception.InvalidDigitalSignatureException;
import com.mootly.wcm.services.ds.exception.MissingDigitalCertificateException;
import com.mootly.wcm.services.ds.exception.MissingPrivateKeyException;
import com.mootly.wcm.services.ds.model.DigitalSignatureWrapper;
import com.mootly.wcm.services.ds.model.ERISOAPHeaderSignatureResponse;

public interface DigitalSignatureService {
	
	DigitalSignatureWrapper getDigitalSignature(File file,boolean validate) throws MissingPrivateKeyException;
	DigitalSignatureWrapper getDigitalSignatureFromRepository(String jcrPathToMemberDriveNode,boolean validate) throws MissingPrivateKeyException,InvalidDigitalSignatureException, MissingDigitalCertificateException, RepositoryException;
	
	/**
	 * 
	 * @param digitalSignature
	 * @param financialYear
	 * @return
	 */
	X509Certificate validateAndGetCertificate(DigitalSignatureWrapper digitalSignatureWrapper) throws MissingPrivateKeyException,InvalidDigitalSignatureException;
	
	/**
	 * This will add the Digital Signature of the ASSESSEE 
	 * The return value is modified XML
	 */
	String signITRByAssesse(String PAN,String xml, DigitalSignatureWrapper digitalSignatureWrapper) throws MissingPrivateKeyException,InvalidDigitalSignatureException,Exception;
	
	ERISOAPHeaderSignatureResponse signZIPByERISubUser(byte[] byteArray, DigitalSignatureWrapper digitalSignatureWrapper) throws MissingPrivateKeyException, InvalidDigitalSignatureException,Exception;
	
	String getLocationToSaveSignedXML();
	void setLocationToSaveSignedXML(String locationToSaveSignedXML);
	boolean isSavingSignedXML();
	void setSavingSignedXML(boolean savingSignedXML);
}
