package com.mootly.wcm.it.workflow;

import javax.jcr.RepositoryException;

import org.hippoecm.repository.api.MappingException;
import org.hippoecm.repository.api.Workflow;
import org.hippoecm.repository.api.WorkflowException;

public interface EmailWorkflow extends Workflow {
	void sendEmail(String emailKey,String[] to,String[] cc,String[] bcc) throws WorkflowException, MappingException,RepositoryException;
}
