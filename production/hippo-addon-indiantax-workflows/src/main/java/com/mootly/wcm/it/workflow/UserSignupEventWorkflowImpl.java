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
import javax.jcr.NodeIterator;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.Value;
import javax.jcr.query.Query;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.hippoecm.repository.api.Document;
import org.hippoecm.repository.api.MappingException;
import org.hippoecm.repository.api.WorkflowException;
import org.hippoecm.repository.ext.WorkflowImpl;
import org.hippoecm.repository.standardworkflow.WorkflowEventWorkflow;

@PersistenceCapable
public class UserSignupEventWorkflowImpl extends WorkflowImpl implements WorkflowEventWorkflow {
	//private final Logger log = LoggerFactory.getLogger(WorkflowEventsWorkflowImpl.class);

	private final static String SELECT_USER_QUERY = "SELECT * FROM hipposys:user WHERE fn:name()='{}'";
	private final static String SELECT_PASSWORD_QUERY = "SELECT * FROM mootlywcm:membersignupdocument WHERE mootlywcm:password='pwd'";
	private final static String SELECT_GROUPS_QUERY = "SELECT * FROM hipposys:group WHERE jcr:primaryType='hipposys:group' AND hipposys:members='{}'";

	private final static String SELECT_USER_FOR_GROUP_QUERY = "SELECT * FROM hipposys:group WHERE jcr:primaryType='hipposys:group' and fn:name()= '{groupname}' AND hipposys:members='{}'";

