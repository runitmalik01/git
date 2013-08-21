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
 * User: vivek
 * Date: Jun 29, 2010
 * Time: 11:26:35 AM
 */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:membersignupdocument")
public class MemberSignupDocument extends BaseDocument implements ContentNodeBinder,FormMapFiller,CompoundChildUpdate {
	static final String PROP_DETAIL_BEAN="mootlywcm:securityquestionanswer";
	static final public String NAMESPACE = "mootlywcm:membersignupdocument";
	static final public String NODE_NAME = "membersignupdocument";
	String userName;
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
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public final void setRoles(String[] roles) {
		this.roles = roles;
	}
	public final void setGroups(String[] groups) {
		this.groups = groups;
	}

	//for personal information
	/**
	 * @return the randomPassword
	 */
	public Boolean getRandomPassword() {
		if(randomPassword==null) randomPassword=getProperty("mootlywcm:randomPassword");
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
			log.warn("this is Member signup Bena");
			NodeIterator nodeIterator = node.getNodes(PROP_DETAIL_BEAN);
        	if (nodeIterator != null) {
	        	while (nodeIterator.hasNext()) {
	        		javax.jcr.Node aNode = nodeIterator.nextNode();
	        		aNode.remove();
	        	}
        	}
			MemberSignupDocument memberSignup = (MemberSignupDocument) content;
			node.setProperty("mootlywcm:userName", memberSignup.getUserName());
			node.setProperty("mootlywcm:password", memberSignup.getPassword());
			node.setProperty("mootlywcm:email", memberSignup.getEmail());
			if (memberSignup.getPAN() != null) {
				node.setProperty("mootlywcm:pan", memberSignup.getPAN());
			}
			node.setProperty("mootlywcm:firstName", memberSignup.getFirstName());
			node.setProperty("mootlywcm:lastName", memberSignup.getLastName());
			node.setProperty("mootlywcm:isActive", memberSignup.getIsActive());
			node.setProperty("mootlywcm:activationCode", memberSignup.getActivationCode());
			node.setProperty("mootlywcm:groups", memberSignup.getGroups());
			node.setProperty("mootlywcm:securityQuestions", memberSignup.getSecurityQuestions());

			if (memberSignup.getRoles() != null) {
				node.setProperty("mootlywcm:roles", memberSignup.getRoles());
			}
			if (memberSignup.getGroups() != null) {
				node.setProperty("mootlywcm:groups", memberSignup.getGroups());
			}
			
			if(memberSignup.getSecurityQuestionAnswerValueListList() !=null && memberSignup.getSecurityQuestionAnswerValueListList().size() != 0){
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
