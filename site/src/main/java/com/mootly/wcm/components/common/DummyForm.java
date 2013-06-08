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

package com.mootly.wcm.components.common;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.Session;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.onehippo.forge.easyforms.hst.EmailForm;
import org.onehippo.forge.easyforms.model.Form;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.ContactUs;
import com.mootly.wcm.beans.EmailMessage;
import com.mootly.wcm.beans.EmailTemplate;
import com.mootly.wcm.member.Member;
import com.mootly.wcm.member.MemberService;
import com.mootly.wcm.member.StartApplication.FullReviewedWorkflowCallbackHandler;
import com.mootly.wcm.utils.ContentStructure;
import com.mootly.wcm.utils.GoGreenUtil;
import com.mootly.wcm.utils.VelocityUtils;


/*
 * Written by Kusumlata 
 * This coding is done to send an email to the user's email address using email template after submitting Contact Us Form.    
 */

public class DummyForm extends EmailForm {

	private static final Logger log = LoggerFactory.getLogger(DummyForm.class);

	@Override
	public boolean onValidationSuccess(final HstRequest request, final HstResponse response, final Form form, final FormMap map) {

		// To fetch the details of form like field_0 for username, field_1 for email address, field_2 for comments.
		
		String userName=map.getField("name").getValue().toString();
		String emailAddress=map.getField("email").getValue().toString();
		String comments=map.getField("comments").getValue().toString();
		String subject=map.getField("subject").getValue().toString();
		log.info("New added fields of subject"+subject);

		//To create document as contact (ContactUs-Bean).
		ContactUs contact = new  ContactUs();

		//Create setter the values of required fields.
		contact.setUserName(userName);
		contact.setEmailAddress(emailAddress);
		contact.setComments(comments);
		contact.setSubject(subject);

		// To fetch the values of fields in Form(ContactUs) through contact document..
		createContactUsForm(request,contact);
		return true;
	}
	private void createContactUsForm(HstRequest request, ContactUs contact) {

		// TODO Auto-generated method stub
		log.warn("contact document method");
		Session persistableSession = null;
		WorkflowPersistenceManager wpm;
		try {
			persistableSession = getPersistableSession(request);
			wpm = getWorkflowPersistenceManager(persistableSession);
			//Simple Workflow
			wpm.setWorkflowCallbackHandler(new FullReviewedWorkflowCallbackHandler());
			//Contact Us Module is used to check whether the user is registered or not.
			String itReturnFolderPath=null;
			Member member=MemberService.getForgotPass(request,contact.getEmailAddress().toLowerCase());
			// If user is registered,then a document of type mootlywcm:contactus will be created under a member directory.
			if(member!=null){
				itReturnFolderPath = ContentStructure.getContactUsFolder(request);

			}
			//If user is not registered,then a document of type mootlywcm:contactus, content/contactus/UserName directory.
			else{
				itReturnFolderPath = ContentStructure.getContactUsFolderNonReg(request);
			}
			log.warn(itReturnFolderPath);
			final String itReturnPath = wpm.createAndReturn(itReturnFolderPath, ContactUs.NAMESPACE , ContactUs.NODE_NAME, true);
			log.warn(itReturnPath);
			ContactUs Contactdocument = (ContactUs) wpm.getObject(itReturnPath);
			// update Contactdocument properties..
			if (Contactdocument != null) {
				Contactdocument.setUserName(contact.getUserName());
				Contactdocument.setEmailAddress(contact.getEmailAddress());
				Contactdocument.setComments(contact.getComments());
				Contactdocument.setSubject(contact.getSubject());
				// update now           `
				wpm.update(Contactdocument);
				Map<String,Object> contextMap = new HashMap<String, Object>();
				// object is being used to fetch emailaddress repository.
				contextMap.put("Contactdocument", Contactdocument);
				String memberFolderPath=ContentStructure.getMemberContactUs(request);
				//A node is created with directory member/contactus.
				String pathToNewNode = wpm.createAndReturn(memberFolderPath +"/contactus", EmailMessage.NAMESPACE, "ack_contact_mail", true);
				//It creates an object of EmailMessage type.
				EmailMessage emailMessage = (EmailMessage) wpm.getObject(pathToNewNode);
				emailMessage.setTo(new String[]{Contactdocument.getEmailAddress()});
				emailMessage.setTemplateKey("contactus");	
				//It will return an object of Contactdocument at path "content/docunments/mootlywcm/conctactus".
				EmailTemplate emailTemplate = (EmailTemplate) wpm.getObject(ContentStructure.getEmailTemplatesPath(request) + "/contactus");

				// It will send an email to user's email address after submitting the ContactUs Form.
				if (emailTemplate != null) {
					log.error("Email template found");
					log.error("Email template HTML BODY" + emailTemplate.getHtmlBody());
					String htmlBody = VelocityUtils.parseVelocity(emailTemplate.getHtmlBody(), contextMap);
					String plainBody = VelocityUtils.parseVelocity(emailTemplate.getPlainBody(), contextMap);
					String subject = VelocityUtils.parseVelocity(emailTemplate.getSubject(), contextMap);
					emailMessage.setSubject(subject);
					emailMessage.setHtmlBody(htmlBody);
					emailMessage.setPlainBody(plainBody);
				}	
				//It will show the error message.
				else {
					emailMessage.setSubject("This is TEST, Welcome to MOOTLY");
					emailMessage.setHtmlBody("<B>COOL</B>");
				}
				wpm.update(emailMessage);

				return;
			}

			else {
				//log.warn("Failed to add review for product '{}': could not retrieve 
				// review bean for node '{}'.", ContactUs.NODE_NAME, itReturnPath);
				GoGreenUtil.refreshWorkflowManager(wpm);
				return;
			}

		} catch (Exception e) {
			//log.warn("Failed to create a review for product", e);
			return;
		} finally {
			if (persistableSession != null) {
				persistableSession.logout();
			}
		}
	}

	@Override
	public void onProcessFail(HstRequest request, HstResponse response, Form form, FormMap map) {
		super.onProcessFail(request, response, form, map);
		request.setAttribute("success","dummysuccess");
	}

	@Override
	public void onProcessDone(HstRequest request, HstResponse response, Form form, FormMap map) {
		super.onProcessDone(request, response, form, map);
		request.setAttribute("success","dummysuccess");
	}
}

//To see the data of fields of Contact Us Form.
//System.out.println(map.getField("field_0").getValue().toString());
//System.out.println(map.getField("field_1").getValue().toString());
//System.out.println(map.getField("field_2").getValue().toString());
//System.out.println(map.toString());
//List<String> dumy= new ArrayList<String>();
//String sName=form.getName().toString().trim();
//String sEmail=form.getEmail().toString().trim();
//String sComments=form.getComments().toString().trim();
//System.out.println(name);
//System.out.println(email);


