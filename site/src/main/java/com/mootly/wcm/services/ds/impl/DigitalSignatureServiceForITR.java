package com.mootly.wcm.services.ds.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Signature;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipInputStream;

import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.xml.crypto.XMLStructure;
import javax.xml.crypto.dom.DOMStructure;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.XMLObject;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import ETM.ITD.FilingService.Base64Utils;

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
		String thePrivateKeyPassword = null;
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
				thePrivateKeyPassword = thePrivateKeyProperty.getString();
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
			DigitalSignatureWrapper digitalSignatureWrapper = new DigitalSignatureWrapper(theByteArray,thePrivateKeyPassword);
			
			
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
			if (digitalSignatureWrapper != null && digitalSignatureWrapper.getPrivateKeyPassword() == null) {
				throw new MissingPrivateKeyException();
			}
			KeyStore store = KeyStore.getInstance(getKeyStoreType(),getKeyStoreProvider());
			store.load(new ByteArrayInputStream(digitalSignatureWrapper.getDigitalSignature()), digitalSignatureWrapper.getPrivateKeyPassword().toCharArray());
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
				Certificate[] certificationChain = store.getCertificateChain(theAlias);
	            PrivateKey privateKey = (PrivateKey) store.getKey(theAlias, digitalSignatureWrapper.getPrivateKeyPassword().toCharArray());
	            digitalSignatureWrapper.setPrivateKey(privateKey);	            
	            String  base64EncodedCertChain = encodeX509CertChainToBase64(certificationChain);
	            digitalSignatureWrapper.setBase64EncodedCertChain(base64EncodedCertChain);
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
		String providerName = System.getProperty("jsr105Provider",
				"org.jcp.xml.dsig.internal.dom.XMLDSigRI");

		XMLSignatureFactory fac =
				XMLSignatureFactory.getInstance("DOM",
						(Provider) Class.forName(providerName).newInstance());
		//ExcC14NParameterSpec newTransformSpec = null;
		/*
			   Reference ref =
			       fac.newReference("",
			           fac.newDigestMethod(DigestMethod.SHA1, null),
			               Collections.singletonList(
			                   fac.newTransform(Transform.ENVELOPED,newTransformSpec)), 
			           null, null);
		 */
		Reference ref = fac.newReference("#CDVPS0756D", fac.newDigestMethod(DigestMethod.SHA1, null));
		SignedInfo signedInfo = fac.newSignedInfo(
				fac.newCanonicalizationMethod(
						CanonicalizationMethod.INCLUSIVE_WITH_COMMENTS, 
						(C14NMethodParameterSpec) null),
						fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
						Collections.singletonList(ref));

		 // Next, create the referenced Object
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        Document doc = dbf.newDocumentBuilder().newDocument();
        org.w3c.dom.Node text = doc.createTextNode("");
        //Node text2 = doc.createAttribute("Id");
        //text2.setNodeValue("PANXXXXXXX");
        XMLStructure content = new DOMStructure(text);
        XMLObject obj = fac.newXMLObject
            (Collections.singletonList(content), "CDVPS0756D", null, null);
		
        /*
		KeyStore store = readPFXFile();
		int totalEntries = store.size();
		System.err.println(totalEntries);
		Enumeration<String> aliases = store.aliases();

		while (aliases.hasMoreElements()) {
			System.err.println(aliases.nextElement());
		}
		Key thePrivateKey = store.getKey("le-85750fa4-2aa5-4229-9c3f-e83cea3757cb", "112233".toCharArray());
		
		X509Certificate certificate = (X509Certificate)store.getCertificate("le-85750fa4-2aa5-4229-9c3f-e83cea3757cb");
		System.err.println(certificate.getNotAfter());
		System.err.println(certificate.getNotBefore());
		System.err.println(certificate.toString());
		
		//certificate chain
		
		*/


		KeyInfoFactory kif = fac.getKeyInfoFactory();
		KeyValue kv = kif.newKeyValue(digitalSignatureWrapper.getCertificate().getPublicKey());

		KeyInfo ki = kif.newKeyInfo(Collections.singletonList(kv));
		List<Object> x509Content = new ArrayList<Object>();
		x509Content.add(digitalSignatureWrapper.getCertificate().getSubjectX500Principal().getName());
		x509Content.add(digitalSignatureWrapper.getCertificate());
		X509Data xd = kif.newX509Data(x509Content);
		ki = kif.newKeyInfo(Collections.singletonList(xd));
		//ki = kif.newKeyInfo(content);
		
		dbf.setNamespaceAware(true);
		doc = dbf.newDocumentBuilder().parse(new FileInputStream("C:\\temp\\dsc\\ITR1_ABJPK1442L.xml"));

		DOMSignContext dsc = new DOMSignContext
				(digitalSignatureWrapper.getPrivateKey(), doc.getDocumentElement());
		System.out.println( " thePrivateKey.getAlgorithm() :" +  digitalSignatureWrapper.getPrivateKey().getAlgorithm());
		System.out.println( " thePrivateKey.getFormat() :" +  digitalSignatureWrapper.getPrivateKey().getFormat());
		XMLSignature signature = fac.newXMLSignature(signedInfo, ki,Collections.singletonList(obj), null, null);
		signature.sign(dsc);

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer trans = tf.newTransformer();
		StringWriter writer = new StringWriter();
		try {
			trans.transform(
				new DOMSource(doc),
				new StreamResult(
						new FileOutputStream("C:\\temp\\mysigned.xml")));	
		}catch (Exception e) {
			log.error("Error",e);
		}
		trans.transform(
				new DOMSource(doc),
				new StreamResult(
						writer));
		return writer.toString();
	}

	@Override
	public ERISOAPHeaderSignatureResponse signZIPByERISubUser(byte[] byteArray,
			DigitalSignatureWrapper digitalSignatureWrapper)
					throws MissingPrivateKeyException, InvalidDigitalSignatureException,
					Exception {
		// TODO Auto-generated method stub
		//digitalSignatureWrapper.getCertificate()
		//digitalSignatureWrapper.getDigitalSignature()
		//digitalSignatureWrapper.getPrivateKey()
		Signature signatureAlgorithm = Signature.getInstance(digitalSignatureWrapper.getCertificate().getSigAlgName());
		signatureAlgorithm.initSign(digitalSignatureWrapper.getPrivateKey());
		signatureAlgorithm.update(byteArray);
		byte[] digitalSignature = signatureAlgorithm.sign();
		String base64EncodedSignature = Base64.encodeBase64String(digitalSignature);
		
		ERISOAPHeaderSignatureResponse eriSOAPHeaderSignatureResponse = new ERISOAPHeaderSignatureResponse();
		eriSOAPHeaderSignatureResponse.setCertChain(digitalSignatureWrapper.getBase64EncodedCertChain());
		eriSOAPHeaderSignatureResponse.setSignature(base64EncodedSignature);
		
		return eriSOAPHeaderSignatureResponse;
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
	
	
	private String encodeX509CertChainToBase64(Certificate[] aCertificationChain)
            throws CertificateException {
        List certList = Arrays.asList(aCertificationChain);
        CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        CertPath certPath = certFactory.generateCertPath(certList);
        byte[] certPathEncoded = certPath.getEncoded("PkiPath");
        String base64encodedCertChain = Base64.encodeBase64String(certPathEncoded);
        return base64encodedCertChain;
    }
	
}
