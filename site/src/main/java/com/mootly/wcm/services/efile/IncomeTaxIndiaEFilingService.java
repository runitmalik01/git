package com.mootly.wcm.services.efile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.jcr.LoginException;
import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.ditws.SubmitBulkITR;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ds.DigitalSignatureService;
import com.mootly.wcm.services.ds.exception.InvalidDigitalSignatureException;
import com.mootly.wcm.services.ds.exception.MissingDigitalCertificateException;
import com.mootly.wcm.services.ds.exception.MissingPrivateKeyException;
import com.mootly.wcm.services.ds.model.DigitalSignatureWrapper;
import com.mootly.wcm.services.ds.model.ERISOAPHeaderSignatureResponse;
import com.mootly.wcm.services.efile.exception.DigtalSignatureAssesseeFailure;
import com.mootly.wcm.services.efile.exception.DigtalSignatureERIUserFailure;
import com.mootly.wcm.services.efile.exception.EFileException;
import com.mootly.wcm.services.impl.SystemRepositorySupportProvider;

public class IncomeTaxIndiaEFilingService extends SystemRepositorySupportProvider implements EFileService {
	private static Logger log = LoggerFactory.getLogger(IncomeTaxIndiaEFilingService.class);
	
	DigitalSignatureService digitalSignatureService;
	String canonicalHandlePathPropertyMemberPersonalInfo;
	String canonicalHandlePathPropertyResellerSignupDocument;
	
	SubmitBulkITR submitBulkITRService;
	
