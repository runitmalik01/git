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

import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;


/**
 * User: megha
 * Date: 08/01/2013
 * Time: 12:46:35 PM
 */

@Node(jcrType = "mootlywcm:emailtemplate")
public class EmailTemplate extends BaseDocument implements ContentNodeBinder {
	static final public String NAMESPACE = "mootlywcm:emailtemplate";
	static final public String NODE_NAME = "emailtemplate";
	String email;
	String templateKey;
	String from;
	String fromName;
	String subject;
	String htmlBody;
	String plainBody;
	String[] bcc;
	String[] cc;
	String[] to;
	
	public final String[] getTo() {
		if (to == null) {
			String toStr = getProperty("mootlywcm:to");
			if (toStr != null) {
				to = toStr.toString().split(",");
			}
		}
		return to;
	}
	
	public final String[] getBcc() {
		if (bcc == null) {
			String bccStr = getProperty("mootlywcm:bcc");
			if (bccStr != null) {
				bcc = bccStr.toString().split(",");
			}
		}
		return bcc;
	}
	
	public final String[] getCc() {
		if (cc == null) {
			String ccStr = getProperty("mootlywcm:cc");
			if (ccStr != null) {
				cc = ccStr.toString().split(",");
			}
		}
		return cc;
	}
	
	public final String getEmail() {
		if (email == null) email = getProperty("mootlywcm:email");
		return email;
	}

	public String getTemplateKey() {
		if (templateKey == null) templateKey = getProperty("mootlywcm:templateKey");
		return templateKey;
	}

	public String getFrom() {
		if (from == null) from = getProperty("mootlywcm:from");
		return from;
	}

	public String getFromName() {
		if (fromName == null) fromName = getProperty("mootlywcm:fromName");
		return fromName;
	}

	public String getSubject() {
		if (subject == null) subject = getProperty("mootlywcm:subject");
		return subject;
	}

	public String getHtmlBody() {
		if (htmlBody == null) htmlBody = getProperty("mootlywcm:htmlBody");
		return htmlBody;
	}

	public String getPlainBody() {
		if (plainBody == null) plainBody = getProperty("mootlywcm:plainBody");
		return plainBody;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	
	public void setTemplateKey(String templateKey) {
		this.templateKey = templateKey;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setHtmlBody(String htmlBody) {
		this.htmlBody = htmlBody;
	}

	public void setPlainBody(String plainBody) {
		this.plainBody = plainBody;
	}
	
	public void setBcc(String[] bcc) {
		this.bcc = bcc;
	}
	
	public void setCc(String[] cc) {
		this.cc = cc;
	}

	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			EmailTemplate memberSignup = (EmailTemplate) content;
			node.setProperty("mootlywcm:templateKey", memberSignup.getTemplateKey());
			node.setProperty("mootlywcm:password", memberSignup.getFrom());
			node.setProperty("mootlywcm:fromName", memberSignup.getFromName());
			node.setProperty("mootlywcm:email", memberSignup.getEmail());
			node.setProperty("mootlywcm:subject", memberSignup.getSubject());
			node.setProperty("mootlywcm:firstName", memberSignup.getHtmlBody());
			node.setProperty("mootlywcm:lastName", memberSignup.getPlainBody());
			node.setProperty("mootlywcm:middleName", memberSignup.getPlainBody());
			node.setProperty("mootlywcm:bcc", memberSignup.getBcc());
			node.setProperty("mootlywcm:cc", memberSignup.getCc());
		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
	
}
