package com.mootly.wcm.model;

import com.mootly.wcm.validation.HippoBeanValidationGeneric;


public class ITReturnHomePageView {
	
	public FinancialYear getFinancialYear() {
		return financialYear;
	}
	
	public ITRForm getITRForm() {
		return itrForm;
	}
	
	public FilingSection getFilingSection() {
		return filingSection;
	}

	public ITRForm getItrForm() {
		return itrForm;
	}

	public ITRServiceDelivery getItrFormMode() {
		return itrFormMode;
	}

	public void setITRForm(ITRForm itrForm) {
		this.itrForm = itrForm;		
	}

	public void setFinancialYear(FinancialYear financialYear) {
		this.financialYear = financialYear;
	}

	public FilingStatus getFilingStatus() {
		return filingStatus;
	}

	public void setFilingStatus(FilingStatus filingStatus) {
		this.filingStatus = filingStatus;
	}

	public ITReturnType getItReturnType() {
		return itReturnType;
	}

	public void setItReturnType(ITReturnType itReturnType) {
		this.itReturnType = itReturnType;
	}
	
	public void setFilingSection(FilingSection filingSection) {
		this.filingSection = filingSection;
	}

	public void setItrForm(ITRForm itrForm) {
		this.itrForm = itrForm;
	}

	public void setItrFormMode(ITRServiceDelivery itrFormMode) {
		this.itrFormMode = itrFormMode;
	}

	public String getLastOrOrgName() {
		return lastOrOrgName;
	}

	public void setLastOrOrgName(String lastOrOrgName) {
		this.lastOrOrgName = lastOrOrgName;
	}
  public void setFullName(String fullname){
	  this.fullname=fullname;
  }
	public String getFullName(){
		return fullname;
	}
	public void setDOB(String dob){
		this.dob=dob;
	}
	public String getDOB(){
		return dob;
	}
	
	public void setITRFormMode(ITRServiceDelivery itrFormMode){
		this.itrFormMode=itrFormMode;
	}
	public ITRServiceDelivery getITRFormMode() {
		return itrFormMode;
	}
	
	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
		if (pan != null && pan.length() >= 4) setFilingStatus(FilingStatus.getEnumByFourthChar(pan.charAt(3)));
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCanonicalUUID() {
		return canonicalUUID;
	}

	public void setCanonicalUUID(String canonicalUUID) {
		this.canonicalUUID = canonicalUUID;
	}
	
	public String getDownloadSummaryURL() {
		return downloadSummaryURL;
	}

	public void setDownloadSummaryURL(String downloadSummaryURL) {
		this.downloadSummaryURL = downloadSummaryURL;
	}

	public String getDownloadXMLURL() {
		return downloadXMLURL;
	}

	public void setDownloadXMLURL(String downloadXMLURL) {
		this.downloadXMLURL = downloadXMLURL;
	}

	public String getEmailSummaryAndXMLURL() {
		return emailSummaryAndXMLURL;
	}

	public void setEmailSummaryAndXMLURL(String emailSummaryAndXMLURL) {
		this.emailSummaryAndXMLURL = emailSummaryAndXMLURL;
	}

	public String getViewReturnURL() {
		return viewReturnURL;
	}

	public void setViewReturnURL(String viewReturnURL) {
		this.viewReturnURL = viewReturnURL;
	}
	
	public String getItrFolderSuffix() {
		return itrFolderSuffix;
	}

	public void setItrFolderSuffix(String itrFolderSuffix) {
		this.itrFolderSuffix = itrFolderSuffix;
	}
	
	public String getPathToItr() {
		return pathToItr;
	}

	public void setPathToItr(String pathToItr) {
		this.pathToItr = pathToItr;
	}
	
	public String getUserName() {
		return userName;
	}

	/**
	 * @return the paymentStatus
	 */
	public String getPaymentStatus() {
		return paymentStatus;
	}

	public String getDob() {
		return dob;
	}
	/**
	 * @param paymentStatus the paymentStatus to set
	 */
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	/**
	 * @return the paymentType
	 */
	public String getPaymentType() {
		return paymentType;
	}

	public String getFullname() {
		return fullname;
	}
	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getTheParentFolder() {
		return theParentFolder;
	}

	public void setTheParentFolder(String theParentFolder) {
		this.theParentFolder = theParentFolder;
	}

	public HippoBeanValidationGeneric getFreezeIncomeTaxAction() {
		return freezeIncomeTaxAction;
	}

	public void setFreezeIncomeTaxAction(
			HippoBeanValidationGeneric freezeIncomeTaxAction) {
		this.freezeIncomeTaxAction = freezeIncomeTaxAction;
	}

	public boolean isFrozen() {
		return isFrozen;
	}

	public void setFrozen(boolean isFrozen) {
		this.isFrozen = isFrozen;
	}

	public String getAckResponse() {
		return ackResponse;
	}

	public void setAckResponse(String ackResponse) {
		this.ackResponse = ackResponse;
	}

	public String getTokenNumber() {
		return tokenNumber;
	}

	public void setTokenNumber(String tokenNumber) {
		this.tokenNumber = tokenNumber;
	}

	public String geteFileDateTime() {
		return eFileDateTime;
	}

	public void seteFileDateTime(String eFileDateTime) {
		this.eFileDateTime = eFileDateTime;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}





	String pan;
	FinancialYear financialYear;
	FilingStatus filingStatus;
	ITReturnType itReturnType;
	FilingSection filingSection;
	String itrFolderSuffix;
	ITRForm itrForm;
	ITRServiceDelivery itrFormMode;
	String canonicalUUID;
	
	String userName; //the person who filed it
	
	/*
	 * <li><a href="<hst:link path="/${basePath}/itreturn/${anEntry.financialYear.displayName}/${anEntry.filingSection.folderName}/${fn:toLowerCase(anEntry.pan)}/servicerequest-itr-download-summary.html"/>">Download Summary</a></li>
				                  <li><a href="<hst:link  path="/${basePath}/itreturn/${anEntry.financialYear.displayName}/${anEntry.filingSection.folderName}/${fn:toLowerCase(anEntry.pan)}/servicerequest-itr-download-xml.html" />">Download XML</a></li>
				                  <li><a href="<hst:link  path="/${basePath}/itreturn/${anEntry.financialYear.displayName}/${anEntry.filingSection.folderName}/${fn:toLowerCase(anEntry.pan)}/servicerequest-itr-email-xml-summary.html"/>?email=${anEntry.email}">Email Summary and XML</a></li>
	 */
	String downloadSummaryURL;
	String downloadXMLURL;
	String emailSummaryAndXMLURL;
	String viewReturnURL;
	
	String lastOrOrgName;
	String email;
	String dob;
	String fullname;
	
	String pathToItr;
	String theParentFolder;
	
	private String paymentStatus;
	private String paymentType;
	
	HippoBeanValidationGeneric freezeIncomeTaxAction;
	boolean isFrozen;
	String ackResponse;
	String tokenNumber;
	String eFileDateTime;
	
	
	
}