	@Override
	public EFileResponse eFile(String userName, String password,String xml, String resellerId,String pan,
			FinancialYear financialYear, String canonicalPathToMemberIncomeTaxFolder,String absoluteBasePathToReturnDocuments , WorkflowPersistenceManager wpm) 
					throws DigtalSignatureAssesseeFailure,DigtalSignatureERIUserFailure, EFileException {
		// TODO Auto-generated method stub
		if (log.isInfoEnabled()) {
			log.info("xml:" + xml);
			log.info("pan:" + pan);
			log.info("financialYear:" + financialYear);
			log.info("canonicalPathToMemberIncomeTax:" + canonicalPathToMemberIncomeTaxFolder);
		}
		
		DigitalSignatureWrapper dsAssessee = null;
		DigitalSignatureWrapper dsERIUser = null;
		String jcrPathToAssesseDigitalSignature = null;
		
		try {
			jcrPathToAssesseDigitalSignature = findJCRPathToAssesseDigitalSignature(canonicalPathToMemberIncomeTaxFolder);			
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EFileException(e);
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new EFileException(e);
		} 
		
		if (jcrPathToAssesseDigitalSignature != null) {
			try {
				dsAssessee = getDigitalSignatureService().getDigitalSignatureFromRepository(jcrPathToAssesseDigitalSignature, true);
			}
			catch (MissingPrivateKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new DigtalSignatureAssesseeFailure(e);
			} catch (InvalidDigitalSignatureException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new DigtalSignatureAssesseeFailure(e);
			} catch (MissingDigitalCertificateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new DigtalSignatureAssesseeFailure(e);
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				throw new DigtalSignatureAssesseeFailure(e);
			}
		}
		
		try {
			String jcrPathToERIUserDigitalSignature = findJCRPathToERISubUserDigitalSignature(resellerId);
			dsERIUser = getDigitalSignatureService().getDigitalSignatureFromRepository(jcrPathToERIUserDigitalSignature, true);
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EFileException(e);
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EFileException(e); //NOTE ERUSUBUSER SIGNATURE IS MANDATORY, this is WHY WE THROW EXCPETION RIGHT AWAY, WE DID NOT DO IT FOR ASSESSE as THE SIGNATURE IS NOT MANDATORY
		} catch (MissingPrivateKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EFileException(e);
		} catch (InvalidDigitalSignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EFileException(e);
		} catch (MissingDigitalCertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EFileException(e);
		}
		
		if (dsERIUser == null) {
			throw new EFileException("Unable to load Digital Signature for ERI User/Sub User");
		}
		
		//first STEP is to get the application digitally signed if the assesse has a valid signature
		String finalXml = xml;
		if (dsAssessee != null) {
			try {
				finalXml = getDigitalSignatureService().signITRByAssesse(pan,xml, dsAssessee);
			} catch (MissingPrivateKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new EFileException(e);
			} catch (InvalidDigitalSignatureException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new EFileException(e);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new EFileException(e);
			}
		}
		
		if (finalXml == null || finalXml.length() == 0) {
			throw new EFileException();
		}
		//now we have the final XML , we now we ZIP the income tax return
		//OK lets convert 
		byte[] theByteArray = null;
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		//BufferedOutputStream bfo = new BufferedOutputStream(bo);
		ZipOutputStream zo = new ZipOutputStream(bo);		
		ZipEntry ze = new ZipEntry("itr.xml");
		try {
			zo.putNextEntry(ze);
			zo.write(finalXml.getBytes("UTF-8"));
			zo.closeEntry();		
			zo.close();
			
			theByteArray = bo.toByteArray();
			bo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EFileException(e);
		}finally {
			try { zo.close(); } catch (Exception e) {} finally {}
			try { bo.close(); } catch (Exception e) {}  finally {}			
		}
		
		if (theByteArray == null || theByteArray.length ==0) {
			throw new EFileException();
		}
		//now we have the zip file entry we need to get it signed
		ERISOAPHeaderSignatureResponse erisoapHeaderSignatureResponse = null;
		try {
			erisoapHeaderSignatureResponse = getDigitalSignatureService().signZIPByERISubUser(theByteArray, dsERIUser);
		} catch (MissingPrivateKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EFileException(e);
		} catch (InvalidDigitalSignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EFileException(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EFileException(e);
		}
		
		if (erisoapHeaderSignatureResponse == null) {
			throw new EFileException("erisoapHeaderSignatureResponse == null");
		}
		
		//we are now SET to generate the SOAP Response
		//the SOAP response will use the erisoapHeaderSignatureResponse to sign the SOAP Header and then the part of the SOAP will be the ZIP attachment which are in theByeArray
		
		//we need to
		//getSubmitBulkPANService().
		//getSubmitBulkITRService().submitBulkITR(theZipFile)
		
		String certChain = erisoapHeaderSignatureResponse.getCertChain();
		String signature = erisoapHeaderSignatureResponse.getSignature();
		
		try {
			EFileResponse eFileResponse = getSubmitBulkITRService().submitBulkITR(userName, password, certChain, signature, theByteArray, absoluteBasePathToReturnDocuments ,wpm);
			return eFileResponse;
		} catch (MissingInformationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EFileException(e);
		} catch (DataMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EFileException(e);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EFileException(e);
		}
		//this is the flow
	}

	@Override
	public EFileResponse eFile(String userName, String password,String xml, String resellerId, String pan,
			FinancialYear financialYear,
			DigitalSignatureWrapper assesseSignature,
			DigitalSignatureWrapper eriSubUserSignature,String absoluteBasePathToReturnDocuments , WorkflowPersistenceManager wpm) throws DigtalSignatureAssesseeFailure, DigtalSignatureERIUserFailure, EFileException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public String findJCRPathToAssesseDigitalSignature(
			String canonicalPathToMemberIncomeTaxFolder) throws LoginException, RepositoryException {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			if (getSystemCredentials() != null) {
				session = getSystemRepository().login(getSystemCredentials());
			} else {
				session = getSystemRepository().login();
			}
			//get the personalinformation node
			//remember the digital signature is always stored in the member income tax folder and then named as digitalsignature
			Node digitalSignatureNode = session.getNode(canonicalPathToMemberIncomeTaxFolder + "/digitalsignature");
			if (digitalSignatureNode == null) {
				return null;
			}
			/*
			if (!memberPersonalInformationNode.hasProperty(getCanonicalHandlePathPropertyMemberPersonalInfo())) {
				return null;
			}
			Property propPathToDSHandle = memberPersonalInformationNode.getProperty(getCanonicalHandlePathPropertyMemberPersonalInfo());
			String retVal =  propPathToDSHandle.getString();
			return retVal;
			*/
			return digitalSignatureNode.getPath();
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
	public String findJCRPathToERISubUserDigitalSignature(
			String resellerId) throws LoginException, RepositoryException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//remember there is a hard document and then the actual document
		String absPathToResellerSignupDocument = "/content/documents/mootlywcm/resellers/" + resellerId + "/admin/resellersignupdocument/resellersignupdocument";
		
		Session session = null;
		try {
			if (getSystemCredentials() != null) {
				session = getSystemRepository().login(getSystemCredentials());
			} else {
				session = getSystemRepository().login();
			}
			//get the personalinformation node
			Node resellerSignupDocument = session.getNode(absPathToResellerSignupDocument);
			if (resellerSignupDocument == null) {
				return null;
			}
			if (!resellerSignupDocument.hasProperty(getCanonicalHandlePathPropertyResellerSignupDocument())) {
				return null;
			}
			Property propPathToDSHandle = resellerSignupDocument.getProperty(getCanonicalHandlePathPropertyResellerSignupDocument());
			String retVal =  propPathToDSHandle.getString();
			//this is the canonical handle UUID of the REAL DS
			Node theDigitalSignatureNode = session.getNodeByIdentifier(retVal);
			
			return theDigitalSignatureNode.getPath();
			//now find the property which will carry the canonicalhandlepath to the digital signature file 
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
	public DigitalSignatureService getSignatureService() {
		// TODO Auto-generated method stub
		return digitalSignatureService;
	}
	
	@Override
	public void setDigitalSignatureService(
			DigitalSignatureService digitalSignatureService) {
		// TODO Auto-generated method stub
		this.digitalSignatureService = digitalSignatureService;
	}
	
	
	public boolean assesseeHasDS(String canonicalPathToMemberIncomeTaxFolder) {
		boolean retVal = false;
		
		
		return retVal;
	}
	
	public boolean resellerHasDS(String canonicalPathToMemberIncomeTaxFolder) {
		boolean retVal = false;
		
		
		return retVal;
	}

	public final String getCanonicalHandlePathPropertyMemberPersonalInfo() {
		return canonicalHandlePathPropertyMemberPersonalInfo;
	}

	public final void setCanonicalHandlePathPropertyMemberPersonalInfo(
			String canonicalHandlePathPropertyMemberPersonalInfo) {
		this.canonicalHandlePathPropertyMemberPersonalInfo = canonicalHandlePathPropertyMemberPersonalInfo;
	}

	public final String getCanonicalHandlePathPropertyResellerSignupDocument() {
		return canonicalHandlePathPropertyResellerSignupDocument;
	}

	public final void setCanonicalHandlePathPropertyResellerSignupDocument(
			String canonicalHandlePathPropertyResellerSignupDocument) {
		this.canonicalHandlePathPropertyResellerSignupDocument = canonicalHandlePathPropertyResellerSignupDocument;
	}

	public final DigitalSignatureService getDigitalSignatureService() {
		return digitalSignatureService;
	}
	
	@Override
	public SubmitBulkITR getSubmitBulkITRService() {
		// TODO Auto-generated method stub
		return submitBulkITRService;
	}
	
	@Override
	public void setSubmitBulkITRService(SubmitBulkITR submitBulkITRService) {
		// TODO Auto-generated method stub
		this.submitBulkITRService = submitBulkITRService;
	}
	
}
