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
import static com.mootly.wcm.utils.Constants.PROP_PI_DEFECTIVE;
import static com.mootly.wcm.utils.Constants.PROP_PI_DOB;
import static com.mootly.wcm.utils.Constants.PROP_PI_EMAIL;
import static com.mootly.wcm.utils.Constants.PROP_PI_FATHER_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_FILING_STATUS;
import static com.mootly.wcm.utils.Constants.PROP_PI_FINANCIAL_YEAR;
import static com.mootly.wcm.utils.Constants.PROP_PI_FIRST_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_FLAT_FLOOR_BUILDING;
import static com.mootly.wcm.utils.Constants.PROP_PI_LAST_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_MIDDLE_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_MOBILE;
import static com.mootly.wcm.utils.Constants.PROP_PI_MOBILE1;
import static com.mootly.wcm.utils.Constants.PROP_PI_WARD_CIRCLE;
import static com.mootly.wcm.utils.Constants.PROP_PI_NOTICE_DATE;
import static com.mootly.wcm.utils.Constants.PROP_PI_NOTICE_NO;
import static com.mootly.wcm.utils.Constants.PROP_PI_ORIGINAL_ACK_DATE;
import static com.mootly.wcm.utils.Constants.PROP_PI_ORIGINAL_ACK_NO;
import static com.mootly.wcm.utils.Constants.PROP_PI_PAN;
import static com.mootly.wcm.utils.Constants.PROP_PI_PHONE;
import static com.mootly.wcm.utils.Constants.PROP_PI_PINCODE;
import static com.mootly.wcm.utils.Constants.PROP_PI_PREMISES_BUILDING;
import static com.mootly.wcm.utils.Constants.PROP_PI_RESIDENT_CATEGORY;
import static com.mootly.wcm.utils.Constants.PROP_PI_RETURN_TYPE;
import static com.mootly.wcm.utils.Constants.PROP_PI_ROAD_STREET;
import static com.mootly.wcm.utils.Constants.PROP_PI_EMPLOYER_CATEGORY;
import static com.mootly.wcm.utils.Constants.PROP_PI_RECEIPT_NO;
import static com.mootly.wcm.utils.Constants.PROP_PI_INCOME_TAX_WARD;
import static com.mootly.wcm.utils.Constants.PROP_PI_RETURN_FILE_SECTION;
import static com.mootly.wcm.utils.Constants.PROP_PI_SEX;
import static com.mootly.wcm.utils.Constants.PROP_PI_STATE;
import static com.mootly.wcm.utils.Constants.PROP_PI_STD_CODE;
import static com.mootly.wcm.utils.Constants.PROP_PI_TOWN_CITY_DISTRICT;
import static com.mootly.wcm.utils.Constants.Rsstatus_q;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_no;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_no_no;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_no_no_yes;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_no_no_yes_yes;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_no_yes;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_no_yes_yes;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_no_yes_yes_yes;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_yes;
import static com.mootly.wcm.utils.Constants.PROP_PI_TAX_STATUS;
import static com.mootly.wcm.utils.Constants.Rsstatus_q_yes_yes;

import java.math.BigInteger;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import javax.jcr.RepositoryException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;

/**
 * User: vivek
 * Date: Jun 29, 2010
 * Time: 11:26:35 AM
 */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:MemberPersonalInformation")
