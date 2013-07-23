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
import java.util.Calendar;
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
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;

/**
 * User: vivek
 * Date: Jun 29, 2010
 * Time: 11:26:35 AM
 */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:membersignupdocument")
public class MemberSignupDocument extends BaseDocument implements ContentNodeBinder {
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
	
    
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			log.warn("this is Member signup Bena");
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

			

			if (memberSignup.getRoles() != null) {
				node.setProperty("mootlywcm:roles", memberSignup.getRoles());
			}
			if (memberSignup.getGroups() != null) {
				node.setProperty("mootlywcm:groups", memberSignup.getGroups());
			}
		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
}
