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
import static com.mootly.wcm.utils.Constants.PROP_NEW_PASSWORD;

import static com.mootly.wcm.utils.Constants.PROP_OLD_PASSWORD;

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
@Node(jcrType = "mootlywcm:ChangePasswordRequest")
public class ChangePasswordRequest extends BaseDocument implements ContentNodeBinder {
	static final public String NAMESPACE = "mootlywcm:ChangePasswordRequest";
	static final public String NODE_NAME = "changepasswordrequest";
	
	String Old_Password;
	String New_Password;
	String username;

	public final String getNewPassword() {
		if (New_Password == null) New_Password = getProperty("mootlywcm:New_Password");
		return New_Password;
	}
	public final String getOldPassword() {
		if (Old_Password == null) Old_Password = getProperty("mootlywcm:Old_Password");
		return Old_Password;
	}

	public final String getUserName() {
		if (username == null) username = getProperty("mootlywcm:UserName");
		return username;
	}
	
	public final void setOldPassword(String Old_Password) {
		this.Old_Password = Old_Password;
	}
	public final void setUserName(String username) {
		this.username = username;
	}
	public final void setNewPassword(String New_Password) {
		this.New_Password = New_Password;
	}
	
//for personal information
	
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			log.info("this is bean so !!");
			ChangePasswordRequest memberSignup = (ChangePasswordRequest) content;
	
			node.setProperty("mootlywcm:New_Password", memberSignup.getNewPassword());
			node.setProperty("mootlywcm:Old_Password", memberSignup.getOldPassword());
			node.setProperty("mootlywcm:UserName", memberSignup.getUserName());

		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
}
