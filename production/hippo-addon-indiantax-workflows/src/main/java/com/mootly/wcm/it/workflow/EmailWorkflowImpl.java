package com.mootly.wcm.it.workflow;

import java.rmi.RemoteException;

import javax.jcr.RepositoryException;

import org.hippoecm.repository.api.MappingException;
import org.hippoecm.repository.api.RepositoryMap;
import org.hippoecm.repository.api.WorkflowException;
import org.hippoecm.repository.ext.WorkflowImpl;

public class EmailWorkflowImpl extends WorkflowImpl implements EmailWorkflow {
	String smtp;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailWorkflowImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sendEmail(String emailKey,String[] to,String[] cc,String[] bcc) throws WorkflowException,
			MappingException, RepositoryException {
		System.out.println("SMTP SERVER:" + smtp);
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		RepositoryMap repositoryMap =  getWorkflowContext().getWorkflowConfiguration();		
		Object objPrefix = repositoryMap.get("emailKey");
		if (objPrefix != null && objPrefix instanceof String) {
			System.out.println("OBJ PREFIX:" + objPrefix);
		}
		System.out.println("Will send Email Now");
	}
}
