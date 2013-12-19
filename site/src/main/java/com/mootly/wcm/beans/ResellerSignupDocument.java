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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import static com.mootly.wcm.utils.Constants.PROP_PI_AREA_LOCALITY;
import static com.mootly.wcm.utils.Constants.PROP_PI_DOB;
import static com.mootly.wcm.utils.Constants.PROP_PI_EMAIL;
import static com.mootly.wcm.utils.Constants.PROP_PI_FATHER_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_FILING_STATUS;
import static com.mootly.wcm.utils.Constants.PROP_PI_FIRST_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_FLAT_FLOOR_BUILDING;
import static com.mootly.wcm.utils.Constants.PROP_PI_LAST_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_MIDDLE_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_MOBILE;
import static com.mootly.wcm.utils.Constants.PROP_PI_PAN;
import static com.mootly.wcm.utils.Constants.PROP_PI_PHONE;
import static com.mootly.wcm.utils.Constants.PROP_PI_PINCODE;
import static com.mootly.wcm.utils.Constants.PROP_PI_ROAD_STREET;
import static com.mootly.wcm.utils.Constants.PROP_PI_SEX;
import static com.mootly.wcm.utils.Constants.PROP_PI_STATE;
import static com.mootly.wcm.utils.Constants.PROP_PI_STD_CODE;
import static com.mootly.wcm.utils.Constants.PROP_PI_TOWN_CITY_DISTRICT;
import static com.mootly.wcm.utils.Constants.PROP_PI_RESIDENT_CATEGORY;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.beans.compound.SalaryIncomeDetail;
import com.mootly.wcm.beans.compound.SecurityQuestionAnswerValueList;

/**
 * User: Dhananjay
 * Date: 10-12-2013
 * 
 */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:resellersignupdocument")
public class ResellerSignupDocument extends BaseDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate {
	static final String PROP_DETAIL_BEAN="mootlywcm:securityquestionanswer";
	static final public String NAMESPACE = "mootlywcm:resellersignupdocument";
	static final public String NODE_NAME = "resellersignupdocument";
	String userName;
	String resellerID;
	String phoneCustomerService;
	String email;
	String password;
	String firstName;
	String lastName;
	String activationCode;
	Boolean isActive;
	String[] roles;
	String[] groups;
	String[] pan;
	private Boolean randomPassword;
	private Boolean securityQuestions;
	private String mobile;
	private String alternativeEmail;
	private List<SecurityQuestionAnswerValueList> secQuestionsAnswersList;

	String emailCustomerService;
	String emailFrom;
	String emailFromName;
	String emailSignature;
	Boolean eriEnable26ASImport;
	Boolean eriEnabled;
	String eriPassword;
	String eriUserId;
	Boolean isReseller;
	String pageTitlePrefix;
	String[] paymentAvailableTypes;
	Boolean paymentEnabled;
	String resellerName;
	String startDate;
	String endDate;
	String resellerPackage;
	String numberOfLicensedUsers;

