package com.mootly.wcm.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.UnrecoverableKeyException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.xml.crypto.MarshalException;
import javax.xml.crypto.XMLStructure;
import javax.xml.crypto.dom.DOMStructure;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLObject;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.keyinfo.X509IssuerSerial;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;


public class SignatureTest {
	public static void main(String[] args) {
		SignatureTest sg = new SignatureTest();
		try {
			sg.generateSignature();
		} catch (UnrecoverableKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MarshalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLSignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void generateSignature() throws FileNotFoundException, SAXException, IOException, ParserConfigurationException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InstantiationException, IllegalAccessException, ClassNotFoundException, KeyException, MarshalException, XMLSignatureException, TransformerException, KeyStoreException, UnrecoverableKeyException {
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
        Node text = doc.createTextNode("");
        //Node text2 = doc.createAttribute("Id");
        //text2.setNodeValue("PANXXXXXXX");
        XMLStructure content = new DOMStructure(text);
        XMLObject obj = fac.newXMLObject
            (Collections.singletonList(content), "CDVPS0756D", null, null);
		//KeyPairGenerator kpg = 
		//    KeyPairGenerator.getInstance("DSA");
		// kpg.initialize(512);
		// KeyPair kp = kpg.generateKeyPair();
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
		
		


		KeyInfoFactory kif = fac.getKeyInfoFactory();
		KeyValue kv = kif.newKeyValue(certificate.getPublicKey());

		KeyInfo ki = kif.newKeyInfo(Collections.singletonList(kv));
		List<Object> x509Content = new ArrayList<Object>();
		x509Content.add(certificate.getSubjectX500Principal().getName());
		x509Content.add(certificate);
		X509Data xd = kif.newX509Data(x509Content);
		ki = kif.newKeyInfo(Collections.singletonList(xd));
		//ki = kif.newKeyInfo(content);
		
		dbf.setNamespaceAware(true);
		doc = dbf.newDocumentBuilder().parse(new FileInputStream("C:\\temp\\dsc\\ITR1_ABJPK1442L.xml"));

		DOMSignContext dsc = new DOMSignContext
				(thePrivateKey, doc.getDocumentElement());
		System.out.println( " thePrivateKey.getAlgorithm() :" +  thePrivateKey.getAlgorithm());
		System.out.println( " thePrivateKey.getFormat() :" +  thePrivateKey.getFormat());
		XMLSignature signature = fac.newXMLSignature(signedInfo, ki,Collections.singletonList(obj), null, null);
		signature.sign(dsc);

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer trans = tf.newTransformer();
		trans.transform(
				new DOMSource(doc),
				new StreamResult(
						new FileOutputStream("C:\\temp\\dsc\\mysigned.xml")));
	}

	public KeyStore readPFXFile() {
		try  {
			FileInputStream stream = new FileInputStream("C:/Users/admin/Downloads/DSC_Sweta.pfx");
			KeyStore store = KeyStore.getInstance("pkcs12", "SunJSSE");
			store.load(stream, "112233".toCharArray());
			return store;


		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
