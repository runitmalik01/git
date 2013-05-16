/*
 *  Copyright 2011 Hippo.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.mootly.wcm.it.workflow;

import java.rmi.RemoteException;
import java.util.Iterator;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.hippoecm.repository.api.Document;
import org.hippoecm.repository.api.MappingException;
import org.hippoecm.repository.api.WorkflowException;
import org.hippoecm.repository.ext.WorkflowImpl;
import org.hippoecm.repository.standardworkflow.WorkflowEventWorkflow;

import com.mootly.wcm.it.workflow.util.EmailTask;

@PersistenceCapable
public class EmailMessageEventWorkflowImpl extends WorkflowImpl implements WorkflowEventWorkflow {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
    private final static String SVN_ID = "$Id: WorkflowEventsWorkflowImpl.java 29256 2011-08-01 14:36:36Z bvanhalderen $";

	@Persistent(column="mootlywcm:to")
	String[] to;
	@Persistent(column="mootlywcm:cc")
	String[] cc;
	@Persistent(column="mootlywcm:bcc")
	String[] bcc;
	
	@Persistent(column="mootlywcm:subject")
	String subject;

	@Persistent(column="mootlywcm:htmlbody")
	String htmlBody;

	@Persistent(column="mootlywcm:plainbody")
	String plainBody;
	
	@Persistent(column="mootlywcm:delivered")
	Boolean delivered;
	
    public EmailMessageEventWorkflowImpl() throws RemoteException {
    }

    public void fire() throws WorkflowException, MappingException {
    	System.err.println("Email Message Request Received..");
    	for (String emailAddress:to) {
    		System.err.println("Sending email to :" + emailAddress);
    		try {    			
    			//EmailService.sendEmail(to,cc,bcc,subject,htmlBody,plainBody);
    			EmailTask emailTask = new EmailTask();
    			emailTask.addMessage(emailAddress, emailAddress, "info@wealth4india.com", "info@wealth4india.com", subject, plainBody, htmlBody);
    			emailTask.run();
    			delivered = true;
    		}catch (Exception ex) {
    			ex.printStackTrace();
    		}
    	}
    }

    public void fire(Document document) throws WorkflowException, MappingException {
        System.err.println("document "+document.getIdentity()+" has published");
    }

    public void fire(Iterator<Document> documentIterator) throws WorkflowException, MappingException {
        while(documentIterator.hasNext()) {
            Document document = documentIterator.next();
            System.err.println("documents "+document.getIdentity()+" has published");
        }
    }
}