	//for personal information
	public final String getUserName() {
		if (userName == null) userName = getProperty("mootlywcm:userName");
		return userName;
	}
	public final String getEmail() {
		if (email == null) email = getProperty("mootlywcm:email");
		return email;
	}
	public final String getPassword() {
		if (password == null) password = getProperty("mootlywcm:password");
		return password;
	}
	public final String getFirstName() {
		if (firstName == null) firstName = getProperty("mootlywcm:firstName");
		return firstName;
	}
	public final String getLastName() {
		if (lastName == null) lastName = getProperty("mootlywcm:lastName");
		return lastName;
	}
	public final String[] getPAN() {
		if (pan == null) pan = getProperty("mootlywcm:pan",new String[]{" "});
		return pan;
	}
	public String getActivationCode() {
		if (activationCode == null) activationCode = getProperty("mootlywcm:activationCode");
		return activationCode;
	}
	public String getPhoneCustomerService() {
		if (phoneCustomerService == null) phoneCustomerService = getProperty("mootlywcm:phoneCustomerService");
		return phoneCustomerService;
	}
	public String getResellerID() {
		if (resellerID == null) resellerID = getProperty("mootlywcm:resellerID");
		return resellerID;
	}
	public Boolean getIsActive() {
		if (isActive == null) isActive = getProperty("mootlywcm:isActive");
		return isActive;
	}
	public final String[] getRoles() {
		if (roles != null) roles = getProperty("mootlywcm:roles", new String[]{"registereduser"});
		return roles;
	}
	public final String[] getGroups() {
		if (groups != null) groups = getProperty("mootlywcm:groups", new String[]{"registereduser"});
		return groups;
	}
	public String getEmailCustomerService() {
		if (emailCustomerService == null) emailCustomerService = getProperty("mootlywcm:emailCustomerService");
		return emailCustomerService;
	}
	public String getEmailFrom() {
		if (emailFrom == null) emailFrom = getProperty("mootlywcm:emailFrom");
		return emailFrom;
	}
	public String getEmailFromName() {
		if (emailFromName == null) emailFromName = getProperty("mootlywcm:emailFromName");
		return emailFromName;
	}
	public String getEmailSignature() {
		if (emailSignature == null) emailSignature = getProperty("mootlywcm:emailSignature");
		return emailSignature;
	}
	public String getEriPassword() {
		if (eriPassword == null) eriPassword = getProperty("mootlywcm:eriPassword");
		return eriPassword;
	}
	public String getEriUserId() {
		if (eriUserId == null) eriUserId = getProperty("mootlywcm:eriUserId");
		return eriUserId;
	}
	public String getPageTitlePrefix() {
		if (pageTitlePrefix == null) pageTitlePrefix = getProperty("mootlywcm:pageTitlePrefix");
		return pageTitlePrefix;
	}
	public String[] getPaymentAvailableTypes() {
		if (paymentAvailableTypes == null) paymentAvailableTypes = getProperty("mootlywcm:paymentAvailableTypes", new String[]{"paymentAvailableTypes"});
		return paymentAvailableTypes;
	}
	public String getResellerName() {
		if (resellerName == null) resellerName = getProperty("mootlywcm:resellerName");
		return resellerName;
	}
	public Boolean getEriEnable26ASImport() {
		if (eriEnable26ASImport == null) eriEnable26ASImport = getProperty("mootlywcm:eriEnable26ASImport");
		return eriEnable26ASImport;
	}
	public Boolean getEriEnabled() {
		if (eriEnabled == null) eriEnabled = getProperty("mootlywcm:eriEnabled");
		return eriEnabled;
	}
	public Boolean getIsReseller() {
		if (isReseller == null) isReseller = getProperty("mootlywcm:isReseller");
		return isReseller;
	}
	public Boolean getPaymentEnabled() {
		if (paymentEnabled == null) paymentEnabled = getProperty("mootlywcm:paymentEnabled");
		return paymentEnabled;
	}
	public String getStartDate() {
		if (startDate == null) startDate = getProperty("mootlywcm:startDate");
		return startDate;
	}
	public String getEndDate() {
		if (endDate == null) endDate = getProperty("mootlywcm:endDate");
		return endDate;
	}
	public String getResellerPackage() {
		if (resellerPackage == null) resellerPackage = getProperty("mootlywcm:resellerPackage");
		return resellerPackage;
	}
	public String getNumberOfLicensedUsers() {
		if (numberOfLicensedUsers == null) numberOfLicensedUsers = getProperty("mootlywcm:numberOfLicensedUsers");
		return numberOfLicensedUsers;
	}

