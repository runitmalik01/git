/**
 * Copyright (C) 2010 Hippo B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mootly.wcm.beans;

import static com.mootly.wcm.utils.Constants.BD_ACC_NUMBER;
import static com.mootly.wcm.utils.Constants.BD_ADD_BANK_BRANCH;
import static com.mootly.wcm.utils.Constants.BD_BANK_NAME;
import static com.mootly.wcm.utils.Constants.BD_ECS;
import static com.mootly.wcm.utils.Constants.BD_MICR_CODE;
import static com.mootly.wcm.utils.Constants.BD_STATUS;
import static com.mootly.wcm.utils.Constants.BD_TYPE_ACC;
import static com.mootly.wcm.utils.Constants.PROP_PI_AREA_LOCALITY;
import static com.mootly.wcm.utils.Constants.PROP_PI_COUNTRY;
import static com.mootly.wcm.utils.Constants.PROP_PI_DEFECTIVE;
import static com.mootly.wcm.utils.Constants.PROP_PI_DOB;
import static com.mootly.wcm.utils.Constants.PROP_PI_EMAIL;
import static com.mootly.wcm.utils.Constants.PROP_PI_EMPLOYER_CATEGORY;
import static com.mootly.wcm.utils.Constants.PROP_PI_FATHER_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_FILING_STATUS;
import static com.mootly.wcm.utils.Constants.PROP_PI_FINANCIAL_YEAR;
import static com.mootly.wcm.utils.Constants.PROP_PI_FIRST_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_FLAT_FLOOR_BUILDING;
import static com.mootly.wcm.utils.Constants.PROP_PI_INCOME_TAX_WARD;
import static com.mootly.wcm.utils.Constants.PROP_PI_LAST_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_MIDDLE_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_MOBILE;
import static com.mootly.wcm.utils.Constants.PROP_PI_MOBILE1;
import static com.mootly.wcm.utils.Constants.PROP_PI_NOTICE_DATE;
import static com.mootly.wcm.utils.Constants.PROP_PI_NOTICE_NO;
import static com.mootly.wcm.utils.Constants.PROP_PI_ORIGINAL_ACK_DATE;
import static com.mootly.wcm.utils.Constants.PROP_PI_ORIGINAL_ACK_NO;
import static com.mootly.wcm.utils.Constants.PROP_PI_PAN;
import static com.mootly.wcm.utils.Constants.PROP_PI_PHONE;
import static com.mootly.wcm.utils.Constants.PROP_PI_PINCODE;
import static com.mootly.wcm.utils.Constants.PROP_PI_PORTUGESE_CIVIL;
import static com.mootly.wcm.utils.Constants.PROP_PI_PREMISES_BUILDING;
import static com.mootly.wcm.utils.Constants.PROP_PI_RECEIPT_NO;
import static com.mootly.wcm.utils.Constants.PROP_PI_RESIDENT_CATEGORY;
import static com.mootly.wcm.utils.Constants.PROP_PI_RETURN_FILE_SECTION;
import static com.mootly.wcm.utils.Constants.PROP_PI_RETURN_SECTION;
import static com.mootly.wcm.utils.Constants.PROP_PI_RETURN_TYPE;
import static com.mootly.wcm.utils.Constants.PROP_PI_ROAD_STREET;
import static com.mootly.wcm.utils.Constants.PROP_PI_SEX;
import static com.mootly.wcm.utils.Constants.PROP_PI_STATE;
import static com.mootly.wcm.utils.Constants.PROP_PI_STD_CODE;
import static com.mootly.wcm.utils.Constants.PROP_PI_TAX_STATUS;
import static com.mootly.wcm.utils.Constants.PROP_PI_TOWN_CITY_DISTRICT;
import static com.mootly.wcm.utils.Constants.PROP_PI_WARD_CIRCLE;
import static com.mootly.wcm.utils.Constants.Rsstatus_q;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_no;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_no_no;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_no_no_yes;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_no_no_yes_yes;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_no_yes;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_no_yes_yes;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_no_yes_yes_yes;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_yes;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_yes_yes;

import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import javax.jcr.RepositoryException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoMirror;

import com.mootly.wcm.beans.standard.FlexibleDocument;
import com.mootly.wcm.model.DITSubmissionStatus;
import com.mootly.wcm.model.FilingSection;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITRForm;
import com.mootly.wcm.model.ITRServiceDelivery;
import com.mootly.wcm.model.VerificationStatus;
import com.mootly.wcm.utils.Constants;

/**
 * User: vivek Date: Jun 29, 2010 Time: 11:26:35 AM
 */
