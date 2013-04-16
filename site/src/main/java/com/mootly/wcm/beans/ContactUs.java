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

// Bean File for ContactUs Form for three fields like username, emailaddress, comments....
package com.mootly.wcm.beans;
import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;


@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:ContactUs")
public class ContactUs extends BaseDocument implements ContentNodeBinder {
	static final public String NAMESPACE = "mootlywcm:ContactUs";
	static final public String NODE_NAME = "contactus";
	
	// Declaration of variables.
	private String userName;
	private String emailaddress;
	private String comments;
	
	// To create getter for variables.
	public String getUserName() {
        if (userName == null) userName = getProperty("mootlywcm:cu_user_name");
        return userName;
    }
	
	public String getEmailAddress() {
    	if (emailaddress == null) emailaddress =  getProperty("mootlywcm:cu_email_address");
    	return emailaddress;
    }
	public String getComments() {
    	if (comments == null) comments =  getProperty("mootlywcm:cu_comments");
    	return comments;
    }
	
	// To create setter for variables.
	public final void setUserName(String userName) {
		this.userName = userName;
	}
	
	public final void setEmailAddress(String emailAddress) {
		this.emailaddress = emailAddress;
	}

	public final void setComments(String comments) {
		this.comments = comments;
	}
	
	
    
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			
			  ContactUs contactus_doc = (ContactUs) content;
			node.setProperty("mootlywcm:cu_user_name",contactus_doc.getUserName());
			node.setProperty("mootlywcm:cu_email_address",contactus_doc.getEmailAddress());
			node.setProperty("mootlywcm:cu_comments",contactus_doc.getComments());
		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
}
