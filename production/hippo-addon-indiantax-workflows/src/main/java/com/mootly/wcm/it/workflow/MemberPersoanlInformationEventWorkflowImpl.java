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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.Session;
import javax.jcr.Value;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.hippoecm.repository.api.Document;
import org.hippoecm.repository.api.MappingException;
import org.hippoecm.repository.api.WorkflowException;
import org.hippoecm.repository.ext.WorkflowImpl;
import org.hippoecm.repository.standardworkflow.WorkflowEventWorkflow;



@PersistenceCapable
public class MemberPersoanlInformationEventWorkflowImpl extends WorkflowImpl implements WorkflowEventWorkflow {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
    private final static String SVN_ID = "$Id: WorkflowEventsWorkflowImpl.java 29256 2011-08-01 14:36:36Z bvanhalderen $";

	@Persistent(column="mootlywcm:pi_first_name")
	String firstName;
	@Persistent(column="mootlywcm:pi_last_name")
	String lastName;
	@Persistent(column="mootlywcm:pi_middle_name")
	String middleName;
	
	@Persistent(column="mootlywcm:pi_father_name")
	String fatherName;

	@Persistent(column="mootlywcm:pi_pan")
	String pan;

	@Persistent(column="mootlywcm:pi_email")
	String email;
	
	@Persistent(column="mootlywcm:pi_mobile")
	String mobile;
	
    public MemberPersoanlInformationEventWorkflowImpl() throws RemoteException {
    }

    public void fire() throws WorkflowException, MappingException {
    	System.err.println("Email Message Request Received..");
    	System.err.print("go green"+email);
    	try{
    	Session rootSession = getWorkflowContext().getInternalWorkflowSession();
    	Node memberGroupNode = getWorkflowContext().getInternalWorkflowSession().getNode("/hippo:configuration/hippo:groups/member");
    	if (memberGroupNode != null) {
			
			//changes -- "member" to unverified member
			
			
		}
    	}
    	catch(Exception e){
    		System.out.print("This is workflow Exception"+e);
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
