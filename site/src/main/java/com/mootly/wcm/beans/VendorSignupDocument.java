/*
 * class containing methods for vendor sigup document
 * @author Dhananjay
 * 01/06/2013
 */

package com.mootly.wcm.beans;
import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:vendorsignupdocument")
public class VendorSignupDocument extends BaseDocument implements ContentNodeBinder {
	static final public String NAMESPACE = "mootlywcm:vendorsignupdocument";
	static final public String NODE_NAME = "vendorsignupdocument";
	String organization;
	String userName;
	String email;
	String password;
	String activationCode;
	Boolean isActive;

	//for personal information
	public final String getOrganization() {
		if (organization == null) organization = getProperty("mootlywcm:organization");
		return organization;
	}
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

	public String getActivationCode() {
		if (activationCode == null) activationCode = getProperty("mootlywcm:activationCode");
		return activationCode;
	}
	public Boolean getIsActive() {
		if (isActive == null) isActive = getProperty("mootlywcm:isActive");
		return isActive;
	}

	public final void setOrganization(String organization) {
		this.organization = organization;
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
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

//for personal information


	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			log.warn("this is Vendor signup Bean");
			VendorSignupDocument vendorSignup = (VendorSignupDocument) content;
			node.setProperty("mootlywcm:organization", vendorSignup.getOrganization());
			node.setProperty("mootlywcm:userName", vendorSignup.getUserName());
			node.setProperty("mootlywcm:password", vendorSignup.getPassword());
			node.setProperty("mootlywcm:email", vendorSignup.getEmail());
			node.setProperty("mootlywcm:isActive", vendorSignup.getIsActive());
			node.setProperty("mootlywcm:activationCode", vendorSignup.getActivationCode());

		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
}