public class MemberPersonalInformation extends BaseDocument implements ContentNodeBinder,FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:MemberPersonalInformation";
	static final public String NODE_NAME = "PersonalInformation";

	private String employerCategory;
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
	private String ward_circle;
	private String pinCode;
	private String email;
	private String mobile;
	private String mobile1;
	private String stdCode;
	private String phone;
	private String Employe_category;

	private String accNumber ;
	private String bankName ;
	private String ecs ;
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


	public String getTaxStatus() {
		if (taxStatus == null) taxStatus = getProperty(PROP_PI_TAX_STATUS);
		return taxStatus;
	}
	public String getEmployerCategory() {
		if (employerCategory == null) employerCategory = getProperty(PROP_PI_EMPLOYER_CATEGORY);
		return employerCategory;
	}
	public String getReceiptNo() {
		if (receiptNo == null) receiptNo = getProperty(PROP_PI_RECEIPT_NO);
		return receiptNo;
	}
	public long getReturnFileSection() {
		if (returnFileSection == null) returnFileSection = getProperty(PROP_PI_RETURN_FILE_SECTION);
		return returnFileSection;
	}
	public String getIncomeTaxWard() {
		if (incomeTaxWard == null) incomeTaxWard = getProperty(PROP_PI_INCOME_TAX_WARD);
		return incomeTaxWard;
	}
	public String getFinancialYear() {
		if (finacialYear == null) finacialYear = getProperty(PROP_PI_FINANCIAL_YEAR);
		return finacialYear;
	}
	public String getReturnType() {
		if (returnType == null) returnType = getProperty(PROP_PI_RETURN_TYPE);
		return returnType;
	}
	public String getOriginalAckNo() {
		if (originalAckNo == null) originalAckNo = getProperty(PROP_PI_ORIGINAL_ACK_NO);
		return originalAckNo;
	}
	public GregorianCalendar getOriginalAckDate() {
		if (originalAckDate == null) originalAckDate = getProperty(PROP_PI_ORIGINAL_ACK_DATE);
		return originalAckDate;
	}

	public String getAckDateStr() {
		if (originalAckDate == null) originalAckDate = getProperty(PROP_PI_ORIGINAL_ACK_DATE);
		if (originalAckDate != null) {
			String ackdateStr = getIndianDateFormatter().format(originalAckDate.getTime());
			return ackdateStr;
		}
		return null;
	}
	public String getDefective() {
		if (defective == null) defective = getProperty(PROP_PI_DEFECTIVE);
		return defective;
	}
	public String getNoticeNo() {
		if (noticeNo == null) noticeNo = getProperty(PROP_PI_NOTICE_NO);
		return noticeNo;
	}
	public GregorianCalendar getNoticeDate() {
		if (noticeDate == null) noticeDate = getProperty(PROP_PI_NOTICE_DATE);
		return noticeDate;
	}
	public String getNoticeDateStr() {
		if (noticeDate == null) noticeDate = getProperty(PROP_PI_NOTICE_DATE);
		if (noticeDate != null) {
			String noticeStr = getIndianDateFormatter().format(noticeDate.getTime());
			return noticeStr;
		}
		return null;
	}

	//This is just a calculated field
	public String getName() {
		StringBuffer sb = new StringBuffer();
		if (getFirstName() != null) sb.append(firstName).append(" ");
		if (getLastName() != null) sb.append(lastName);
		return sb.toString();
	}
	//for personal information
	public String getFirstName() {
		if (firstName == null) firstName = getProperty(PROP_PI_FIRST_NAME);
		return firstName;
	}
	public String getMiddleName() {
		if (middleName == null) middleName = getProperty(PROP_PI_MIDDLE_NAME);
		return middleName;
	}

	public String getLastName() {
		if (lastName == null) lastName = getProperty(PROP_PI_LAST_NAME);
		return lastName;
	}

	public String getFatherName() {
		if (fatherName == null) fatherName = getProperty(PROP_PI_FATHER_NAME);
		return fatherName;
	}
	public String getEmploye_category() {
		if (Employe_category == null) Employe_category = getProperty(PROP_PI_EMPLOYER_CATEGORY);
		return Employe_category;
	}

	public String getPAN() {
		if (PAN == null) PAN = getProperty(PROP_PI_PAN);
		return PAN;
	}

	public String getFilingStatus() {
		if (filingStatus == null) filingStatus = getProperty(PROP_PI_FILING_STATUS);
		return filingStatus;
	}

	public GregorianCalendar getDOB() {
		if (DOB == null) DOB = getProperty(PROP_PI_DOB);
		return DOB;
	}

	public String getDOBStr() {
		if (DOB == null) DOB = getProperty(PROP_PI_DOB);
		if (DOB != null) {
			String dobStr = getIndianDateFormatter().format(DOB.getTime());
			return dobStr;
		}
		return null;
	}

	public String getSex() {
		if (sex == null) sex = getProperty(PROP_PI_SEX);
		return sex;
	}
	public String getFlatDoorBuilding() {
		if (flatDoorBuilding == null) flatDoorBuilding = getProperty(PROP_PI_FLAT_FLOOR_BUILDING);
		return flatDoorBuilding;
	}
	public String getPremisesBuilding() {
		if (premisesBuilding == null) premisesBuilding = getProperty(PROP_PI_PREMISES_BUILDING);
		return premisesBuilding;
	}

	public String getRoadStreet() {
		if (roadStreet == null) roadStreet = getProperty(PROP_PI_ROAD_STREET);
		return roadStreet;
	}

	public String getAreaLocality() {
		if (areaLocality == null) areaLocality = getProperty(PROP_PI_AREA_LOCALITY);
		return areaLocality;
	}

	public String getTownCityDistrict() {
		if (townCityDistrict == null) townCityDistrict = getProperty(PROP_PI_TOWN_CITY_DISTRICT);
		return townCityDistrict;
	}

	public String getState() {
		if (state == null) state = getProperty(PROP_PI_STATE);
		return state;
	}

	public String getPinCode() {
		if (pinCode == null) pinCode = getProperty(PROP_PI_PINCODE);
		return pinCode;
	}

	public String getEmail() {
		if (email == null) email =  getProperty(PROP_PI_EMAIL);
		return email;
	}

	public String getMobile() {
		if (mobile == null) mobile =  getProperty(PROP_PI_MOBILE);
		return mobile;
	}
	public String getMobile1() {
		if (mobile1 == null) mobile1 =  getProperty(PROP_PI_MOBILE1);
		return mobile1;
	}

	public String getStdCode() {
		if (stdCode == null) stdCode = getProperty(PROP_PI_STD_CODE);
		return stdCode;
	}
	public String getWard_circle() {
		if (ward_circle == null) ward_circle = getProperty(PROP_PI_WARD_CIRCLE);
		return ward_circle;
	}

	public String getPhone() {
		if (phone == null) phone = getProperty(PROP_PI_PHONE);
		return phone;
	}

	public String getPersonalInfoUuid() {
		return PIUUID;
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
	//Member Contact Information
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
	public Boolean getBankDetailStatus(){
		if (bankDetailStatus == null) bankDetailStatus = getProperty(BD_STATUS);
		return bankDetailStatus;
	}
	public String getBD_ADD_BANK_BRANCH() {
		if (addBankBranch == null) addBankBranch = getProperty(BD_ADD_BANK_BRANCH);
		return addBankBranch;
	}
	public String getBD_MICR_CODE() {
		if (micrCode == null) micrCode = getProperty(BD_MICR_CODE);
		return micrCode;
	}
	public String getBD_ACC_NUMBER() {
		if (accNumber == null) accNumber = getProperty(BD_ACC_NUMBER);
		return accNumber;
	}
	public String getBD_BANK_NAME() {
		if (bankName == null) bankName = getProperty(BD_BANK_NAME);
		return bankName;
	}
	public String getBD_ECS() {
		if (ecs == null) ecs = getProperty(BD_ECS);
		return ecs;
	}
	public String getBD_TYPE_ACC() {
		if (typeAcc == null) typeAcc = getProperty(BD_TYPE_ACC);
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
		if (rsstatus_q == null) rsstatus_q = getProperty(Rsstatus_q);
		return rsstatus_q;
	}
	public String getRsstatusQNoNoYes() {
		if (rsstatus_q_no_no_yes == null) rsstatus_q_no_no_yes = getProperty(Rsstatus_q_no_no_yes);
		return rsstatus_q_no_no_yes;
	}
	public String getRsstatusQNoNoYesYes() {
		if (rsstatus_q_no_no_yes_yes == null) rsstatus_q_no_no_yes_yes = getProperty(Rsstatus_q_no_no_yes_yes);
		return rsstatus_q_no_no_yes_yes;
	}
	public String getRsstatusQNoYesYesYes() {
		if (rsstatus_q_no_yes_yes_yes == null) rsstatus_q_no_yes_yes_yes = getProperty(Rsstatus_q_no_yes_yes_yes);
		return rsstatus_q_no_yes_yes_yes;
	}
	public String getRsstatusQYes() {
		if (rsstatus_q_yes == null) rsstatus_q_yes = getProperty(Rsstatus_q_yes);
		return rsstatus_q_yes;
	}
	public String getRsstatusQYesYes() {
		if (rsstatus_q_yes_yes == null) rsstatus_q_yes_yes = getProperty(Rsstatus_q_yes_yes);
		return rsstatus_q_yes_yes;
	}

	public String getRsstatusQNo() {
		if (rsstatus_q_no == null) rsstatus_q_no = getProperty(Rsstatus_q_no);
		return rsstatus_q_no;
	}

	public String getRsstatusQNoYes() {
		if (rsstatus_q_no_yes == null) rsstatus_q_no_yes = getProperty(Rsstatus_q_no_yes);
		return rsstatus_q_no_yes;
	}

	public String getRsstatusQNoYesYes() {
		if (rsstatus_q_no_yes_yes == null) rsstatus_q_no_yes_yes =  getProperty(Rsstatus_q_no_yes_yes);
		return rsstatus_q_no_yes_yes;
	}

	public String getRsstatusQNoNo() {
		if (rsstatus_q_no_no == null) rsstatus_q_no_no = getProperty(Rsstatus_q_no_no);
		return rsstatus_q_no_no;
	}

	public String getResidentCategory() {
		if (residentCategory == null) residentCategory = getProperty(PROP_PI_RESIDENT_CATEGORY);
		return residentCategory;
	}

	public final void setRsstatusQ(String rsstatus_q) {
		this.rsstatus_q = rsstatus_q;
	}

	public final void setRsstatusQNoNoYes(String rsstatus_q_no_no_yes) {
		this.rsstatus_q_no_no_yes=rsstatus_q_no_no_yes;
	}

	public final void setRsstatusQNoNoYesYes(String rsstatus_q_no_no_yes_yes) {
		this.rsstatus_q_no_no_yes_yes=rsstatus_q_no_no_yes_yes;
	}

	public final void setRsstatusQNoYesYesYes(String rsstatus_q_no_yes_yes_yes) {
		this.rsstatus_q_no_yes_yes_yes=rsstatus_q_no_yes_yes_yes;
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

	//for personal information


	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			if(log.isInfoEnabled()){
				log.warn("this is bean");
			}
			MemberPersonalInformation mpi = (MemberPersonalInformation) content;

			node.setProperty(PROP_PI_FINANCIAL_YEAR,mpi.getFinancialYear());
			node.setProperty(PROP_PI_RETURN_TYPE,mpi.getReturnType());
			node.setProperty(PROP_PI_ORIGINAL_ACK_DATE,mpi.getOriginalAckDate());
			node.setProperty(PROP_PI_ORIGINAL_ACK_NO,mpi.getOriginalAckNo());
			node.setProperty(PROP_PI_NOTICE_DATE,mpi.getNoticeDate());
			node.setProperty(PROP_PI_NOTICE_NO,mpi.getNoticeNo());
			node.setProperty(PROP_PI_DEFECTIVE,mpi.getDefective());
			node.setProperty(PROP_PI_RECEIPT_NO,mpi.getReceiptNo());
			node.setProperty(PROP_PI_INCOME_TAX_WARD,mpi.getIncomeTaxWard());
			node.setProperty(PROP_PI_RETURN_FILE_SECTION,mpi.getReturnFileSection());
			//node.setProperty(PROP_PI_EMPLOYER_CATEGORY,mpi.getEmployerCategory());
			node.setProperty(PROP_PI_TAX_STATUS,mpi.getTaxStatus());
			node.setProperty(PROP_PI_EMPLOYER_CATEGORY,mpi.getEmploye_category());
			node.setProperty(PROP_PI_FIRST_NAME,mpi.getFirstName());
			node.setProperty(PROP_PI_MIDDLE_NAME,mpi.getMiddleName());
			node.setProperty(PROP_PI_LAST_NAME, mpi.getLastName());
			node.setProperty(PROP_PI_FATHER_NAME, mpi.getFatherName());
			node.setProperty(PROP_PI_PAN, mpi.getPAN());
			node.setProperty(PROP_PI_FILING_STATUS, mpi.getFilingStatus());
			node.setProperty(PROP_PI_DOB, mpi.getDOB());
			node.setProperty(PROP_PI_SEX, mpi.getSex());

			node.setProperty(PROP_PI_FLAT_FLOOR_BUILDING, mpi.getFlatDoorBuilding());
			node.setProperty(PROP_PI_PREMISES_BUILDING, mpi.getPremisesBuilding());
			node.setProperty(PROP_PI_ROAD_STREET, mpi.getRoadStreet());
			node.setProperty(PROP_PI_AREA_LOCALITY, mpi.getAreaLocality());
			node.setProperty(PROP_PI_TOWN_CITY_DISTRICT, mpi.getTownCityDistrict());
			node.setProperty(PROP_PI_STATE, mpi.getState());
			node.setProperty(PROP_PI_PINCODE, mpi.getPinCode());
			node.setProperty(PROP_PI_EMAIL, mpi.getEmail());
			node.setProperty(PROP_PI_MOBILE, mpi.getMobile());
			node.setProperty(PROP_PI_MOBILE1, mpi.getMobile1());
			node.setProperty(PROP_PI_WARD_CIRCLE, mpi.getWard_circle());
			node.setProperty(PROP_PI_STD_CODE, mpi.getStdCode());
			node.setProperty(PROP_PI_PHONE, mpi.getPhone());

			node.setProperty(BD_ACC_NUMBER,mpi.getBD_ACC_NUMBER());
			node.setProperty(BD_BANK_NAME,mpi.getBD_BANK_NAME());
			node.setProperty(BD_ECS,mpi.getBD_ECS());
			node.setProperty(BD_TYPE_ACC,mpi.getBD_TYPE_ACC());
			node.setProperty(BD_ADD_BANK_BRANCH,mpi.getBD_ADD_BANK_BRANCH());
			node.setProperty(BD_MICR_CODE,mpi.getBD_MICR_CODE());
			if(mpi.getBD_ACC_NUMBER().trim().length()!=0&&mpi.getBD_BANK_NAME().trim().length()!=0
					&&mpi.getBD_ECS().trim().length()!=0&&mpi.getBD_TYPE_ACC().trim().length()!=0
					&&mpi.getBD_ADD_BANK_BRANCH().trim().length()!=0&&mpi.getBD_MICR_CODE().trim().length()!=0){
				node.setProperty(BD_STATUS,true);
			}else{
				node.setProperty(BD_STATUS,false);
			}

			node.setProperty(Rsstatus_q, mpi.getRsstatusQ());
			node.setProperty(Rsstatus_q_yes, mpi.getRsstatusQYes());
			node.setProperty(Rsstatus_q_yes_yes, mpi.getRsstatusQYesYes());
			node.setProperty(Rsstatus_q_no, mpi.getRsstatusQNo());
			node.setProperty(Rsstatus_q_no_yes, mpi.getRsstatusQNoYes());
			node.setProperty(Rsstatus_q_no_yes_yes, mpi.getRsstatusQNoYesYes());
			node.setProperty(Rsstatus_q_no_no, mpi.getRsstatusQNoNo());
			node.setProperty(Rsstatus_q_no_no_yes, mpi.getRsstatusQNoNoYes());
			node.setProperty(Rsstatus_q_no_no_yes_yes, mpi.getRsstatusQNoNoYesYes());
			node.setProperty(Rsstatus_q_no_yes_yes_yes, mpi.getRsstatusQNoYesYesYes());
			node.setProperty(PROP_PI_RESIDENT_CATEGORY, mpi.getResidentCategory());
		}catch (RepositoryException re) {
			log.error("Binding Node Error",re);

		}
		return true;
	}

	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");
		}
		if (formMap == null) return;
		if ( formMap.getField("tax_status") != null) setTaxStatus(formMap.getField("tax_status").getValue());
		if ( formMap.getField("return_section") != null) setReturnFileSection(Long.parseLong(formMap.getField("return_section").getValue()));
		if ( formMap.getField("emp_category") != null) setEmployerCategory(formMap.getField("emp_category").getValue());
		if ( formMap.getField("receipt_no") != null) setReceiptNo(formMap.getField("receipt_no").getValue());
		if ( formMap.getField("tax_ward") != null) setIncomeTaxWard(formMap.getField("tax_ward").getValue());

		if ( formMap.getField("pi_return_type") != null) setReturnType(formMap.getField("pi_return_type").getValue());
		if ( formMap.getField("fy") != null) setFinancialYear(formMap.getField("fy").getValue());
		if ( formMap.getField("ack_date") != null){
			String strDate = formMap.getField("ack_date").getValue();
			Date date = null ;
			DateFormat formatter ;
			formatter = getIndianDateFormatter();
			GregorianCalendar cal=(GregorianCalendar) GregorianCalendar.getInstance();
			try{
				date = (Date)formatter.parse(strDate);
				if(log.isInfoEnabled()){
					log.info("date"+date);
				}
				cal.setTime(date);
				setOriginalAckDate(cal);
			}
			catch(Exception e){
				log.info("calendar error"+e);
			}
		}
		if ( formMap.getField("ack_no") != null) setOriginalAckNo(formMap.getField("ack_no").getValue());
		if ( formMap.getField("defective") != null) setDefective(formMap.getField("defective").getValue());
		if ( formMap.getField("notice_no") != null) setNoticeNo(formMap.getField("notice_no").getValue());
		if ( formMap.getField("notice_date") != null){
			String strDate = formMap.getField("notice_date").getValue();
			Date date = null ;
			DateFormat formatter ;
			formatter = getIndianDateFormatter();
			GregorianCalendar cal=(GregorianCalendar) GregorianCalendar.getInstance();
			try{
				date = (Date)formatter.parse(strDate);
				if(log.isInfoEnabled()){
					log.info("date"+date);
				}
				cal.setTime(date);
				setNoticeDate(cal);
			}
			catch(Exception e){
				log.info("calendar error"+e);
			}
		}
		//Member PersonaInformation
		if ( formMap.getField("pan") != null) setPAN(formMap.getField("pan").getValue());
		if ( formMap.getField("Employe_category") != null) setEmploye_category(formMap.getField("Employe_category").getValue());
		if ( formMap.getField("pi_first_name") != null) setFirstName(formMap.getField("pi_first_name").getValue());
		if ( formMap.getField("pi_last_name") != null) setLastName(formMap.getField("pi_last_name").getValue());
		if ( formMap.getField("pi_middle_name") != null) setMiddleName(formMap.getField("pi_middle_name").getValue());
		if ( formMap.getField("pi_father_name") != null) setFatherName(formMap.getField("pi_father_name").getValue());
		if ( formMap.getField("gender") != null) setSex(formMap.getField("gender").getValue());
		if ( formMap.getField("pi_filing_status") !=null) setFilingStatus(formMap.getField("pi_filing_status").getValue());
		if ( formMap.getField("pi_dob") != null) {
			String strDate = formMap.getField("pi_dob").getValue();
			Date date = null ;
			DateFormat formatter ;
			formatter = getIndianDateFormatter();
			GregorianCalendar cal=(GregorianCalendar) GregorianCalendar.getInstance();
			try{
				date = (Date)formatter.parse(strDate);
				if(log.isInfoEnabled()){
					log.info("date"+date);
				}
				cal.setTime(date);
				setDOB(cal);
			}
			catch(Exception e){
				log.info("calendar error"+e);
			}
		}
		//Member Contact Information
		if (formMap.getField("pi_email") != null) setEmail(formMap.getField("pi_email").getValue());
		if (formMap.getField("pi_road_street") != null) setRoadStreet(formMap.getField("pi_road_street").getValue());
		if (formMap.getField("pi_std_code") != null) setStdCode(formMap.getField("pi_std_code").getValue());
		if (formMap.getField("ward_circle") != null) setWard_circle(formMap.getField("ward_circle").getValue());
		if (formMap.getField("pi_phone") != null) setPhone(formMap.getField("pi_phone").getValue());
		if (formMap.getField("pi_flat_door_building") != null) setFlatDoorBuilding(formMap.getField("pi_flat_door_building").getValue());
		if (formMap.getField("pi_premises_building") != null) setPremisesBuilding(formMap.getField("pi_premises_building").getValue());
		if (formMap.getField("pi_area_locality") != null) setAreaLocality(formMap.getField("pi_area_locality").getValue());
		if (formMap.getField("pi_town_city_district") != null) setTownCityDistrict(formMap.getField("pi_town_city_district").getValue());
		if (formMap.getField("pi_state") != null) {
			setState(formMap.getField("pi_state").getValue());
			if (formMap.getField("pi_pin_code") != null) {
				if(formMap.getField("pi_state").getValue().matches("99")){
					setPinCode("999999");
				}else{
					setPinCode(formMap.getField("pi_pin_code").getValue());
				}
			}
		}
		if (formMap.getField("pi_mobile") != null) setMobile(formMap.getField("pi_mobile").getValue());
		if (formMap.getField("pi_mobile1") != null) setMobile1(formMap.getField("pi_mobile1").getValue());
		//Bank Details
		if (formMap == null) return;
		if (formMap.getField("bd_bank_name") != null) setBD_BANK_NAME(formMap.getField("bd_bank_name").getValue());
		if (formMap.getField("bd_micr_code") != null) setBD_MICR_CODE(formMap.getField("bd_micr_code").getValue());
		if (formMap.getField("bd_Branch_name") != null) setBD_ADD_BANK_BRANCH(formMap.getField("bd_Branch_name").getValue());
		if (formMap.getField("bd_account_type") != null) setBD_TYPE_ACC(formMap.getField("bd_account_type").getValue());
		if (formMap.getField("bd_account_no") != null) setBD_ACC_NUMBER(formMap.getField("bd_account_no").getValue());
		if (formMap.getField("bd_ecs") != null) setBD_ECS(formMap.getField("bd_ecs").getValue());
		//Residential Status
		String choice="";
		if (formMap.getField("rsstatus_q") != null) {
			setRsstatusQ(formMap.getField("rsstatus_q").getValue());
			choice=choice+formMap.getField("rsstatus_q").getValue();
		}
		if (formMap.getField("rsstatus_q_yes") != null) {
			setRsstatusQYes(formMap.getField("rsstatus_q_yes").getValue());
			if(!(formMap.getField("rsstatus_q_yes").getValue().matches("Select"))){
				choice=choice+"_"+formMap.getField("rsstatus_q_yes").getValue();
			}
		}
		if (formMap.getField("rsstatus_q_yes_yes") != null) {
			setRsstatusQYesYes(formMap.getField("rsstatus_q_yes_yes").getValue());
			if(!(formMap.getField("rsstatus_q_yes_yes").getValue().matches("Select"))){
				choice=choice+"_"+formMap.getField("rsstatus_q_yes_yes").getValue();
			}
		}
		if (formMap.getField("rsstatus_q_no") != null) {
			setRsstatusQNo(formMap.getField("rsstatus_q_no").getValue());
			if(!(formMap.getField("rsstatus_q_no").getValue().matches("Select"))){
				choice=choice+"_"+formMap.getField("rsstatus_q_no").getValue();
			}
		}
		if (formMap.getField("rsstatus_q_no_yes") != null) {
			setRsstatusQNoYes(formMap.getField("rsstatus_q_no_yes").getValue());
			if(!(formMap.getField("rsstatus_q_no_yes").getValue().matches("Select"))){
				choice=choice+"_"+formMap.getField("rsstatus_q_no_yes").getValue();
			}
		}
		if (formMap.getField("rsstatus_q_no_yes_yes") != null) {
			setRsstatusQNoYesYes(formMap.getField("rsstatus_q_no_yes_yes").getValue());
			if(!(formMap.getField("rsstatus_q_no_yes_yes").getValue().matches("Select"))){
				choice=choice+"_"+formMap.getField("rsstatus_q_no_yes_yes").getValue();
			}
		}
		if (formMap.getField("rsstatus_q_no_no") != null) {
			setRsstatusQNoNo(formMap.getField("rsstatus_q_no_no").getValue());
			if(!(formMap.getField("rsstatus_q_no_no").getValue().matches("Select"))){
				choice=choice+"_"+formMap.getField("rsstatus_q_no_no").getValue();
			}
		}
		if (formMap.getField("rsstatus_q_no_no_yes") != null) {
			setRsstatusQNoNoYes(formMap.getField("rsstatus_q_no_no_yes").getValue());
			if(!(formMap.getField("rsstatus_q_no_no_yes").getValue().matches("Select"))){
				choice=choice+"_"+formMap.getField("rsstatus_q_no_no_yes").getValue();
			}
		}
		if (formMap.getField("rsstatus_q_no_no_yes_yes") != null) {
			setRsstatusQNoNoYesYes(formMap.getField("rsstatus_q_no_no_yes_yes").getValue());
			if(!(formMap.getField("rsstatus_q_no_no_yes_yes").getValue().matches("Select"))){
				choice=choice+"_"+formMap.getField("rsstatus_q_no_no_yes_yes").getValue();
			}
		}
		if (formMap.getField("rsstatus_q_no_yes_yes_yes") != null) {
			setRsstatusQNoYesYesYes(formMap.getField("rsstatus_q_no_yes_yes_yes").getValue());
			if(!(formMap.getField("rsstatus_q_no_yes_yes_yes").getValue().matches("Select"))){
				choice=choice+"_"+formMap.getField("rsstatus_q_no_yes_yes_yes").getValue();
			}
		}
		String modchoice="rsstatus_q_"+choice.trim();
		if(log.isInfoEnabled()){
			log.info("this is choice"+modchoice);
		}
		ResourceBundle rb = ResourceBundle.getBundle("rstatus_2012-2013");
		for (String aKey: rb.keySet() ) {
			if(aKey.matches(modchoice.trim())){
				if(log.isInfoEnabled()){
					log.info("this is residential status"+rb.getString(aKey).replaceFirst("ans_","").trim());
				}
				setResidentCategory(ResidentialFind(rb.getString(aKey)));
				break;
			}
		}
	}
	private String ResidentialFind(String key){
		if(key.matches("ans_Resident and Ordinarily Resident")) return "RES";
		if(key.matches("ans_Resident but Not Ordinarily Resident")) return "NOR";
		if(key.matches("ans_Non Resident")) return "NRI";
		else return null;
	}
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub

	}
}
