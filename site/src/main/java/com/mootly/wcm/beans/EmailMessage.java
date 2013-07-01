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

import java.io.File;
import java.text.ParseException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.jcr.Binary;
import javax.jcr.RepositoryException;
import javax.jcr.ValueFactory;

import org.apache.jackrabbit.JcrConstants;
import org.apache.jackrabbit.value.ValueFactoryImpl;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;

import com.mootly.wcm.beans.standard.FlexibleDocument;

/**
 * User: abhishek
 * Date: jan 08 2013
 * Time: 11:26:35 AM
 */

@Node(jcrType = "mootlywcm:emailmessage")
public class EmailMessage extends FlexibleDocument implements ContentNodeBinder {
	static final public String NAMESPACE = "mootlywcm:emailmessage";
	static final public String NODE_NAME="emailmessage";
	private String ATTACHMENTS="mootlywcm:attachments";
	private String HIPPO_RESOURCE="hippo:resource";
	String email;
	String[] to;
	String[] cc;
	String[] bcc;
	String templateKey;
	String subject;
	String htmlBody;
	String plainBody;
	String flex_string_attachment_files;


	public final String getEmail() {
		if (email == null) email = getProperty("mootlywcm:email");
		return email;
	}

	public final String getAttachmentList() {
		return getFlexField("flex_string_attachment_files", "");
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

	public void setAttachmentList(String attachmentList) {
		try {
			String fieldDataType = FlexibleDocument.getDataTypeFromFieldName("flex_string_attachment_files");
			setFlexField("flex_string_attachment_files",FlexibleDocument.getValueFromDataType(fieldDataType, attachmentList));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}



	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try {
			EmailMessage emailMessage = (EmailMessage) content;
			super.bindToNode(node);
			ValueFactory vf = ValueFactoryImpl.getInstance();
			node.setProperty("mootlywcm:to", emailMessage.getTo());
			if (emailMessage.getCc() != null) node.setProperty("mootlywcm:cc", emailMessage.getCc());
			if (emailMessage.getBcc() != null) node.setProperty("mootlywcm:bcc", emailMessage.getBcc());
			node.setProperty("mootlywcm:templateKey", emailMessage.getTemplateKey());
			node.setProperty("mootlywcm:email", emailMessage.getEmail());
			node.setProperty("mootlywcm:subject", emailMessage.getSubject());
			node.setProperty("mootlywcm:htmlbody", emailMessage.getHtmlBody());

			node.setProperty("mootlywcm:plainbody", emailMessage.getPlainBody());
			
			Map<String,Map<String,Object>> resultFileMap=dealWithAttachments(getAttachmentList());
			for(int i=0;i<resultFileMap.size();i++){
				Map<String,Object> fileDataMap=resultFileMap.get("file"+i);
				javax.jcr.Node resourceNode=node.addNode(ATTACHMENTS, HIPPO_RESOURCE);
				resourceNode.setProperty(JcrConstants.JCR_DATA,(Binary)fileDataMap.get("binaryData"));
				resourceNode.setProperty(JcrConstants.JCR_MIMETYPE, (String)fileDataMap.get("mimeType"));
				resourceNode.setProperty(JcrConstants.JCR_LASTMODIFIED,Calendar.getInstance());
				resourceNode.setProperty(JcrConstants.JCR_ENCODING,"UTF-8");
			}
		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}

	protected Map<String,Map<String,Object>> dealWithAttachments(String attachmentFileList) {
		if (attachmentFileList == null || "".equals(attachmentFileList.trim())){
			return null;
		}
		ValueFactory vf = ValueFactoryImpl.getInstance();
		Map<String,Map<String,Object>> fileMap=new HashMap<String, Map<String,Object>>();
		String[] attachmentParts = attachmentFileList.split("[,]");
		int i=0;
		for (String aFile:attachmentParts) {
			Map<String,Object> dummyMap = new HashMap<String, Object>();
			try {	
				String mimeType=null;
				DataSource source = new FileDataSource(aFile);
				log.info("this is mess"+source.getName());
				String fileExtension=source.getName().substring(source.getName().indexOf(".")+1, source.getName().length());
				log.info("content type"+"application/"+fileExtension);
				if(source.getContentType().endsWith("octet-stream")){
					mimeType="application/"+fileExtension;
				}else{
					mimeType=source.getContentType();
				}
				dummyMap.put("binaryData", vf.createBinary(source.getInputStream()));
				dummyMap.put("mimeType",mimeType);
				fileMap.put("file"+i, dummyMap);
				i++;
			}catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return fileMap;
	}
}