@XmlAccessorType(XmlAccessType.NONE)
@Node(jcrType = "mootlywcm:MemberPersonalInformation")
public class MemberPersonalInformation extends FlexibleDocument implements
		ContentNodeBinder, FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:MemberPersonalInformation";
	static final public String NODE_NAME = "PersonalInformation";

	private String rbfilename = "rstatus_";
	private String rbfilenameNew = "rstatushuf_";
	private String choice = "";

	private String employerCategory;
	private String portugesecivil;
	private Long returnFileSection;
	private String incomeTaxWard;
	private String receiptNo;
	private String taxStatus;

	private String finacialYear;

	private String returnType;
	private String originalAckNo;
	private GregorianCalendar originalAckDate;
	private String defective;
	private String noticeNo;
	private GregorianCalendar noticeDate;
	private String firstName;
	private String middleName;
	private String lastName;
	private String ReturnSection;
	private String fatherName;
	private String PAN;
	private String filingStatus;
	private GregorianCalendar DOB;
	private String sex;

	private String flatDoorBuilding;
	private String premisesBuilding;
	private String roadStreet;
	private String areaLocality;
	private String townCityDistrict;
	private String state;
	private String country;
	private String ward_circle;
	private String pinCode;
	private String email;
	private String mobile;
	private String mobile1;
	private String stdCode;
	private String phone;
	private String Employe_category;
	private String accNumber;
	private String bankName;
	private String ecs;
	private String typeAcc;
	private String addBankBranch;
	private String micrCode;
	private Boolean bankDetailStatus;
	private String rsstatus_q;
	private String rsstatus_q_yes;
	private String rsstatus_q_yes_yes;
	private String rsstatus_q_no;
	private String rsstatus_q_no_yes;
	private String rsstatus_q_no_yes_yes;
	private String rsstatus_q_no_no;
	private String rsstatus_q_no_no_yes;
	private String rsstatus_q_no_no_yes_yes;
	private String rsstatus_q_no_yes_yes_yes;
	private String residentCategory;
	private String PIUUID;
	// added for itr2
	private String isRepresentative;
	private String name_Representative;
	private String address_Representative;
	private String pan_Representative;

	// added for itr4
	private String isLiable_ManageAcc;
	private String isLiable_ForAudit;
	private GregorianCalendar date_FurnishAuditReport;
	private String name_AuditorSign_Report;
	private String membershipNo_auditor;
	private String name_auditorFirm;
	private String pan_Firm;
	private GregorianCalendar date_AuditReport;
	private String isLiable_FurnishSec92E;
	// added for itr4s
	private String trpnumber;
	private String trpname;
	private Double trpreimbursement;
	private String isTaxPreparebyTRP;

	// DIT Integration
	private VerificationStatus ditVerificationStatus;
	private String ditVerificationMessage;
	// did the user choose to import from TDS
	private String choiceImportTDS;
	private Boolean importTDSSuccess;

	private DITSubmissionStatus ditSubmissionStatus;
	private String ditSubmissionToken;
	private String digitalSignatureHandleUUID;


	ResourceBundle messagesResourceBundle = ResourceBundle
			.getBundle("messages");

	// ITR1.packageName.DIY.cost
	public String getPrice() {
		String retValue = messagesResourceBundle.getString(getSelectedITRForm()
				.name()
				+ ".packageName."
				+ getSelectedServiceDeliveryOption().name() + ".cost");
		return retValue;
	}

	@XmlElement
	public ITRForm getSelectedITRForm() {
		String retValueString = getFlexField("flex_string_ITRForm", null);
		if (retValueString != null) {
			try {
				ITRForm itrForm = ITRForm.valueOf(retValueString);
				return itrForm;
			} catch (IllegalArgumentException e) {
				log.warn("There was an error parsing the value", e);
				return null;
			}
		}
		return null;
	}

	public ITRServiceDelivery getSelectedServiceDeliveryOption() {
		String retValueString = getFlexField("flex_string_ITRServiceDelivery",
				null);
		if (retValueString != null) {
			try {
				ITRServiceDelivery itrServiceDelivery = ITRServiceDelivery
						.valueOf(retValueString);
				return itrServiceDelivery;
			} catch (IllegalArgumentException e) {
				log.warn("There was an error parsing the value", e);
				return null;
			}
		}
		return null;
	}

	public String getTaxStatus() {
		if (taxStatus == null)
			taxStatus = getProperty(PROP_PI_TAX_STATUS);
		return taxStatus;
	}

	public String getPortugesecivil() {
		if (portugesecivil == null)
			portugesecivil = getProperty(PROP_PI_PORTUGESE_CIVIL);
		return portugesecivil;
	}

	public String getEmployerCategory() {
		if (employerCategory == null)
			employerCategory = getProperty(PROP_PI_EMPLOYER_CATEGORY);
		return employerCategory;
	}

	public String getReceiptNo() {
		if (receiptNo == null)
			receiptNo = getProperty(PROP_PI_RECEIPT_NO);
		return receiptNo;
	}

	public long getReturnFileSection() {
		if (returnFileSection == null)
			returnFileSection = getProperty(PROP_PI_RETURN_FILE_SECTION);
		return returnFileSection;
	}

	public String getIncomeTaxWard() {
		if (incomeTaxWard == null)
			incomeTaxWard = getProperty(PROP_PI_INCOME_TAX_WARD);
		return incomeTaxWard;
	}

	public String getFinancialYear() {
		if (finacialYear == null)
			finacialYear = getProperty(PROP_PI_FINANCIAL_YEAR);
		return finacialYear;
	}

	public String getReturnType() {
		if (returnType == null)
			returnType = getProperty(PROP_PI_RETURN_TYPE);
		return returnType;
	}

	public String getReturnSection() {
		if (ReturnSection == null)
			ReturnSection = getProperty(PROP_PI_RETURN_SECTION);
		return ReturnSection;
	}

	public FilingSection getFilingSection() {
		String strReturnSection = getReturnSection();
		try {
			FilingSection filingSection = FilingSection
					.getByXmlCode(strReturnSection);
			return filingSection;
		} catch (IllegalArgumentException ie) {
			return FilingSection.UNKNOWN;
		}
	}

	public String getOriginalAckNo() {
		if (originalAckNo == null)
			originalAckNo = getProperty(PROP_PI_ORIGINAL_ACK_NO);
		return originalAckNo;
	}

	public GregorianCalendar getOriginalAckDate() {
		if (originalAckDate == null)
			originalAckDate = getProperty(PROP_PI_ORIGINAL_ACK_DATE);
		return originalAckDate;
	}

	public String getAckDateStr() {
		if (originalAckDate == null)
			originalAckDate = getProperty(PROP_PI_ORIGINAL_ACK_DATE);
		if (originalAckDate != null) {
			String ackdateStr = getIndianDateFormatter().format(
					originalAckDate.getTime());
			return ackdateStr;
		}
		return null;
	}

	public String getDefective() {
		if (defective == null)
			defective = getProperty(PROP_PI_DEFECTIVE);
		return defective;
	}

	public String getNoticeNo() {
		if (noticeNo == null)
			noticeNo = getProperty(PROP_PI_NOTICE_NO);
		return noticeNo;
	}

	public GregorianCalendar getNoticeDate() {
		if (noticeDate == null)
			noticeDate = getProperty(PROP_PI_NOTICE_DATE);
		return noticeDate;
	}

	public String getNoticeDateStr() {
		if (noticeDate == null)
			noticeDate = getProperty(PROP_PI_NOTICE_DATE);
		if (noticeDate != null) {
			String noticeStr = getIndianDateFormatter().format(
					noticeDate.getTime());
			return noticeStr;
		}
		return null;
	}

	// This is just a calculated field
	public String getName() {
		StringBuffer sb = new StringBuffer();
		if (getFirstName() != null)
			sb.append(firstName).append(" ");
		if (getMiddleName() != null)
			sb.append(getMiddleName()).append(" ");
		if (getLastName() != null)
			sb.append(lastName);
		// as in case of HUF First Name and LAst Name is no Need so it save with
		// a "-".Need to remove these from Name on showed on Member Home Page
		return sb.toString().trim().replaceAll("-", "");
	}

	// for personal information
	public String getFirstName() {
		if (firstName == null)
			firstName = getProperty(PROP_PI_FIRST_NAME);
		return firstName;
	}

	public String getMiddleName() {
		if (middleName == null)
			middleName = getProperty(PROP_PI_MIDDLE_NAME);
		return middleName;
	}

	@XmlElement
	public String getLastName() {
		if (lastName == null)
			lastName = getProperty(PROP_PI_LAST_NAME);
		return lastName;
	}

	@XmlElement
	public String getFatherName() {
		if (fatherName == null)
			fatherName = getProperty(PROP_PI_FATHER_NAME);
		return fatherName;
	}

	@XmlElement
	public String getEmploye_category() {
		if (Employe_category == null)
			Employe_category = getProperty(PROP_PI_EMPLOYER_CATEGORY);
		return Employe_category;
	}

	public String getPAN() {
		if (PAN == null)
			PAN = getProperty(PROP_PI_PAN);
		return PAN;
	}

	public String getFilingStatus() {
		if (filingStatus == null)
			filingStatus = getProperty(PROP_PI_FILING_STATUS);
		return filingStatus;
	}

	public GregorianCalendar getDOB() {
		if (DOB == null)
			DOB = getProperty(PROP_PI_DOB);
		return DOB;
	}

	public String getDOBStr() {
		if (DOB == null)
			DOB = getProperty(PROP_PI_DOB);
		if (DOB != null) {
			String dobStr = getIndianDateFormatter().format(DOB.getTime());
			return dobStr;
		}
		return null;
	}

	@XmlElement
	public String getSex() {
		if (sex == null)
			sex = getProperty(PROP_PI_SEX);
		return sex;
	}

	@XmlElement
	public String getFlatDoorBuilding() {
		if (flatDoorBuilding == null)
			flatDoorBuilding = getProperty(PROP_PI_FLAT_FLOOR_BUILDING);
		return flatDoorBuilding;
	}

	@XmlElement
	public String getPremisesBuilding() {
		if (premisesBuilding == null)
			premisesBuilding = getProperty(PROP_PI_PREMISES_BUILDING);
		return premisesBuilding;
	}

	@XmlElement
	public String getRoadStreet() {
		if (roadStreet == null)
			roadStreet = getProperty(PROP_PI_ROAD_STREET);
		return roadStreet;
	}

	@XmlElement
	public String getAreaLocality() {
		if (areaLocality == null)
			areaLocality = getProperty(PROP_PI_AREA_LOCALITY);
		return areaLocality;
	}

	public String getTownCityDistrict() {
		if (townCityDistrict == null)
			townCityDistrict = getProperty(PROP_PI_TOWN_CITY_DISTRICT);
		return townCityDistrict;
	}

	public String getState() {
		if (state == null)
			state = getProperty(PROP_PI_STATE);
		return state;
	}

	public String getCountry() {
		if (country == null)
			country = getProperty(PROP_PI_COUNTRY);
		return country;
	}

	public String getPinCode() {
		if (pinCode == null)
			pinCode = getProperty(PROP_PI_PINCODE);
		return pinCode;
	}

	public String getEmail() {
		if (email == null)
			email = getProperty(PROP_PI_EMAIL);
		return email;
	}

	public String getMobile() {
		if (mobile == null)
			mobile = getProperty(PROP_PI_MOBILE);
		return mobile;
	}

	public String getMobile1() {
		if (mobile1 == null)
			mobile1 = getProperty(PROP_PI_MOBILE1);
		return mobile1;
	}

	public String getStdCode() {
		if (stdCode == null)
			stdCode = getProperty(PROP_PI_STD_CODE);
		return stdCode;
	}

	public String getWard_circle() {
		if (ward_circle == null)
			ward_circle = getProperty(PROP_PI_WARD_CIRCLE);
		return ward_circle;
	}

	public String getPhone() {
		if (phone == null)
			phone = getProperty(PROP_PI_PHONE);
		return phone;
	}

	// the following 4 methods are for itr2
	public String getIsRepresentative() {
		if (isRepresentative == null)
			isRepresentative = getProperty("mootlywcm:isRepresentative");
		return isRepresentative;
	}

	public String getName_Representative() {
		if (name_Representative == null)
			name_Representative = getProperty("mootlywcm:name_Representative");
		return name_Representative;
	}

	public String getAddress_Representative() {
		if (address_Representative == null)
			address_Representative = getProperty("mootlywcm:address_Representative");
		return address_Representative;
	}

	public String getPan_Representative() {
		if (pan_Representative == null)
			pan_Representative = getProperty("mootlywcm:pan_Representative");
		return pan_Representative;
	}

	// the following 9 to 10 methods are for itr4

	public String getIsLiable_ManageAcc() {
		if (isLiable_ManageAcc == null)
			isLiable_ManageAcc = getProperty("mootlywcm:isLiable_ManageAcc");
		return isLiable_ManageAcc;
	}

	public String getIsLiable_ForAudit() {
		if (isLiable_ForAudit == null)
			isLiable_ForAudit = getProperty("mootlywcm:isLiable_ForAudit");
		return isLiable_ForAudit;
	}

	public String getName_AuditorSign_Report() {
		if (name_AuditorSign_Report == null)
			name_AuditorSign_Report = getProperty("mootlywcm:name_AuditorSign_Report");
		return name_AuditorSign_Report;
	}

	public String getMembershipNo_auditor() {
		if (membershipNo_auditor == null)
			membershipNo_auditor = getProperty("mootlywcm:membershipNo_auditor");
		return membershipNo_auditor;
	}

	public String getName_auditorFirm() {
		if (name_auditorFirm == null)
			name_auditorFirm = getProperty("mootlywcm:name_auditorFirm");
		return name_auditorFirm;
	}

	public String getPan_Firm() {
		if (pan_Firm == null)
			pan_Firm = getProperty("mootlywcm:pan_Firm");
		return pan_Firm;
	}

	public GregorianCalendar getDate_AuditReport() {
		if (date_AuditReport == null)
			date_AuditReport = getProperty("mootlywcm:date_AuditReport");
		return date_AuditReport;
	}

	public String getDate_AuditReportStr() {
		if (date_AuditReport == null)
			date_AuditReport = getProperty("mootlywcm:date_AuditReport");
		if (date_AuditReport != null) {
			String date_AuditReportStr = getIndianDateFormatter().format(
					date_AuditReport.getTime());
			return date_AuditReportStr;
		}
		return null;
	}


	public GregorianCalendar getDate_FurnishAuditReport() {
		if (date_FurnishAuditReport == null)
			date_FurnishAuditReport = getProperty("mootlywcm:date_FurnishAuditReport");
		return date_FurnishAuditReport;
	}

	public String getDate_FurnishAuditReportStr() {
		if (date_FurnishAuditReport == null)
			date_FurnishAuditReport = getProperty("mootlywcm:date_FurnishAuditReport");
		if (date_FurnishAuditReport != null) {
			String date_FurnishAuditReportStr = getIndianDateFormatter()
					.format(date_FurnishAuditReport.getTime());
			return date_FurnishAuditReportStr;
		}
		return null;
	}


	public String getIsLiable_FurnishSec92E() {
		if (isLiable_FurnishSec92E == null)
			isLiable_FurnishSec92E = getProperty("mootlywcm:isLiable_FurnishSecNinetyTwoE");
		return isLiable_FurnishSec92E;
	}


	public String getPersonalInfoUuid() {
		return PIUUID;
	}

	public VerificationStatus getDitVerificationStatus() {
		String ditVerificationStatusStr = null;
		if (ditVerificationStatus == null)
			ditVerificationStatusStr = getProperty("mootlywcm:ditVerificationStatus");
		if (ditVerificationStatusStr != null
				&& !"".equals(ditVerificationStatusStr.trim())) {
			try {
				ditVerificationStatus = VerificationStatus
						.valueOf(ditVerificationStatusStr);
			} catch (IllegalArgumentException e) {
				log.warn(
						"Problem converting String to ditVerificationStatus ditSubmissionStatusStr = "
								+ ditVerificationStatusStr, e);
			}
		}
		return ditVerificationStatus;
	}

	public final String getDitVerificationMessage() {
		if (ditVerificationMessage == null)
			ditVerificationMessage = getProperty("mootlywcm:ditVerificationMessage");
		return ditVerificationMessage;
	}

	public String getChoiceImportTDS() {
		if (choiceImportTDS == null)
			choiceImportTDS = getProperty("mootlywcm:choiceImportTDS");
		return choiceImportTDS;
	}

	public Boolean getImportTDSSuccess() {
		if (importTDSSuccess == null)
			importTDSSuccess = getProperty("mootlywcm:importTDSSuccess");
		return importTDSSuccess;
	}

	public final DITSubmissionStatus getDitSubmissionStatus() {
		if (ditSubmissionStatus == null) {
			String ditSubmissionStatusStr = getProperty("mootlywcm:ditSubmissionStatus");
			try {
				if (ditSubmissionStatusStr != null
						&& !"".equals(ditSubmissionStatusStr.trim())) {
					ditSubmissionStatus = DITSubmissionStatus
							.valueOf(ditSubmissionStatusStr);
				}
			} catch (IllegalArgumentException e) {
				log.warn("Error converting the value " + ditSubmissionStatusStr
						+ " to a valid ENUM");
			}
		}
		return ditSubmissionStatus;
	}

	public final String getDitSubmissionToken() {
		if (ditSubmissionToken == null)
			ditSubmissionToken = getProperty("mootlywcm:ditSubmissionToken");
		return ditSubmissionToken;
	}

	public final void setReturnSection(String ReturnSection) {
		this.ReturnSection = ReturnSection;
	}

	public final void setPortugesecivil(String portugesecivil) {
		this.portugesecivil = portugesecivil;
	}

	public final void setTaxStatus(String taxStatus) {
		this.taxStatus = taxStatus;
	}

	public final void setIncomeTaxWard(String incomeTaxWard) {
		this.incomeTaxWard = incomeTaxWard;
	}

	public final void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public final void setEmployerCategory(String employerCategory) {
		this.employerCategory = employerCategory;
	}

	public final void setReturnFileSection(long returnFileSection) {
		this.returnFileSection = returnFileSection;
	}

	public final void setFinancialYear(String finacialYear) {
		this.finacialYear = finacialYear;
	}

	public final void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public final void setOriginalAckNo(String originalAckNo) {
		this.originalAckNo = originalAckNo;
	}

	public final void setOriginalAckDate(GregorianCalendar originalAckDate) {
		this.originalAckDate = originalAckDate;
	}

	public final void setDefective(String defective) {
		this.defective = defective;
	}

	public final void setNoticeNo(String noticeNo) {
		this.noticeNo = noticeNo;
	}

	public final void setNoticeDate(GregorianCalendar noticeDate) {
		this.noticeDate = noticeDate;
	}

	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public final void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public final void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public final void setEmploye_category(String Employe_category) {
		this.Employe_category = Employe_category;
	}

	public final void setPAN(String pAN) {
		this.PAN = pAN;
	}

	public final void setFilingStatus(String filingStatus) {
		this.filingStatus = filingStatus;
	}

	public final void setDOB(GregorianCalendar dOB) {
		this.DOB = dOB;
	}

	public final void setSex(String sex) {
		this.sex = sex;
	}

	// Member Contact Information
	public final void setFlatDoorBuilding(String flatDoorBuilding) {
		this.flatDoorBuilding = flatDoorBuilding;
	}

	public final void setPremisesBuilding(String premisesBuilding) {
		this.premisesBuilding = premisesBuilding;
	}

	public final void setRoadStreet(String roadStreet) {
		this.roadStreet = roadStreet;
	}

	public final void setAreaLocality(String areaLocality) {
		this.areaLocality = areaLocality;
	}

	public final void setTownCityDistrict(String townCityDistrict) {
		this.townCityDistrict = townCityDistrict;
	}

	public final void setState(String state) {
		this.state = state;
	}

	public final void setCountry(String country) {
		this.country = country;
	}

	public final void setWard_circle(String ward_circle) {
		this.ward_circle = ward_circle;
	}


	public final void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public final void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public final void setStdCode(String stdCode) {
		this.stdCode = stdCode;
	}

	public final void setPhone(String phone) {
		this.phone = phone;
	}

	// Member Bank Detail
	public Boolean getBankDetailStatus() {
		if (bankDetailStatus == null)
			bankDetailStatus = getProperty(BD_STATUS);
		return bankDetailStatus;
	}

	public String getBD_ADD_BANK_BRANCH() {
		if (addBankBranch == null)
			addBankBranch = getProperty(BD_ADD_BANK_BRANCH);
		return addBankBranch;
	}

	public String getBD_MICR_CODE() {
		if (micrCode == null)
			micrCode = getProperty(BD_MICR_CODE);
		return micrCode;
	}

	public String getBD_ACC_NUMBER() {
		if (accNumber == null)
			accNumber = getProperty(BD_ACC_NUMBER);
		return accNumber;
	}

	public String getBD_BANK_NAME() {
		if (bankName == null)
			bankName = getProperty(BD_BANK_NAME);
		return bankName;
	}

	public String getBD_ECS() {
		if (ecs == null)
			ecs = getProperty(BD_ECS);
		return ecs;
	}

	public String getBD_TYPE_ACC() {
		if (typeAcc == null)
			typeAcc = getProperty(BD_TYPE_ACC);
		return typeAcc;
	}

	public final void setBD_MICR_CODE(String micrCode) {
		this.micrCode = micrCode;
	}

	public final void setBD_ADD_BANK_BRANCH(String addBankBranch) {
		this.addBankBranch = addBankBranch;
	}

	public final void setBD_ACC_NUMBER(String accNumber) {
		this.accNumber = accNumber;
	}

	public final void setBD_BANK_NAME(String bankName) {
		this.bankName = bankName;
	}

	public final void setBD_ECS(String ecs) {
		this.ecs = ecs;
	}

	public final void setBD_TYPE_ACC(String typeAcc) {
		this.typeAcc = typeAcc;
	}

	public final void setBankDetailStatus(Boolean bankDetailStatus) {
		this.bankDetailStatus = bankDetailStatus;
	}

	public String getRsstatusQ() {
		if (rsstatus_q == null)
			rsstatus_q = getProperty(Rsstatus_q);
		return rsstatus_q;
	}

	public String getRsstatusQNoNoYes() {
		if (rsstatus_q_no_no_yes == null)
			rsstatus_q_no_no_yes = getProperty(Rsstatus_q_no_no_yes);
		return rsstatus_q_no_no_yes;
	}

	public String getRsstatusQNoNoYesYes() {
		if (rsstatus_q_no_no_yes_yes == null)
			rsstatus_q_no_no_yes_yes = getProperty(Rsstatus_q_no_no_yes_yes);
		return rsstatus_q_no_no_yes_yes;
	}

	public String getRsstatusQNoYesYesYes() {
		if (rsstatus_q_no_yes_yes_yes == null)
			rsstatus_q_no_yes_yes_yes = getProperty(Rsstatus_q_no_yes_yes_yes);
		return rsstatus_q_no_yes_yes_yes;
	}

	public String getRsstatusQYes() {
		if (rsstatus_q_yes == null)
			rsstatus_q_yes = getProperty(Rsstatus_q_yes);
		return rsstatus_q_yes;
	}

	public String getRsstatusQYesYes() {
		if (rsstatus_q_yes_yes == null)
			rsstatus_q_yes_yes = getProperty(Rsstatus_q_yes_yes);
		return rsstatus_q_yes_yes;
	}

	public String getRsstatusQNo() {
		if (rsstatus_q_no == null)
			rsstatus_q_no = getProperty(Rsstatus_q_no);
		return rsstatus_q_no;
	}

	public String getRsstatusQNoYes() {
		if (rsstatus_q_no_yes == null)
			rsstatus_q_no_yes = getProperty(Rsstatus_q_no_yes);
		return rsstatus_q_no_yes;
	}

	public String getRsstatusQNoYesYes() {
		if (rsstatus_q_no_yes_yes == null)
			rsstatus_q_no_yes_yes = getProperty(Rsstatus_q_no_yes_yes);
		return rsstatus_q_no_yes_yes;
	}

	public String getRsstatusQNoNo() {
		if (rsstatus_q_no_no == null)
			rsstatus_q_no_no = getProperty(Rsstatus_q_no_no);
		return rsstatus_q_no_no;
	}

	public String getResidentCategory() {
		if (residentCategory == null)
			residentCategory = getProperty(PROP_PI_RESIDENT_CATEGORY);
		return residentCategory;
	}

	public final void setRsstatusQ(String rsstatus_q) {
		this.rsstatus_q = rsstatus_q;
	}

	public final void setRsstatusQNoNoYes(String rsstatus_q_no_no_yes) {
		this.rsstatus_q_no_no_yes = rsstatus_q_no_no_yes;
	}

	public final void setRsstatusQNoNoYesYes(String rsstatus_q_no_no_yes_yes) {
		this.rsstatus_q_no_no_yes_yes = rsstatus_q_no_no_yes_yes;
	}

	public final void setRsstatusQNoYesYesYes(String rsstatus_q_no_yes_yes_yes) {
		this.rsstatus_q_no_yes_yes_yes = rsstatus_q_no_yes_yes_yes;
	}

	public final void setRsstatusQYes(String rsstatus_q_yes) {
		this.rsstatus_q_yes = rsstatus_q_yes;
	}

	public final void setRsstatusQYesYes(String rsstatus_q_yes_yes) {
		this.rsstatus_q_yes_yes = rsstatus_q_yes_yes;
	}

	public final void setRsstatusQNo(String rsstatus_q_no) {
		this.rsstatus_q_no = rsstatus_q_no;
	}

	public final void setRsstatusQNoYes(String rsstatus_q_no_yes) {
		this.rsstatus_q_no_yes = rsstatus_q_no_yes;
	}

	public final void setRsstatusQNoYesYes(String rsstatus_q_no_yes_yes) {
		this.rsstatus_q_no_yes_yes = rsstatus_q_no_yes_yes;
	}

	public final void setRsstatusQNoNo(String rsstatus_q_no_no) {
		this.rsstatus_q_no_no = rsstatus_q_no_no;
	}

	public final void setResidentCategory(String residentCategory) {
		this.residentCategory = residentCategory;
	}

	public void setPersonalInforUuid(String piuuid) {
		this.PIUUID = piuuid;
	}

	// next 4 methods are added for itr2
	public final void setIsRepresentative(String isRepresentative) {
		this.isRepresentative = isRepresentative;
	}

	public final void setName_Representative(String name_Representative) {
		this.name_Representative = name_Representative;
	}

	public final void setAddress_Representative(String address_Representative) {
		this.address_Representative = address_Representative;
	}

	public final void setPan_Representative(String pan_Representative) {
		this.pan_Representative = pan_Representative;
	}

	// next 9 to 10 methods are added for itr4
	public final void setIsLiable_ManageAcc(String isLiable_ManageAcc) {
		this.isLiable_ManageAcc = isLiable_ManageAcc;
	}

	public final void setIsLiable_ForAudit(String isLiable_ForAudit) {
		this.isLiable_ForAudit = isLiable_ForAudit;
	}


	public final void setDate_FurnishAuditReport(
			GregorianCalendar date_FurnishAuditReport) {
		this.date_FurnishAuditReport = date_FurnishAuditReport;
	}

	public final void setName_AuditorSign_Report(String name_AuditorSign_Report) {
		this.name_AuditorSign_Report = name_AuditorSign_Report;
	}

	public final void setMembershipNo_auditor(String membershipNo_auditor) {
		String modify_membershipNo_auditor = ModifyMembershipNo_Auditor(membershipNo_auditor);
		this.membershipNo_auditor = modify_membershipNo_auditor;
	}

	public final void setName_auditorFirm(String name_auditorFirm) {
		this.name_auditorFirm = name_auditorFirm;
	}

	public final void setPan_Firm(String pan_Firm) {
		this.pan_Firm = pan_Firm;
	}

	public final void setDate_AuditReport(GregorianCalendar date_AuditReport) {
		this.date_AuditReport = date_AuditReport;
	}


	public final void setIsLiable_FurnishSec92E(String isLiable_FurnishSec92E) {
		this.isLiable_FurnishSec92E = isLiable_FurnishSec92E;
	}

	public void setDitVerificationStatus(
			VerificationStatus ditVerificationStatus) {
		this.ditVerificationStatus = ditVerificationStatus;
	}

	public void setDitVerificationMessage(String ditVerificationMessage) {
		this.ditVerificationMessage = ditVerificationMessage;
	}

	public void setChoiceImportTDS(String choiceImportTDS) {
		this.choiceImportTDS = choiceImportTDS;
	}

	public void setImportTDSSuccess(Boolean importTDSSuccess) {
		this.importTDSSuccess = importTDSSuccess;
	}

	public final void setDitSubmissionStatus(
			DITSubmissionStatus ditSubmissionStatus) {
		this.ditSubmissionStatus = ditSubmissionStatus;
	}

	public final void setDitSubmissionToken(String ditSubmissionToken) {
		this.ditSubmissionToken = ditSubmissionToken;
	}

	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			super.bindToNode(node);

			MemberPersonalInformation mpi = (MemberPersonalInformation) content;
			node.setProperty(PROP_PI_FINANCIAL_YEAR, mpi.getFinancialYear());
			node.setProperty(PROP_PI_RETURN_TYPE, mpi.getReturnType());
			node.setProperty(PROP_PI_ORIGINAL_ACK_DATE,
					mpi.getOriginalAckDate());
			node.setProperty(PROP_PI_ORIGINAL_ACK_NO, mpi.getOriginalAckNo());
			node.setProperty(PROP_PI_NOTICE_DATE, mpi.getNoticeDate());
			node.setProperty(PROP_PI_NOTICE_NO, mpi.getNoticeNo());
			node.setProperty(PROP_PI_DEFECTIVE, mpi.getDefective());
			node.setProperty(PROP_PI_RECEIPT_NO, mpi.getReceiptNo());
			node.setProperty(PROP_PI_INCOME_TAX_WARD, mpi.getIncomeTaxWard());
			node.setProperty(PROP_PI_RETURN_FILE_SECTION,
					mpi.getReturnFileSection());
			// node.setProperty(PROP_PI_EMPLOYER_CATEGORY,mpi.getEmployerCategory());
			node.setProperty(PROP_PI_TAX_STATUS, mpi.getTaxStatus());
			node.setProperty(PROP_PI_EMPLOYER_CATEGORY,
					mpi.getEmploye_category());
			node.setProperty(PROP_PI_FIRST_NAME, mpi.getFirstName());
			node.setProperty(PROP_PI_MIDDLE_NAME, mpi.getMiddleName());
			node.setProperty(PROP_PI_LAST_NAME, mpi.getLastName());
			node.setProperty(PROP_PI_FATHER_NAME, mpi.getFatherName());
			node.setProperty(PROP_PI_PAN, mpi.getPAN());
			node.setProperty(PROP_PI_FILING_STATUS, mpi.getFilingStatus());
			node.setProperty(PROP_PI_PORTUGESE_CIVIL, mpi.getPortugesecivil());
			node.setProperty(PROP_PI_DOB, mpi.getDOB());
			node.setProperty(PROP_PI_RETURN_SECTION, mpi.getReturnSection());
			node.setProperty(PROP_PI_DOB, mpi.getDOB());
			node.setProperty(PROP_PI_SEX, mpi.getSex());
			node.setProperty(PROP_PI_RESIDENT_CATEGORY,
					mpi.getResidentCategory());
			node.setProperty(PROP_PI_FLAT_FLOOR_BUILDING,
					mpi.getFlatDoorBuilding());
			node.setProperty(PROP_PI_PREMISES_BUILDING,
					mpi.getPremisesBuilding());
			node.setProperty(PROP_PI_ROAD_STREET, mpi.getRoadStreet());
			node.setProperty(PROP_PI_AREA_LOCALITY, mpi.getAreaLocality());
			node.setProperty(PROP_PI_TOWN_CITY_DISTRICT,
					mpi.getTownCityDistrict());
			node.setProperty(PROP_PI_STATE, mpi.getState());
			node.setProperty(PROP_PI_COUNTRY, mpi.getCountry());
			node.setProperty(PROP_PI_PINCODE, mpi.getPinCode());
			node.setProperty(PROP_PI_EMAIL, mpi.getEmail());
			node.setProperty(PROP_PI_MOBILE, mpi.getMobile());
			node.setProperty(PROP_PI_MOBILE1, mpi.getMobile1());
			node.setProperty(PROP_PI_WARD_CIRCLE, mpi.getWard_circle());
			node.setProperty(PROP_PI_STD_CODE, mpi.getStdCode());
			node.setProperty(PROP_PI_PHONE, mpi.getPhone());
			node.setProperty(BD_ACC_NUMBER, mpi.getBD_ACC_NUMBER());
			node.setProperty(BD_BANK_NAME, mpi.getBD_BANK_NAME());
			node.setProperty(BD_ECS, mpi.getBD_ECS());
			node.setProperty(BD_TYPE_ACC, mpi.getBD_TYPE_ACC());
			node.setProperty(BD_ADD_BANK_BRANCH, mpi.getBD_ADD_BANK_BRANCH());
			node.setProperty(BD_MICR_CODE, mpi.getBD_MICR_CODE());
			node.setProperty(Rsstatus_q, mpi.getRsstatusQ());
			node.setProperty(Rsstatus_q_yes, mpi.getRsstatusQYes());
			node.setProperty(Rsstatus_q_yes_yes, mpi.getRsstatusQYesYes());
			node.setProperty(Rsstatus_q_no, mpi.getRsstatusQNo());
			node.setProperty(Rsstatus_q_no_yes, mpi.getRsstatusQNoYes());
			node.setProperty(Rsstatus_q_no_yes_yes, mpi.getRsstatusQNoYesYes());
			node.setProperty(Rsstatus_q_no_no, mpi.getRsstatusQNoNo());
			node.setProperty(Rsstatus_q_no_no_yes, mpi.getRsstatusQNoNoYes());
			node.setProperty(Rsstatus_q_no_no_yes_yes,
					mpi.getRsstatusQNoNoYesYes());
			node.setProperty(Rsstatus_q_no_yes_yes_yes,
					mpi.getRsstatusQNoYesYesYes());
			// added for itr2
			node.setProperty("mootlywcm:isRepresentative",
					mpi.getIsRepresentative());
			node.setProperty("mootlywcm:name_Representative",
					mpi.getName_Representative());
			node.setProperty("mootlywcm:address_Representative",
					mpi.getAddress_Representative());
			node.setProperty("mootlywcm:pan_Representative",
					mpi.getPan_Representative());
			// added for itr4
			node.setProperty("mootlywcm:isLiable_ManageAcc",
					mpi.getIsLiable_ManageAcc());
			node.setProperty("mootlywcm:isLiable_ForAudit",
					mpi.getIsLiable_ForAudit());
			node.setProperty("mootlywcm:date_FurnishAuditReport",
					mpi.getDate_FurnishAuditReport());
			node.setProperty("mootlywcm:name_AuditorSign_Report",
					mpi.getName_AuditorSign_Report());
			node.setProperty("mootlywcm:membershipNo_auditor",
					mpi.getMembershipNo_auditor());
			node.setProperty("mootlywcm:name_auditorFirm",
					mpi.getName_auditorFirm());
			node.setProperty("mootlywcm:pan_Firm", mpi.getPan_Firm());
			node.setProperty("mootlywcm:date_AuditReport",
					mpi.getDate_AuditReport());
			// added for itr4s
			node.setProperty("mootlywcm:trpname", mpi.getTrpname());
			node.setProperty("mootlywcm:trpnumber", mpi.getTrpnumber());
			if (mpi.getTrpreimbursement() != null)
				node.setProperty("mootlywcm:trpreimbursement",
						mpi.getTrpreimbursement());
			if (mpi.getIsTaxPreparebyTRP() != null)
				node.setProperty("mootlywcm:isTaxPreparebyTRP",
						mpi.getIsTaxPreparebyTRP());
			if (mpi.getIsLiable_FurnishSec92E() != null)
				node.setProperty("mootlywcm:isLiable_FurnishSecNinetyTwoE",
						mpi.getIsLiable_FurnishSec92E());

			if (mpi.getDitVerificationStatus() != null) {
				node.setProperty("mootlywcm:ditVerificationStatus", mpi
						.getDitVerificationStatus().name());
			}

			if (mpi.getDitVerificationMessage() != null) {
				node.setProperty("mootlywcm:ditVerificationMessage",
						mpi.getDitVerificationMessage());
			}

			if (mpi.getChoiceImportTDS() != null) {
				node.setProperty("mootlywcm:choiceImportTDS",
						mpi.getChoiceImportTDS());
			}

			if (mpi.getImportTDSSuccess() != null) {
				node.setProperty("mootlywcm:importTDSSuccess",
						mpi.getImportTDSSuccess());
			}

			if (mpi.getDitSubmissionStatus() != null) {
				node.setProperty("mootlywcm:ditSubmissionStatus", mpi
						.getDitSubmissionStatus().name());
			}

			if (mpi.getDitSubmissionToken() != null) {
				node.setProperty("mootlywcm:ditSubmissionToken",
						mpi.getDitSubmissionToken());
			}
			javax.jcr.Node digitalSignatureNode = null;
			if (node.hasNode("mootlywcm:pathToDigitalSignature")) {
				digitalSignatureNode = node
						.getNode("mootlywcm:pathToDigitalSignature");
			}else{
				digitalSignatureNode = node.addNode(
						"mootlywcm:pathToDigitalSignature",
						Constants.NT_HIPPO_MIRROR);
			if(digitalSignatureNode != null){
					digitalSignatureNode.setProperty(Constants.PROP_HIPPO_DOCBASE, getDigitalSignatureHandleUUID());
							Constants.PROP_HIPPO_DOCBASE,
							getDigitalSignatureHandleUUID());
					digitalSignatureNode.setProperty("hippo:docbase",
							"cafebabe-cafe-babe-cafe-babecafebabe");
				}				
			}
			/*
			/*if (digitalSignatureNode!= null) {
					digitalSignatureNode.setProperty("hippo:docbase", "cafebabe-cafe-babe-cafe-babecafebabe");
			 * "cafebabe-cafe-babe-cafe-babecafebabe"); }
				}*/
			node.setProperty("mootlywcm:sourceIncPackSelect", mpi.getSourceIncPackSelect());
					mpi.getSourceIncPackSelect());
			node.setProperty("mootlywcm:sourceIncPackSelectKey", mpi.getSourceIncPackSelectKey());
					mpi.getSourceIncPackSelectKey());

		} catch (RepositoryException re) {
			log.error("Binding Node Error", re);

		}
		return true;
	}

	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		super.fill(formMap);
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");
		}
		log.info("here areeeeeee"+getFilingStatus());
		if (formMap == null)
			return;
		if (formMap.getField("tax_status") != null)
			setTaxStatus(formMap.getField("tax_status").getValue());
		if (formMap.getField("return_section") != null)
			setReturnFileSection(Long.parseLong(formMap.getField(
					"return_section").getValue()));
		if (formMap.getField("emp_category") != null)
			setEmployerCategory(formMap.getField("emp_category").getValue());
		if (formMap.getField("receipt_no") != null)
			setReceiptNo(formMap.getField("receipt_no").getValue());
		if (formMap.getField("tax_ward") != null)
			setIncomeTaxWard(formMap.getField("tax_ward").getValue());
		if (formMap.getField("portugesecivil") != null)
			setPortugesecivil(formMap.getField("portugesecivil").getValue());
		// new changes for Return Filed under section on 06/08/2013
		String returnTypeChoice = formMap.getField("returnTypeChoice").getValue();
			revisingWithNoticeSection = formMap.getField("revisingWithNoticeSection").getValue();
					"revisingWithNoticeSection").getValue();

		FinancialYear finanYr = FinancialYear.TwentyTweleve;
		for (FinancialYear financialYear : FinancialYear.values()) {
			if (!financialYear.equals(FinancialYear.UNKNOWN)) {
					if (financialYear.getDisplayName().equals(
							formMap.getField("fy").getValue())) {
					finanYr = financialYear;
				}
			}
		}
		FilingSection filingSection;
		// revisingWithNoticeSection")
			isPastDue = finanYr.isPastDue(getSelectedITRForm(), formMap.getField("pi_state").getValue());
					.getField("pi_state").getValue());
			filingSection = FilingSection.AfterDueDate_139_4;
		} else {
			filingSection = FilingSection.BeforeDueDate_139_1;
		}

		if (returnTypeChoice != null
				&& ("revisingNoNotice".equals(returnTypeChoice))) {
			setReturnType("R");
			filingSection = FilingSection.Revised_139_5;
		} else if (returnTypeChoice != null
				&& "revisingWithNotice".equals(returnTypeChoice)) {
			setReturnType("O");
			filingSection = FilingSection
					.getByXmlCode(revisingWithNoticeSection);

		}
		else {
			setReturnType("O");
		}
		if (filingSection != null
				&& filingSection == FilingSection.Revised_139_9) {
			setDefective("Y");
		}
		else {
			setDefective("N");
		}
		// if ( formMap.getField("pi_return_type") != null)
		// setReturnType(formMap.getField("pi_return_type").getValue());
		if (formMap.getField("fy") != null) {
			setFinancialYear(formMap.getField("fy").getValue());
			if (StringUtils.isNotEmpty(formMap.getField("fy").getValue())) {
				rbfilename = rbfilename + formMap.getField("fy").getValue();
				rbfilenameNew = rbfilenameNew
						+ formMap.getField("fy").getValue();
			} else {
				rbfilename = rbfilename + "2012-2013";
				rbfilenameNew = rbfilenameNew + "2012-2013";
			}
		}
		if (formMap.getField("ack_date") != null) {
			String strDate = formMap.getField("ack_date").getValue();
			setOriginalAckDate(ConvDateStringToCalendar(strDate));
		}
		if (formMap.getField("ack_no") != null)
			setOriginalAckNo(formMap.getField("ack_no").getValue());
		// if ( formMap.getField("defective") != null)
		// setDefective(formMap.getField("defective").getValue()); this is again
		// based on the section
		if (formMap.getField("notice_no") != null)
			setNoticeNo(formMap.getField("notice_no").getValue());
		if (formMap.getField("notice_date") != null) {
			String strDate = formMap.getField("notice_date").getValue();
			setNoticeDate(ConvDateStringToCalendar(strDate));
		}
		// Member PersonaInformation
		if (formMap.getField("pan") != null)
			setPAN(formMap.getField("pan").getValue());
		if (formMap.getField("Employe_category") != null)
			setEmploye_category(formMap.getField("Employe_category").getValue());
		if (formMap.getField("pi_first_name") != null)
			setFirstName(formMap.getField("pi_first_name").getValue());
		if (formMap.getField("pi_last_name") != null)
			setLastName(formMap.getField("pi_last_name").getValue());
		// if (formMap.getField("ReturnSection") != null) {
		// setReturnSection(formMap.getField("ReturnSection").getValue());
		setReturnSection(filingSection.getXmlCode());
		setReturnFileSection(Long.valueOf(filingSection.getXmlCode()));
		// }
		if (formMap.getField("pi_middle_name") != null)
			setMiddleName(formMap.getField("pi_middle_name").getValue());
		if (formMap.getField("pi_father_name") != null)
			setFatherName(formMap.getField("pi_father_name").getValue());
		if (formMap.getField("gender") != null)
			setSex(formMap.getField("gender").getValue());
		if (formMap.getField("pi_filing_status") != null)
			setFilingStatus(formMap.getField("pi_filing_status").getValue());
		if (formMap.getField("pi_dob") != null) {
			String strDate = formMap.getField("pi_dob").getValue();
			setDOB(ConvDateStringToCalendar(strDate));
		}
		// Member Contact Information
		if (formMap.getField("pi_email") != null)
			setEmail(formMap.getField("pi_email").getValue());
		if (formMap.getField("pi_road_street") != null)
			setRoadStreet(formMap.getField("pi_road_street").getValue());
		if (formMap.getField("pi_std_code") != null)
			setStdCode(formMap.getField("pi_std_code").getValue());
		if (formMap.getField("ward_circle") != null)
			setWard_circle(formMap.getField("ward_circle").getValue());
		if (formMap.getField("pi_phone") != null)
			setPhone(formMap.getField("pi_phone").getValue());
		if (formMap.getField("pi_flat_door_building") != null)
			setFlatDoorBuilding(formMap.getField("pi_flat_door_building")
					.getValue());
		if (formMap.getField("pi_premises_building") != null)
			setPremisesBuilding(formMap.getField("pi_premises_building")
					.getValue());
		if (formMap.getField("pi_area_locality") != null)
			setAreaLocality(formMap.getField("pi_area_locality").getValue());
		if (formMap.getField("pi_town_city_district") != null)
			setTownCityDistrict(formMap.getField("pi_town_city_district")
					.getValue());
		if (formMap.getField("pi_country") != null)
			setCountry(formMap.getField("pi_country").getValue());
		// for if user is having a representative in itr2
		if (formMap.getField("isRepresentative") != null)
			setIsRepresentative(formMap.getField("isRepresentative").getValue());
		if (formMap.getField("name_Representative") != null)
			setName_Representative(formMap.getField("name_Representative")
					.getValue());
		if (formMap.getField("address_Representative") != null)
			setAddress_Representative(formMap
					.getField("address_Representative").getValue());
		if (formMap.getField("pan_Representative") != null)
			setPan_Representative(formMap.getField("pan_Representative")
					.getValue());
		// for itr4
		if (formMap.getField("isLiable_ManageAcc") != null)
			setIsLiable_ManageAcc(formMap.getField("isLiable_ManageAcc")
					.getValue());
		if (formMap.getField("isLiable_ForAudit") != null)
			setIsLiable_ForAudit(formMap.getField("isLiable_ForAudit")
					.getValue());

		if (formMap.getField("name_AuditorSign_Report") != null)
			setName_AuditorSign_Report(formMap.getField(
					"name_AuditorSign_Report").getValue());
		if (formMap.getField("membershipNo_auditor") != null)
			setMembershipNo_auditor(formMap.getField("membershipNo_auditor")
					.getValue());
		if (formMap.getField("name_auditorFirm") != null)
			setName_auditorFirm(formMap.getField("name_auditorFirm").getValue());
		if (formMap.getField("pan_Firm") != null)
			setPan_Firm(formMap.getField("pan_Firm").getValue());

		if (formMap.getField("date_FurnishAuditReport") != null) {
			String strdate_FurnishAuditReport = formMap.getField(
					"date_FurnishAuditReport").getValue();
			setDate_FurnishAuditReport(ConvDateStringToCalendar(strdate_FurnishAuditReport));
		}
		if (formMap.getField("date_AuditReport") != null) {
			String strdate_AuditReport = formMap.getField("date_AuditReport")
					.getValue();
			setDate_AuditReport(ConvDateStringToCalendar(strdate_AuditReport));
		}
		if (formMap.getField("isLiable_FurnishSec92E") != null)
			setIsLiable_FurnishSec92E(formMap
					.getField("isLiable_FurnishSec92E").getValue());
		if (formMap.getField("pan_Representative") != null)
			setPan_Representative(formMap.getField("pan_Representative")
					.getValue());

		if (formMap.getField("pi_state") != null) {
			setState(formMap.getField("pi_state").getValue());
			if (formMap.getField("pi_pin_code") != null) {
				if (formMap.getField("pi_state").getValue().matches("99")) {
					setPinCode("999999");
				} else {
					setPinCode(formMap.getField("pi_pin_code").getValue());
				}
			}
		}
		if (formMap.getField("pi_mobile") != null)
			setMobile(formMap.getField("pi_mobile").getValue());
		if (formMap.getField("pi_mobile1") != null)
			setMobile1(formMap.getField("pi_mobile1").getValue());
		// Bank Details
		if (formMap.getField("bd_bank_name") != null)
			setBD_BANK_NAME(formMap.getField("bd_bank_name").getValue());
		if (formMap.getField("bd_micr_code") != null)
			setBD_MICR_CODE(formMap.getField("bd_micr_code").getValue());
		if (formMap.getField("bd_Branch_name") != null)
			setBD_ADD_BANK_BRANCH(formMap.getField("bd_Branch_name").getValue());
		if (formMap.getField("bd_account_type") != null)
			setBD_TYPE_ACC(formMap.getField("bd_account_type").getValue());
		if (formMap.getField("bd_account_no") != null)
			setBD_ACC_NUMBER(formMap.getField("bd_account_no").getValue());
		if (formMap.getField("bd_ecs") != null)
			setBD_ECS(formMap.getField("bd_ecs").getValue());
		// for itr4s
		if (formMap.getField("trpnumber") != null)
			setTrpnumber(formMap.getField("trpnumber").getValue());
		if (formMap.getField("trpname") != null)
			setTrpname(formMap.getField("trpname").getValue());
		if (formMap.getField("isTaxPreparebyTRP") != null)
			setIsTaxPreparebyTRP(formMap.getField("isTaxPreparebyTRP")
					.getValue());
		if (formMap.getField("trpreimbursement") != null) {
			String trpreimbursement = formMap.getField("trpreimbursement")
					.getValue();
			double trpamount = 0.0d;
			if (StringUtils.isNotBlank(trpreimbursement)) {
				trpamount = Double.parseDouble(trpreimbursement);
			}
			setTrpreimbursement(trpamount);
		}
		// Residential Status
		if (formMap.getField("rsstatus_q") != null) {
			setRsstatusQ(formMap.getField("rsstatus_q").getValue());
			choice = choice + formMap.getField("rsstatus_q").getValue();
		}
		if (formMap.getField("rsstatus_q_yes") != null) {
			setRsstatusQYes(formMap.getField("rsstatus_q_yes").getValue());
			if (!(formMap.getField("rsstatus_q_yes").getValue()
					.matches("Select"))) {
				choice = choice + "_"
						+ formMap.getField("rsstatus_q_yes").getValue();
			}
		}
		if (formMap.getField("rsstatus_q_yes_yes") != null) {
			setRsstatusQYesYes(formMap.getField("rsstatus_q_yes_yes")
					.getValue());
			if (!(formMap.getField("rsstatus_q_yes_yes").getValue()
					.matches("Select"))) {
				choice = choice + "_"
						+ formMap.getField("rsstatus_q_yes_yes").getValue();
			}
		}
		if (formMap.getField("rsstatus_q_no") != null) {
			setRsstatusQNo(formMap.getField("rsstatus_q_no").getValue());
			if (!(formMap.getField("rsstatus_q_no").getValue()
					.matches("Select"))) {
				choice = choice + "_"
						+ formMap.getField("rsstatus_q_no").getValue();
			}
		}
		if (formMap.getField("rsstatus_q_no_yes") != null) {
			setRsstatusQNoYes(formMap.getField("rsstatus_q_no_yes").getValue());
			if (!(formMap.getField("rsstatus_q_no_yes").getValue()
					.matches("Select"))) {
				choice = choice + "_"
						+ formMap.getField("rsstatus_q_no_yes").getValue();
			}
		}
		if (formMap.getField("rsstatus_q_no_yes_yes") != null) {
			setRsstatusQNoYesYes(formMap.getField("rsstatus_q_no_yes_yes")
					.getValue());
			if (!(formMap.getField("rsstatus_q_no_yes_yes").getValue()
					.matches("Select"))) {
				choice = choice + "_"
						+ formMap.getField("rsstatus_q_no_yes_yes").getValue();
			}
		}
		if (formMap.getField("rsstatus_q_no_no") != null) {
			setRsstatusQNoNo(formMap.getField("rsstatus_q_no_no").getValue());
			if (!(formMap.getField("rsstatus_q_no_no").getValue()
					.matches("Select"))) {
				choice = choice + "_"
						+ formMap.getField("rsstatus_q_no_no").getValue();
			}
		}
		if (formMap.getField("rsstatus_q_no_no_yes") != null) {
			setRsstatusQNoNoYes(formMap.getField("rsstatus_q_no_no_yes")
					.getValue());
			if (!(formMap.getField("rsstatus_q_no_no_yes").getValue()
					.matches("Select"))) {
				choice = choice + "_"
						+ formMap.getField("rsstatus_q_no_no_yes").getValue();
			}
		}
		if (formMap.getField("rsstatus_q_no_no_yes_yes") != null) {
			setRsstatusQNoNoYesYes(formMap.getField("rsstatus_q_no_no_yes_yes")
					.getValue());
			if (!(formMap.getField("rsstatus_q_no_no_yes_yes").getValue()
					.matches("Select"))) {
				choice = choice
						+ "_"
						+ formMap.getField("rsstatus_q_no_no_yes_yes")
								.getValue();
			}
		}
		if (formMap.getField("rsstatus_q_no_yes_yes_yes") != null) {
			setRsstatusQNoYesYesYes(formMap.getField(
					"rsstatus_q_no_yes_yes_yes").getValue());
			if (!(formMap.getField("rsstatus_q_no_yes_yes_yes").getValue()
					.matches("Select"))) {
				choice = choice
						+ "_"
						+ formMap.getField("rsstatus_q_no_yes_yes_yes")
								.getValue();
			}
		}

		String modchoice = "rsstatus_q_" + choice.trim();
		// In case of HUF we are not asking question to member so if
		// "rsstatus_q" has a value that have residential status then we will
		// set Residential Status
		// new case for huf, abhi 14/09/2013
		if (formMap.getField("fy") != null) {
			// If financial Year value will be null then we will not be able to
			// fetch the resource bundle
			if (getFilingStatus().equals("H")) {
				ResourceBundle rbNew = null;
				try {
					rbNew = ResourceBundle.getBundle(rbfilenameNew);
				} catch (MissingResourceException e) {
					log.warn("Error Resource is not Available ", e);
				}
				if (rbNew != null) {
					for (String bKey : rbNew.keySet()) {
						if (bKey.matches(modchoice.trim().substring(0,
								modchoice.length() - 1))) {
							if (log.isInfoEnabled()) {
								log.info("this is residential status new for huf"
										+ rbNew.getString(bKey)
												.replaceFirst("ans_", "")
												.trim());
							}
							setResidentCategory(ResidentialFind(rbNew
									.getString(bKey)));
							break;
						}
					}
				}
			} else {
				ResourceBundle rb = null;
				try {
					rb = ResourceBundle.getBundle(rbfilename);
				} catch (MissingResourceException e) {
					log.warn("Error Resource is not Available ", e);
				}
				if (rb != null) {
					for (String aKey : rb.keySet()) {
						if (aKey.matches(modchoice.trim())) {
							if (log.isInfoEnabled()) {
								log.info("this is residential status"
										+ rb.getString(aKey)
												.replaceFirst("ans_", "")
												.trim());
							}
							setResidentCategory(ResidentialFind(rb
									.getString(aKey)));
							break;
						}
					}
				}
			}
		}
		// DIT VErification
		if (formMap.getField("ditVerificationStatus") != null) {
			String ditVerificationStatusStr = formMap.getField(
					"ditVerificationStatus").getValue();
			try {
				setDitVerificationStatus(VerificationStatus
						.valueOf(ditVerificationStatusStr));
			} catch (IllegalArgumentException e) {

			}
		}

		if (formMap.getField("ditVerificationMessage") != null) {
			String ditVerificationMessageStr = formMap.getField(
					"ditVerificationMessage").getValue();
			try {
				setDitVerificationMessage(ditVerificationMessageStr);
			} catch (IllegalArgumentException e) {

			}
		}

		if (formMap.getField("ditSubmissionStatus") != null) {
			String ditSubmissionStatusStr = formMap.getField(
					"ditSubmissionStatus").getValue();
			try {
				setDitSubmissionStatus(DITSubmissionStatus
						.valueOf(ditSubmissionStatusStr));
			} catch (IllegalArgumentException e) {

			}
		}

		if (formMap.getField("ditSubmissionToken") != null) {
			String ditSubmissionToken = formMap.getField("ditSubmissionToken")
					.getValue();
			setDitSubmissionToken(ditSubmissionToken);
		}

		/*
		 * if(StringUtils.isBlank(getResidentCategory())){ for(ResidentStatus
		 * resiStat:ResidentStatus.values()){
		 * if(resiStat.name().equalsIgnoreCase(getRsstatusQ())){
		 * setResidentCategory(resiStat.name()); } } }
		 */
		if (formMap.getField("digitalSignatureHandleUUID") != null) {
			log.info("Lets see digital Signature Handle UUID::"
					+ formMap.getField("digitalSignatureHandleUUID").getValue());
			setDigitalSignatureHandleUUID(formMap.getField(
					"digitalSignatureHandleUUID").getValue());
		}
		if (formMap.getField("sourceIncPackSelectKey") != null) {
			setSourceIncPackSelectKey(formMap
					.getField("sourceIncPackSelectKey").getValue());
		}
		if (formMap.getField("sourceIncPackSelect") != null) {
			setSourceIncPackSelect(Boolean.valueOf(formMap.getField(
					"sourceIncPackSelect").getValue()));
		}
	}

	private String ResidentialFind(String key) {
		if (key.matches("ans_Resident and Ordinarily Resident"))
			return "RES";
		if (key.matches("ans_Resident but Not Ordinarily Resident"))
			return "NOR";
		if (key.matches("ans_Non Resident"))
			return "NRI";
		else
			return null;
	}

	/**
	 * This method will check if the service has been paid in full
	 * 
	 * @return
	 */
	public boolean isPaidInFull() {
		return true;
	}

	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub

	}

	// for itr4s
	public String getTrpnumber() {
		if (trpnumber == null)
			trpnumber = getProperty("mootlywcm:trpnumber");
		return trpnumber;
	}

	public final void setTrpnumber(String trpnumber) {
		this.trpnumber = trpnumber;
	}

	public String getTrpname() {
		if (trpname == null)
			trpname = getProperty("mootlywcm:trpname");
		return trpname;
	}

	public final void setTrpname(String trpname) {
		this.trpname = trpname;
	}

	public String getIsTaxPreparebyTRP() {
		if (isTaxPreparebyTRP == null)
			isTaxPreparebyTRP = getProperty("mootlywcm:isTaxPreparebyTRP");
		return isTaxPreparebyTRP;
	}

	public final void setIsTaxPreparebyTRP(String isTaxPreparebyTRP) {
		this.isTaxPreparebyTRP = isTaxPreparebyTRP;
	}

	public Double getTrpreimbursement() {
		if (trpreimbursement == null)
			trpreimbursement = getProperty("mootlywcm:trpreimbursement");
		return trpreimbursement;
	}

	public final void setTrpreimbursement(Double trpreimbursement) {
		this.trpreimbursement = trpreimbursement;
	}

	public MemberDriveDocument getDigitalSignature() {
		MemberDriveDocument driveDocumentDS = null;
		HippoBean hippoBeanDS = getBean("mootlywcm:pathToDigitalSignature");
		if (hippoBeanDS instanceof HippoMirror) {
			HippoMirror hippoMirrorDS = (HippoMirror) hippoBeanDS;
			if (hippoMirrorDS != null) {
				if (hippoMirrorDS.getReferencedBean() instanceof MemberDriveDocument) {
					driveDocumentDS = (MemberDriveDocument) hippoMirrorDS
							.getReferencedBean();
				}
			}
		}
		return driveDocumentDS;
	}

	public String getDigitalSignaturePath() {
		if (getDigitalSignature() != null) {
			return getDigitalSignature().getCanonicalPath();
		} else {
			return null;
		}
	}

	public String getDigitalSignatureHandleUUID() {
		if (digitalSignatureHandleUUID == null) {
			if (getDigitalSignature() != null) {
				digitalSignatureHandleUUID = getDigitalSignature()
						.getCanonicalHandleUUID();
			}
		}
		return digitalSignatureHandleUUID;
	}

	public void setDigitalSignatureHandleUUID(String digitalSignatureHandleUUID) {
		this.digitalSignatureHandleUUID = digitalSignatureHandleUUID;
	}

	public Boolean getSourceIncPackSelect() {
		if (sourceIncPackSelect == null)
			sourceIncPackSelect = getProperty("mootlywcm:sourceIncPackSelect");
		return sourceIncPackSelect;
	}

	public void setSourceIncPackSelect(Boolean sourceIncPackSelect) {
		this.sourceIncPackSelect = sourceIncPackSelect;
	}

	public String getSourceIncPackSelectKey() {
		if (sourceIncPackSelectKey == null)
			sourceIncPackSelectKey = getProperty("mootlywcm:sourceIncPackSelectKey");
		return sourceIncPackSelectKey;
	}

	public void setSourceIncPackSelectKey(String sourceIncPackSelectKey) {
		this.sourceIncPackSelectKey = sourceIncPackSelectKey;
	}

	// this method will convert membership no of auditor to 6 always
	private static String ModifyMembershipNo_Auditor(String memberShipNo) {
		int length = memberShipNo.length();
		char charArray[] = memberShipNo.toCharArray();
		StringBuffer bf = new StringBuffer();

		for (int i = 0; i < 6 - length; i++) {
			StringBuffer bfZero = new StringBuffer("0");
			bf = bfZero.append(memberShipNo);
			memberShipNo = bf.toString();

		}

		return bf.toString();
	}
}
