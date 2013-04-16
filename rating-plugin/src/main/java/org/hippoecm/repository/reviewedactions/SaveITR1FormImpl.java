package org.hippoecm.repository.reviewedactions;

import java.rmi.RemoteException;

import javax.jcr.RepositoryException;
import javax.jdo.annotations.DatastoreIdentity;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.hippoecm.repository.api.WorkflowException;
import org.hippoecm.repository.ext.WorkflowImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PersistenceCapable
@DatastoreIdentity
public class SaveITR1FormImpl extends WorkflowImpl   implements SaveITR1Form {
	private static final Logger log = LoggerFactory.getLogger(SaveITR1FormImpl.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Persistent(column="mootlywcm:pi_first_name")
	String pi_first_name;
	
	/**
	 * 
	 * @throws RemoteException
	 */
	public SaveITR1FormImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 */
	@Override
	public void update(String firstName) throws WorkflowException,RepositoryException {
		// TODO Auto-generated method stub
		pi_first_name = firstName;
	}

}
