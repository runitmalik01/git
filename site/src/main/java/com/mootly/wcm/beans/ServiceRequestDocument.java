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

import static com.mootly.wcm.utils.Constants.PROP_PI_EMAIL;
import static com.mootly.wcm.utils.Constants.PROP_PI_FIRST_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_LAST_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_MIDDLE_NAME;
import static com.mootly.wcm.utils.Constants.PROP_PI_MOBILE;

import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;


/**
 * [mootlywcm:product] > mootlywcm:document, relateddocs:relatabledocs
 * - mootlywcm:price (double)
 * - mootlywcm:rating (double)
 * - mootlywcm:votes (long)
 * - mootlywcm:categories (string) multiple
 * + mootlywcm:images (hippogallerypicker:imagelink) multiple
 */
@Node(jcrType = "mootlywcm:servicerequestdocument")
public class ServiceRequestDocument extends BaseDocument implements ContentNodeBinder {
	static final public String NAMESPACE = "mootlywcm:servicerequestdocument";
	static final public String NODE_NAME = "ServiceRequestDocument";

	private String firstName;
	private String middleName;
	private String lastName;
	private String mobile;
	private String email;
	private String address;
	private String serviceCode;
	private String offeringMode;
	private GregorianCalendar requestDate;
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		if(firstName==null) firstName=getProperty(PROP_PI_FIRST_NAME);
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		if(middleName==null) middleName=getProperty(PROP_PI_MIDDLE_NAME);
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the lasttName
	 */
	public String getLastName() {
		if(lastName==null) lastName=getProperty(PROP_PI_LAST_NAME);
		return lastName;
	}
	/**
	 * @param lasttName the lasttName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		if(mobile==null) mobile=getProperty(PROP_PI_MOBILE);
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		if(email==null) email=getProperty(PROP_PI_EMAIL);
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		if(address==null) address=getProperty("mootlywcm:address");
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the serviceCode
	 */
	public String getServiceCode() {
		if(serviceCode==null) serviceCode=getProperty("mootlywcm:serviceCode");
		return serviceCode;
	}
	/**
	 * @param serviceCode the serviceCode to set
	 */
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	/**
	 * @return the offeringMode
	 */
	public String getOfferingMode() {
		if(offeringMode==null) offeringMode=getProperty("mootlywcm:offeringMode");
		return offeringMode;
	}
	/**
	 * @param offeringMode the offeringMode to set
	 */
	public void setOfferingMode(String offeringMode) {
		this.offeringMode = offeringMode;
	}


	/**
	 * @return the requestDate
	 */
	public GregorianCalendar getRequestDate() {
		if(offeringMode==null) offeringMode=getProperty("mootlywcm:requestDate");
		return requestDate;
	}
	public String getDOBStr() {
		if (requestDate == null) requestDate = getProperty("mootlywcm:requestDate");
		if (requestDate != null) {
			String dobStr = getIndianDateFormatter().format(requestDate.getTime());
			return dobStr;
		}
		return null;
	}
	/**
	 * @param requestDate the requestDate to set
	 */
	public void setRequestDate(GregorianCalendar requestDate) {
		this.requestDate = requestDate;
	}
	@Override
	public boolean bind(Object content, javax.jcr.Node node) throws ContentNodeBindingException {
		ServiceRequestDocument bean = (ServiceRequestDocument) content;        
		try {
			node.setProperty(PROP_PI_FIRST_NAME,bean.getFirstName());
			node.setProperty(PROP_PI_MIDDLE_NAME,bean.getMiddleName());
			node.setProperty(PROP_PI_LAST_NAME, bean.getLastName());
			node.setProperty(PROP_PI_EMAIL, bean.getEmail());
			node.setProperty(PROP_PI_MOBILE, bean.getMobile());
			node.setProperty("mootlywcm:address", bean.getAddress());
			node.setProperty("mootlywcm:serviceCode", bean.getServiceCode());
			node.setProperty("mootlywcm:offeringMode", bean.getOfferingMode());
			node.setProperty("mootlywcm:requestDate", GregorianCalendar.getInstance(TimeZone.getTimeZone("UTC")));
		} 
		catch (RepositoryException e) {
			log.error("Repository Exception",e);
			throw new ContentNodeBindingException(e);
		}
		return true;
	}

}
