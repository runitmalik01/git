package com.mootly.wcm.services.ds.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.zip.ZipInputStream;

import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.IndianGregorianCalendar;
import com.mootly.wcm.services.ds.DigitalSignatureService;
import com.mootly.wcm.services.ds.exception.InvalidDigitalSignatureException;
import com.mootly.wcm.services.ds.exception.MissingDigitalCertificateException;
import com.mootly.wcm.services.ds.exception.MissingPrivateKeyException;
import com.mootly.wcm.services.ds.model.DigitalSignatureWrapper;
import com.mootly.wcm.services.ds.model.ERISOAPHeaderSignatureResponse;
import com.mootly.wcm.services.impl.SystemRepositorySupportProvider;

public class DigitalSignatureServiceForITR extends SystemRepositorySupportProvider implements DigitalSignatureService {
	
	private static final Logger log = LoggerFactory.getLogger(DigitalSignatureServiceForITR.class);
	String propertyNameForPassword;
	String relPathChildNodeWithKey;
	String propertyNameDigitalCertificate;
	String keyStoreType;
	String keyStoreProvider;
	
	@Override
	public DigitalSignatureWrapper getDigitalSignature(File file, boolean validate)
			throws MissingPrivateKeyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DigitalSignatureWrapper getDigitalSignatureFromRepository(String jcrPathToMemberDriveNode, boolean validate) throws MissingPrivateKeyException,InvalidDigitalSignatureException, MissingDigitalCertificateException,RepositoryException {
		// TODO Auto-generated method stub
		Session session = null;
		byte[] theByteArray = null;
		String thePrivateKey = null;
		try {
			if (getSystemCredentials() != null) {
				session = getSystemRepository().login(getSystemCredentials());
			} else {
				session = getSystemRepository().login();
			}
			Node theNodeToInspect = null;
			Node theNode = session.getNode(jcrPathToMemberDriveNode);
			if (theNode == null) {
				throw new MissingDigitalCertificateException();
			}
			if (theNode.isNodeType("hippo:handle") || theNode.isNodeType("hippo:hardhandle")) {
				theNodeToInspect = theNode.getNode(theNode.getName());
			}
			else {
				theNodeToInspect = theNode;
			}
			//this node should have the required properties
			if (theNodeToInspect.hasProperty(getPropertyNameForPassword())) {
				Property thePrivateKeyProperty = theNodeToInspect.getProperty(getPropertyNameForPassword());
				thePrivateKey = thePrivateKeyProperty.getString();
			}
			else {
				throw new MissingPrivateKeyException();
			}
			Node theChildNodeWithKey = theNodeToInspect.getNode(getRelPathChildNodeWithKey());
			if (theChildNodeWithKey == null) {
				throw new MissingDigitalCertificateException();
			}
			if (theChildNodeWithKey.hasProperty(getPropertyNameDigitalCertificate())) {
				Property theChildNodeBinary = theChildNodeWithKey.getProperty(getPropertyNameDigitalCertificate());
				try {
					theByteArray = IOUtils.toByteArray( theChildNodeBinary.getBinary().getStream() );
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new MissingDigitalCertificateException();
				}
			}
			else {
				throw new MissingDigitalCertificateException();
			}
		
			//this must have a children which has the actual file
			DigitalSignatureWrapper digitalSignatureWrapper = new DigitalSignatureWrapper(theByteArray,thePrivateKey);
			
			
			if (validate) {
				X509Certificate certificate = validateAndGetCertificate(digitalSignatureWrapper);
				digitalSignatureWrapper.setCertificate(certificate);
			}
			
			return digitalSignatureWrapper;			
		}
		finally {
			if (session != null) {
				try {
					session.logout();
				} catch (Exception ignore) {
				}
			}
		}
	}

	@Override
	public X509Certificate validateAndGetCertificate(DigitalSignatureWrapper digitalSignatureWrapper) throws MissingPrivateKeyException,InvalidDigitalSignatureException {
		// TODO Auto-generated method stub
		
		try {
			if (digitalSignatureWrapper != null && digitalSignatureWrapper.getPrivateKey() == null) {
				throw new MissingPrivateKeyException();
			}
			KeyStore store = KeyStore.getInstance(getKeyStoreType(),getKeyStoreProvider());
			store.load(new ByteArrayInputStream(digitalSignatureWrapper.getDigitalSignature()), digitalSignatureWrapper.getPrivateKey().toCharArray());
			if (store.aliases() == null) {
				throw new InvalidDigitalSignatureException();
			}
			//there should be only 1 certificate
			Certificate theCertificate = null;
			X509Certificate theX509Cert = null;
			Enumeration<String> theAliasEnm = store.aliases();
			while (theAliasEnm.hasMoreElements()) {
				String theAlias = theAliasEnm.nextElement();
				theCertificate =  store.getCertificate(theAlias);
				break;
			}
			if (theCertificate == null && !(theCertificate instanceof X509Certificate)) {
				throw new InvalidDigitalSignatureException();
			}
			theX509Cert = (X509Certificate) theCertificate;
			theX509Cert.checkValidity(IndianGregorianCalendar.getCurrentDateInIndiaAsDate().getTime());
			
			
			
			String principalName = theX509Cert.getSubjectDN().getName();
			if (log.isInfoEnabled()) {
				log.info("Principal Name:" + principalName);
			}
			
			return theX509Cert;
			//theX509Cert.verify(key)
					
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new InvalidDigitalSignatureException(e);
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new InvalidDigitalSignatureException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new InvalidDigitalSignatureException(e);
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new InvalidDigitalSignatureException(e);
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new InvalidDigitalSignatureException(e);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new InvalidDigitalSignatureException(e);
		}
	}

	@Override
	public String signITRByAssesse(String xml,
			DigitalSignatureWrapper digitalSignatureWrapper)
					throws MissingPrivateKeyException,InvalidDigitalSignatureException,
					Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ERISOAPHeaderSignatureResponse signZIPByERISubUser(byte[] byteArray,
			DigitalSignatureWrapper digitalSignatureWrapper)
					throws MissingPrivateKeyException, InvalidDigitalSignatureException,
					Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPropertyNameForPassword() {
		return propertyNameForPassword;
	}

	public void setPropertyNameForPassword(String propertyNameForPassword) {
		this.propertyNameForPassword = propertyNameForPassword;
	}

	public String getRelPathChildNodeWithKey() {
		return relPathChildNodeWithKey;
	}

	public void setRelPathChildNodeWithKey(String relPathChildNodeWithKey) {
		this.relPathChildNodeWithKey = relPathChildNodeWithKey;
	}

	public String getPropertyNameDigitalCertificate() {
		return propertyNameDigitalCertificate;
	}

	public void setPropertyNameDigitalCertificate(
			String propertyNameDigitalCertificate) {
		this.propertyNameDigitalCertificate = propertyNameDigitalCertificate;
	}

	public final String getKeyStoreType() {
		return keyStoreType;
	}

	public final void setKeyStoreType(String keyStoreType) {
		this.keyStoreType = keyStoreType;
	}

	public final String getKeyStoreProvider() {
		return keyStoreProvider;
	}

	public final void setKeyStoreProvider(String keyStoreProvider) {
		this.keyStoreProvider = keyStoreProvider;
	}
	
	
}