	public final void setUserName(String userName) {
		this.userName = userName;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public final void setPassword(String password) {
		this.password = password;
	}
	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public final void setPAN(String[] pan) {
		this.pan = pan;
	}
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}
	public void setPhoneCustomerService(String phoneCustomerService) {
		this.phoneCustomerService = phoneCustomerService;
	}
	public void setResellerID(String resellerID) {
		this.resellerID = resellerID;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public final void setRoles(String[] roles) {
		this.roles = roles;
	}
	public final void setGroups(String[] groups) {
		this.groups = groups;
	}
	public void setEmailCustomerService(String emailCustomerService) {
		this.emailCustomerService = emailCustomerService;
	}
	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}
	public void setEmailFromName(String emailFromName) {
		this.emailFromName = emailFromName;
	}
	public void setEmailSignature(String emailSignature) {
		this.emailSignature = emailSignature;
	}
	public void setEriPassword(String eriPassword) {
		this.eriPassword = eriPassword;
	}
	public void setEriUserId(String eriUserId) {
		this.eriUserId = eriUserId;
	}
	public void setPageTitlePrefix(String pageTitlePrefix) {
		this.pageTitlePrefix = pageTitlePrefix;
	}
	public void setPaymentAvailableTypes(String[] paymentAvailableTypes) {
		this.paymentAvailableTypes = paymentAvailableTypes;
	}
	public void setResellerName(String resellerName) {
		this.resellerName = resellerName;
	}
	public void setEriEnable26ASImport(Boolean eriEnable26ASImport) {
		this.eriEnable26ASImport = eriEnable26ASImport;
	}
	public void setEriEnabled(Boolean eriEnabled) {
		this.eriEnabled = eriEnabled;
	}
	public void setIsReseller(Boolean isReseller) {
		this.isReseller = isReseller;
	}
	public void setPaymentEnabled(Boolean paymentEnabled) {
		this.paymentEnabled = paymentEnabled;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public void setResellerPackage(String resellerPackage) {
		this.resellerPackage = resellerPackage;
	}
	public void setNumberOfLicensedUsers(String numberOfLicensedUsers) {
		this.numberOfLicensedUsers = numberOfLicensedUsers;
	}


	//for personal information
	/**
	 * @return the randomPassword
	 */
	public Boolean getRandomPassword() {
		if(randomPassword==null) randomPassword=getProperty("mootlywcm:randomPassword");
		randomPassword = randomPassword == null ? false : randomPassword;
		return randomPassword;
	}
	/**
	 * @param randomPassword the randomPassword to set
	 */
	public void setRandomPassword(Boolean randomPassword) {
		this.randomPassword = randomPassword;
	}
	/**
	 * @return the securityQuestions
	 */
	public Boolean getSecurityQuestions() {
		if(securityQuestions==null) securityQuestions=getProperty("mootlywcm:securityQuestions");
		securityQuestions = securityQuestions == null ? false : securityQuestions;
		return securityQuestions;
	}
	/**
	 * @param securityQuestions the securityQuestions to set
	 */
	public void setSecurityQuestions(Boolean securityQuestions) {
		this.securityQuestions = securityQuestions;
	}

	public final void addSecurityQuestionAnswer(SecurityQuestionAnswerValueList securityQuestionAnswerValueList) {
		getSecurityQuestionAnswerValueListList();
		if (secQuestionsAnswersList == null) secQuestionsAnswersList = new ArrayList<SecurityQuestionAnswerValueList>();
		secQuestionsAnswersList.add(securityQuestionAnswerValueList);
	}

	public final List<SecurityQuestionAnswerValueList> getSecurityQuestionAnswerValueListList() {
		if (secQuestionsAnswersList == null) secQuestionsAnswersList= getChildBeans(PROP_DETAIL_BEAN);
		return secQuestionsAnswersList;
	}

	public final void setSecurityQuestionAnswerValueListList(List<SecurityQuestionAnswerValueList> secQuestionsAnswersList) {
		this.secQuestionsAnswersList = secQuestionsAnswersList;
	}

	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			log.warn("this is vendor signup Bena");
			NodeIterator nodeIterator = node.getNodes(PROP_DETAIL_BEAN);
			if (nodeIterator != null) {
				while (nodeIterator.hasNext()) {
					javax.jcr.Node aNode = nodeIterator.nextNode();
					aNode.remove();
				}
			}
			ResellerSignupDocument resellerSignup = (ResellerSignupDocument) content;
			node.setProperty("mootlywcm:userName", resellerSignup.getUserName());
			node.setProperty("mootlywcm:password", resellerSignup.getPassword());
			node.setProperty("mootlywcm:email", resellerSignup.getEmail());
			node.setProperty("mootlywcm:emailCustomerService", resellerSignup.getEmailCustomerService());
			node.setProperty("mootlywcm:emailFrom", resellerSignup.getEmailFrom());
			node.setProperty("mootlywcm:emailFromName", resellerSignup.getEmailFromName());
			node.setProperty("mootlywcm:emailSignature", resellerSignup.getEmailSignature());
			node.setProperty("mootlywcm:eriEnable26ASImport", resellerSignup.getEriEnable26ASImport());
			node.setProperty("mootlywcm:eriEnabled", resellerSignup.getEriEnabled());
			node.setProperty("mootlywcm:eriPassword", resellerSignup.getEriPassword());
			node.setProperty("mootlywcm:eriUserId", resellerSignup.getEriUserId());
			node.setProperty("mootlywcm:isReseller", resellerSignup.getIsReseller());
			node.setProperty("mootlywcm:pageTitlePrefix", resellerSignup.getPageTitlePrefix());
			node.setProperty("mootlywcm:startDate", resellerSignup.getStartDate());
			node.setProperty("mootlywcm:endDate", resellerSignup.getEndDate());
			if(resellerSignup.getPaymentAvailableTypes()!=null)
				node.setProperty("mootlywcm:paymentAvailableTypes", resellerSignup.getPaymentAvailableTypes());
			node.setProperty("mootlywcm:paymentEnabled", resellerSignup.getPaymentEnabled());
			node.setProperty("mootlywcm:resellerName", resellerSignup.getResellerName());
			node.setProperty("mootlywcm:resellerPackage", resellerSignup.getResellerPackage());
			node.setProperty("mootlywcm:numberOfLicensedUsers", resellerSignup.getNumberOfLicensedUsers());

			if (resellerSignup.getPAN() != null) {
				node.setProperty("mootlywcm:pan", resellerSignup.getPAN());
			}
			node.setProperty("mootlywcm:firstName", resellerSignup.getFirstName());
			node.setProperty("mootlywcm:lastName", resellerSignup.getLastName());
			node.setProperty("mootlywcm:isActive", resellerSignup.getIsActive());
			node.setProperty("mootlywcm:resellerID", resellerSignup.getResellerID());
			node.setProperty("mootlywcm:phoneCustomerService", resellerSignup.getPhoneCustomerService());
			node.setProperty("mootlywcm:activationCode", resellerSignup.getActivationCode());
			node.setProperty("mootlywcm:groups", resellerSignup.getGroups());
			node.setProperty("mootlywcm:securityQuestions", resellerSignup.getSecurityQuestions());

			if (resellerSignup.getRoles() != null) {
				node.setProperty("mootlywcm:roles", resellerSignup.getRoles());
			}
			if (resellerSignup.getGroups() != null) {
				node.setProperty("mootlywcm:groups", resellerSignup.getGroups());
			}

			if(resellerSignup.getSecurityQuestionAnswerValueListList() !=null && resellerSignup.getSecurityQuestionAnswerValueListList().size() > 0){
				for(SecurityQuestionAnswerValueList secQuesAnsDoc:getSecurityQuestionAnswerValueListList()){
					if (!secQuesAnsDoc.isMarkedForDeletion()) {
						javax.jcr.Node html = node.addNode(PROP_DETAIL_BEAN, PROP_DETAIL_BEAN);
						secQuesAnsDoc.bindToNode(html);
					}
				}
			}
		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
	@Override
	public void update(HippoBean child) {
		// TODO Auto-generated method stub
		if (child.getCanonicalUUID() == null) {
			SecurityQuestionAnswerValueList source =(SecurityQuestionAnswerValueList) child;
			addSecurityQuestionAnswer(source);
		}
		boolean found = false;
		List<SecurityQuestionAnswerValueList> listOfChildren = getSecurityQuestionAnswerValueListList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				SecurityQuestionAnswerValueList destination =(SecurityQuestionAnswerValueList) o;
				SecurityQuestionAnswerValueList source  = (SecurityQuestionAnswerValueList) child;
				destination.cloneBean(source);
				found = true;
				break;
			}
		}
	}
	@Override
	public void delete(HippoBean child) {
		// TODO Auto-generated method stub
		boolean found = false;
		List<SecurityQuestionAnswerValueList> listOfChildren = getSecurityQuestionAnswerValueListList();
		for (HippoBean o:listOfChildren) {
			log.info( o.getCanonicalUUID() );
			if (child.getCanonicalUUID() != null && child.getCanonicalUUID().equals(o.getCanonicalUUID())) {
				log.info("GOT A MATCH");
				SecurityQuestionAnswerValueList destination =(SecurityQuestionAnswerValueList) o;
				SecurityQuestionAnswerValueList source  = (SecurityQuestionAnswerValueList) child;
				destination.setMarkedForDeletion(true);
				found = true;
				break;
			}
		}
		if (!found) {
			//its a new node lets add it
			SecurityQuestionAnswerValueList source =(SecurityQuestionAnswerValueList) child;
			addSecurityQuestionAnswer(source);
		}
	}
	@Override
	public void add(HippoBean child) {
		// TODO Auto-generated method stub
		SecurityQuestionAnswerValueList source =(SecurityQuestionAnswerValueList) child;
		addSecurityQuestionAnswer(source);	
	}
	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub

	}
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub

	}
	/**
	 * @return the alternativeEmail
	 */
	public String getAlternativeEmail() {
		return alternativeEmail;
	}
	/**
	 * @param alternativeEmail the alternativeEmail to set
	 */
	public void setAlternativeEmail(String alternativeEmail) {
		this.alternativeEmail = alternativeEmail;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
