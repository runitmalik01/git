package org.hippoecm.repository.reviewedactions;

import javax.jcr.RepositoryException;

import org.hippoecm.repository.api.Workflow;
import org.hippoecm.repository.api.WorkflowException;

public interface SaveITR1Form extends Workflow {
	void update(String firstName) throws WorkflowException,RepositoryException;
}
