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
 * User: abhishek
 * Date: jan 08 2013
 * Time: 11:26:35 AM
 */

@Node(jcrType = "mootlywcm:emailmessage")
public class EmailMessage extends BaseDocument implements ContentNodeBinder {
	static final public String NAMESPACE = "mootlywcm:emailmessage";
	static final public String NODE_NAME="emailmessage";
	String email;
	String[] to;
	String[] cc;
	String[] bcc;
	String templateKey;
	String subject;
	String htmlBody;
	String plainBody;
	
	public final String getEmail() {
		if (email == null) email = getProperty("mootlywcm:email");
		return email;
	}
	
	public final String[] getTo() {
		if (to == null) to = getProperty("mootlywcm:to", new String[]{""});
		return to;
	}
	public final String[] getCc() {
		if (cc == null) to = getProperty("mootlywcm:cc", new String[]{""});
		return cc;
	}
	public final String[] getBcc() {
		if (bcc == null) to = getProperty("mootlywcm:bcc", new String[]{""});
		return bcc;
	}
	
	public String getTemplateKey() {
		if (templateKey == null) templateKey = getProperty("mootlywcm:templateKey");
		return templateKey;
	}
	public final String getSubject() {
		if (subject == null) subject = getProperty("mootlywcm:subject");
		return subject;
	}
	
	
	public final String getHtmlBody() {
		if (htmlBody == null) htmlBody = getProperty("mootlywcm:htmlbody");
		return htmlBody;
	}
	

	public final String getPlainBody() {
		if (plainBody == null) plainBody = getProperty("mootlywcm:plainbody");
		return plainBody;
	}
	
	public final void setEmail(String email) {
		this.email = email;
	}
	public final void setTo(String[] to) {
		this.to = to;
	}
	public final void setCc(String[] cc) {
		this.cc = cc;
	}
	public final void setBcc(String[] bcc) {
		this.bcc = bcc;
	}
	public final void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void setTemplateKey(String templateKey) {
		this.templateKey = templateKey;
	}
	public final void setHtmlBody(String htmlBody) {
		this.htmlBody = htmlBody;
	}
	
	public final void setPlainBody(String plainBody) {
		this.plainBody  = plainBody;
	}
	
	
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			EmailMessage emailMessage = (EmailMessage) content;
			node.setProperty("mootlywcm:to", emailMessage.getTo());
			if (emailMessage.getCc() != null) node.setProperty("mootlywcm:cc", emailMessage.getCc());
			if (emailMessage.getBcc() != null) node.setProperty("mootlywcm:bcc", emailMessage.getBcc());
			node.setProperty("mootlywcm:templateKey", emailMessage.getTemplateKey());
			node.setProperty("mootlywcm:email", emailMessage.getEmail());
			node.setProperty("mootlywcm:subject", emailMessage.getSubject());
			node.setProperty("mootlywcm:htmlbody", emailMessage.getHtmlBody());
			
			node.setProperty("mootlywcm:plainbody", emailMessage.getPlainBody());
		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
}