	private final static String SELECT_GROUP_QUERY = "SELECT * FROM hipposys:group WHERE jcr:primaryType='hipposys:group' AND fn:name='{}'";
	/**
	 * By abhishek
	 * this code will run workflow to activate user account
	 * 30/01/2013
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private final static String SVN_ID = "$Id: WorkflowEventsWorkflowImpl.java 29256 2011-08-01 14:36:36Z bvanhalderen $";

	@Persistent(column="mootlywcm:userName")
	String userName;
	@Persistent(column="mootlywcm:password")
	String password;
	@Persistent(column="mootlywcm:firstName")
	String firstName;
	@Persistent(column="mootlywcm:lastName")
	String lastName;
	@Persistent(column="mootlywcm:email")
	String email;
	@Persistent(column="mootlywcm:isActive")
	Boolean active;

	public UserSignupEventWorkflowImpl() throws RemoteException {
	}

	public void fire() throws WorkflowException, MappingException {
		@SuppressWarnings("unused")
		boolean isNew = false;


		// when user clicks activation link

		if(active.equals(true)){

			try{
				Session rootSession = getWorkflowContext().getInternalWorkflowSession();
				Node memberGroupNode = getWorkflowContext().getInternalWorkflowSession().getNode("/hippo:configuration/hippo:groups/member");

				if (memberGroupNode != null) {

					//changes -- "member" to unverified member

					Node theGroupNode = getGroupByUserName(rootSession,"members",userName);

					if (theGroupNode == null) {

						//user is not member of this group add it

						List<Value> newValues = new ArrayList<Value>();
						Value[] oldValues = memberGroupNode.getProperty("hipposys:members").getValues();
						if (oldValues != null) {
							for (Value aValue:oldValues) {

								newValues.add(aValue);
							}
						}
						Value newValue = rootSession.getValueFactory().createValue(userName);
						newValues.add(newValue);
						memberGroupNode.getProperty("hipposys:members").setValue(newValues.toArray(new Value[newValues.size()]));
					}
				}
				//for set  flag true in users list(this will allow user to login with his/her userName & password)

				Node userNode =getUserNode(getWorkflowContext().getInternalWorkflowSession(),userName); //getWorkflowContext().getInternalWorkflowSession().getNode("/hippo:configuration/hippo:users/" + userName); //getUserNode(getWorkflowContext().getInternalWorkflowSession(),userName);
				if (userNode != null) {
					userNode.setProperty("hipposys:active", true);
				}
			}
			//remove the user from unverified ...

			catch(Exception e){
				System.out.println("this is exception in member "+e);
			} 	
		}
		// else when user is new

		else{
			try {
				System.out.println("inside else:-");
				Node userNode = getUserNode(getWorkflowContext().getInternalWorkflowSession(),userName);
				Session rootSession = getWorkflowContext().getInternalWorkflowSession();
				if (userNode == null) {

					isNew = true;
					//getWorkflowContext().getDocument(category, identifier)
					Node aNode = getWorkflowContext().getInternalWorkflowSession().getNode("/hippo:configuration/hippo:users");
					if (aNode != null) {
						userNode = aNode.addNode(userName);
						userNode.setPrimaryType("hipposys:user");
					}
					//getWorkflowContext().getInternalWorkflowSession().save();
				}
				if (userNode != null) {
					boolean isSystem = false;
					if (userNode.hasProperty("hipposys:system")) {
						isSystem = userNode.getProperty("hipposys:system").getBoolean();
					}
					if (!isSystem) {
						//changes -- rendering active as false 
						userNode.setProperty("hipposys:active", false);
						userNode.setProperty("hipposys:password", password);
						userNode.setProperty("hipposys:securityprovider", "internal");
						userNode.setProperty("hipposys:system", false);

						userNode.setProperty("hipposys:firstname", firstName);
						userNode.setProperty("hipposys:lastname", lastName);
						userNode.setProperty("hipposys:email", email);

						Node memberGroupNode = getWorkflowContext().getInternalWorkflowSession().getNode("/hippo:configuration/hippo:groups/unverifiedmember");

						if (memberGroupNode != null) {

							//changes -- "member" to unverified member

							Node theGroupNode = getGroupByUserName(rootSession,"members",userName);

							if (theGroupNode == null) {

								//user is not member of this group add it

								List<Value> newValues = new ArrayList<Value>();
								Value[] oldValues = memberGroupNode.getProperty("hipposys:members").getValues();
								if (oldValues != null) {
									for (Value aValue:oldValues) {
										newValues.add(aValue);
									}
								}
								Value newValue = rootSession.getValueFactory().createValue(userName);
								newValues.add(newValue);
								memberGroupNode.getProperty("hipposys:members").setValue(newValues.toArray(new Value[newValues.size()]));
							}
						}


					}

				}
			}catch (RepositoryException rex) {

			}
		}
	}

	public void fire(Document document) throws WorkflowException, MappingException {
		System.err.println("document "+document.getIdentity()+" has published");

		System.err.println("FIRE DOCUMENT ---- User Name:" + userName + " GOT PUBLISHED");
	}

	public void fire(Iterator<Document> documentIterator) throws WorkflowException, MappingException {
		while(documentIterator.hasNext()) {
			Document document = documentIterator.next();
			System.err.println("documents "+document.getIdentity()+" has published");
		}
	}

	private static Node getUserNode(Session session,String userName) throws RepositoryException {
		try {
			Node node = session.getNode("/hippo:configuration/hippo:users/" + userName);
			return node;
		}catch (PathNotFoundException pne) {
			pne.printStackTrace();
		}
		return null;
		/*
		String selectUserStatement = SELECT_USER_QUERY.replace("{}", userName);
		@SuppressWarnings("deprecation")
		Query selectUserQuery = session.getWorkspace().getQueryManager().createQuery(selectUserStatement, Query.SQL);
		NodeIterator usersIterator = selectUserQuery.execute().getNodes();
		if (usersIterator.hasNext()) {
			return usersIterator.nextNode();
		}
		return null;
		*/
	}
	public static Node getUserNodePass(Session session,String mpassword) throws RepositoryException {
		String selectUserStatement = SELECT_PASSWORD_QUERY.replace("pwd", mpassword);
		@SuppressWarnings("deprecation")
		Query selectUserQuery = session.getWorkspace().getQueryManager().createQuery(selectUserStatement, Query.SQL);
		NodeIterator usersIterator = selectUserQuery.execute().getNodes();
		if (usersIterator.hasNext()) {
			return usersIterator.nextNode();
		}
		return null;
	}

	private static Node getGroupByUserName(Session session,String groupName,String userName) throws RepositoryException {
		String selectUserStatement = SELECT_USER_FOR_GROUP_QUERY.replace("{}", userName);
		selectUserStatement = SELECT_USER_FOR_GROUP_QUERY.replace("{groupname}", groupName);
		@SuppressWarnings("deprecation")
		Query selectUserQuery = session.getWorkspace().getQueryManager().createQuery(selectUserStatement, Query.SQL);
		NodeIterator usersIterator = selectUserQuery.execute().getNodes();
		if (usersIterator.hasNext()) {
			return usersIterator.nextNode();
		}
		return null;
	}

	@SuppressWarnings("unused")
	private static NodeIterator getGroupNodes(Session session,String userName) throws RepositoryException {
		String selectGroupsStatement = SELECT_GROUPS_QUERY.replace("{}", userName);
		@SuppressWarnings("deprecation")
		Query selectGroupsQuery = session.getWorkspace().getQueryManager().createQuery(selectGroupsStatement, Query.SQL);
		return selectGroupsQuery.execute().getNodes();
	}

	@SuppressWarnings("unused")
	private static List<Node> getDefaultGroupNodes(Session session,String[] defaultGroups) throws RepositoryException {
		List<Node> defaultGroupNodes = new ArrayList<Node>();
		for (String defaultGroup:defaultGroups) {
			String selectGroupStatement = SELECT_GROUP_QUERY.replace("{}", defaultGroup);
			@SuppressWarnings("deprecation")
			Query selectGroupQuery = session.getWorkspace().getQueryManager().createQuery(selectGroupStatement, Query.SQL);
			NodeIterator groupIterator = selectGroupQuery.execute().getNodes();
			if (groupIterator.hasNext()) {
				defaultGroupNodes.add( groupIterator.nextNode() );
			}
		}
		return defaultGroupNodes;
	}
}
