package org.hippoecm.repository.reviewedactions;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jdo.annotations.DatastoreIdentity;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.hippoecm.repository.api.Document;
import org.hippoecm.repository.api.MappingException;
import org.hippoecm.repository.api.WorkflowException;
import org.hippoecm.repository.standardworkflow.WorkflowEventWorkflow;

@PersistenceCapable
@DatastoreIdentity
public class MemberSignupPublished implements WorkflowEventWorkflow  {
	//private static final Logger log = LoggerFactory.getLogger(MemberSignupPublished.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Persistent(column="mootlywcm:userName")
	String userName;
	@Persistent(column="mootlywcm:password")
	String password;
	@Persistent(column="mootlywcm:firstName")
	String firstName;
	@Persistent(column="mootlywcm:lastName")
	String lastName;
	
	@Override
	public Map<String, Serializable> hints() throws WorkflowException,
			RemoteException, RepositoryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fire() throws WorkflowException, MappingException,
			RepositoryException, RemoteException {
		// TODO Auto-generated method stub
		//log.error("firstName:" + firstName);
	}

	@Override
	public void fire(Document document) throws WorkflowException,
			MappingException, RepositoryException, RemoteException {
		// TODO Auto-generated method stub
		//log.error("firstName:" + firstName);
	}

	@Override
	public void fire(Iterator<Document> documents) throws WorkflowException,
			MappingException, RepositoryException, RemoteException {
		// TODO Auto-generated method stub
		
	}
	
}
